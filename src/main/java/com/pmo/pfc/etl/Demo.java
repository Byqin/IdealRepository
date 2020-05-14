package com.pmo.pfc.etl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.launch.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class Demo  {

    /**
     * 用于执行job的
     */
    @Resource
    private JobLauncher jobLauncher;

    /**
     * job的工具类，可以启动，停止，查询job中的任务，以及job的id
     */
    @Resource
    private JobOperator jobOperator;

    /**
     * job构造工厂
     */
    @Resource
    private JobBuilderFactory jobBuilderFactory;

    /**
     * 任务构造工厂
     */
    @Resource
    private StepBuilderFactory stepBuilderFactory;

    /**
     * jon注册服务中心（管理job的），内存方式存储，
     */
    @Resource
    private JobRegistry jobRegistry;

    private volatile AtomicInteger atomicInteger = new AtomicInteger(10);

    public void testRUN(){

        try {
            long batchId = System.currentTimeMillis();
            /**
             * JdbcJobExecutionDao batch任务的查询语句在这个里面
             */
            String jobName = "jobName";
            try{
                // 找不到运行的job会抛出NoSuchJobException
                Set<Long> executions = jobOperator.getRunningExecutions(jobName);
                //job未运行状态，其下的任务是运行状态的情况是无法停止任务状态的（这种情况发生在任务在执行的时候程序突然关闭），
                //这种情况需要手动或程序来修改batch_job_execution（END_TIME，STATUS），batch_step_execution（STATUS，END_TIME）最好把失败原因也记录
                if(!executions.isEmpty()){
                    jobOperator.stop(executions.iterator().next());
                }
            }catch (NoSuchJobException e){
                log.info("No such job (either in registry or in historical data): "+jobName);
            }

            // 构造出来的是单线程TaskStep
            Step step = stepBuilderFactory.get("step1")
                    .chunk(100)
                    //.listener()
                    .reader(()->{
                        log.info("========reader=======");
                        int i  = atomicInteger.decrementAndGet();
                        if(i <= 0){
                            return null;
                        }
                        return i;
                    }).processor((item)->{
                        log.info("====== "+item+"=============");
                        return item;
                    }).writer(items -> log.info("===== write : "+items.get(0)+"======"))
                    .build();
            FlowBuilder<FlowJobBuilder> flowBuilder = jobBuilderFactory.get(jobName)
                    .incrementer(new RunIdIncrementer())
                    .flow(step);

            Job job =  flowBuilder.end().build();
            // batchId 用作为job_instance_id
            JobExecution jobExecution = jobLauncher.run(job,new JobParametersBuilder().addLong("batchId",batchId).addLong("jobId",1l)
                                .toJobParameters());

            if(jobExecution.getStatus().isUnsuccessful()){
                log.info("失败");
            }else{
                log.info("完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
