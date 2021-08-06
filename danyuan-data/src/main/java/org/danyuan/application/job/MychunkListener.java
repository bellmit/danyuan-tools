package org.danyuan.application.job;

import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * @文件名 MychunkListener.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年10月31日 下午3:15:09
 * @author Administrator
 * @版本 V1.0
 */
@Component
public class MychunkListener {
	
	protected Map<String, JobParameter> params;
	
	@BeforeChunk
	public void beforeChunk(ChunkContext context) {
		// 给 job 传递参数
		
		System.out.println(context.getStepContext().getStepName() + " be....");
	}
	
	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		// 给 job 传递参数
		params = stepExecution.getJobParameters().getParameters();
	}
	
	@AfterChunk
	public void afterChunk(ChunkContext context) {
		System.out.println(context.getStepContext().getStepName() + " af....");
	}
}
