package org.danyuan.application.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @文件名 DeciderDemo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年10月31日 下午2:38:41
 * @author Administrator
 * @版本 V1.0
 */
public class MyDecider implements JobExecutionDecider {
	
	private int count = 0;

	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 decide
	 * @参数 @param arg0
	 * @参数 @param arg1
	 * @参数 @return
	 * @参考 @see org.springframework.batch.core.job.flow.JobExecutionDecider#decide(org.springframework.batch.core.JobExecution, org.springframework.batch.core.StepExecution)
	 * @author Administrator
	 */
	
	@Override
	public FlowExecutionStatus decide(JobExecution arg0, StepExecution arg1) {
		count++;
		if (count % 2 == 0) {
			return new FlowExecutionStatus("even");
		} else {
			return new FlowExecutionStatus("odd");
		}
	}
	
}
