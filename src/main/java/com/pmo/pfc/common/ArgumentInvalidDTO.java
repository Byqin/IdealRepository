package com.pmo.pfc.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArgumentInvalidDTO {

    private String field;
    private String defaultMessage;
    private Object rejectedValue;

}
