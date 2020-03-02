package com.pmo.pfc.web.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.pmo.pfc.common.ArgumentInvalidDTO;
import com.pmo.pfc.common.ResponseDTO;
import com.pmo.pfc.common.ResultCode;
import com.pmo.pfc.common.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@ControllerAdvice
@ResponseBody
@Slf4j
public class DefaultControllerAdvice {

    /**
     * 添加全局异常处理流程，根据需要设置需要处理的异常mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
     *
     * @param request   request
     * @param exception exception
     * @return BaseResponse
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String methodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception) {
        log.warn(request.getRequestURI() + " exception, params = " + JSON.toJSONString(request.getParameterMap()), exception);
        // 按需重新封装需要返回的错误信息
        List<ArgumentInvalidDTO> invalidArguments = Lists.newArrayList();
        // 解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        StringBuilder msg = new StringBuilder();
        msg.append("缺少参数").append(": ");
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidDTO argumentInvalidDTO = ArgumentInvalidDTO.builder()
                    .field(error.getField())
                    .defaultMessage(error.getDefaultMessage())
                    .rejectedValue(error.getRejectedValue())
                    .build();
            invalidArguments.add(argumentInvalidDTO);
            msg = msg.append(error.getDefaultMessage()).append(";");
        }

        return ResponseDTO.newInstance().failToString(ResultCode.PARAM_ERROR.getCode(),msg.toString());
    }

    @ExceptionHandler(value = SQLException.class)
    public String methodSQLHandler(HttpServletRequest request, SQLException exception) {
        log.warn(request.getRequestURI() + " exception, params = " + JSON.toJSONString(request.getParameterMap()), exception);
        ResponseDTO<String> fail = ResponseDTO.newInstance();
        fail.setData(JSON.toJSONString(exception.getErrorCode()));
        return fail.failToString(ResultCode.SQL_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public String handException(HttpServletRequest request, Exception e) {
        if (e instanceof ServiceException) {
            log.warn(request.getRequestURI() + " exception, params = " + JSON.toJSONString(request.getParameterMap()), e);
            return ResponseDTO.newInstance().failToString(((ServiceException) e).getCode(), ((ServiceException) e).getMsg());
        } else {
            log.error(request.getRequestURI() + " exception, params = " + JSON.toJSONString(request.getParameterMap()), e);
            ResponseDTO<String> fail = ResponseDTO.newInstance();
            fail.setData(e.getMessage());
            return fail.failToString(ResultCode.ERROR);
        }
    }

}
