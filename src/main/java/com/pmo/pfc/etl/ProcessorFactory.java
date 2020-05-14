package com.pmo.pfc.etl;

import com.google.common.collect.Lists;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.Validator;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProcessorFactory<I,O> {

    private ProcessorFactory(){}

    public static <I,O> CompositeItemProcessor<Map<String,String>,Map<String,String>>
                                        processor(Validator<I> validator,//校验器
                                              ItemProcessor<I,O> processor //后置处理
                                            ){
        return processor(null,validator,processor);
    }

    public static <I,O> CompositeItemProcessor<Map<String,String>,Map<String,String>>
                                                processor(ItemProcessor<I,O> prepareProcessor,//前置处理
                                                        Validator<I> validator,//校验器
                                                        ItemProcessor<I,O> processor //后置处理
                                                         ){
        List<ItemProcessor<I,O>> list = Collections.singletonList(processor);
        return processor(prepareProcessor,validator,list);
    }

    public static <I,O> CompositeItemProcessor<Map<String,String>,Map<String,String>>
                                                    processor(ItemProcessor<I,O> prepareProcessor,//前置处理
                                                         Validator<I> validator,//校验器
                                                         List<ItemProcessor<I,O>> processors //后置处理
                                                        ){

        try {
            List<ItemProcessor<I,O>> list = Lists.newArrayList();
            ValidatingItemProcessor<I> dataValidateItemProcess = new ValidatingItemProcessor<>(validator);
            if(prepareProcessor != null){
                list.add(prepareProcessor);
            }
            list.addAll(processors);
            //创建代理处理对象
            CompositeItemProcessor<Map<String,String>,Map<String,String>> compositeItemProcessor = new  CompositeItemProcessor<>();
            compositeItemProcessor.setDelegates(list);
            dataValidateItemProcess.afterPropertiesSet();
            return compositeItemProcessor;
        } catch (Exception e) {
            throw  new IllegalStateException("create compositeItemProcessor error",e);
        }
    }
}
