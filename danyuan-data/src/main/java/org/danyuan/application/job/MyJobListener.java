package org.danyuan.application.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @文件名 MyJobLisener.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年10月31日 下午3:11:19
 * @author Administrator
 * @版本 V1.0
 */
public class MyJobListener implements JobExecutionListener {

	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 afterJob
	 * @参数 @param arg0
	 * @参考 @see org.springframework.batch.core.JobExecutionListener#afterJob(org.springframework.batch.core.JobExecution)
	 * @author Administrator
	 */
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getJobInstance().getJobName() + " be....");
		
	}

	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 beforeJob
	 * @参数 @param arg0
	 * @参考 @see org.springframework.batch.core.JobExecutionListener#beforeJob(org.springframework.batch.core.JobExecution)
	 * @author Administrator
	 */
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getJobInstance().getJobName() + " af....");
	}
	
}
