package org.danyuan.application.job;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.JobStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @文件名 MytestJob.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年10月31日 下午1:24:30
 * @author Administrator
 * @版本 V1.0
 */
@Configuration
public class MytestJob {
	
	// 负责创建任务
	@Autowired
	private JobBuilderFactory	jobBuilderFactory;
	
	// 负责创建step 任务由step决定
	@Autowired
	private StepBuilderFactory	stepBuilderFactory;

	@Autowired
	private JobLauncher			jobLauncher;

	@Autowired
	private MychunkListener		mychunkListener;
	
	// 创建job 入门
	@Bean
	public Job helloworldjob() {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("helloworldjob1")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加step
		        .start(step1())
		        //
		        .build();
	}
	
	/**
	 * @方法名 step1
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Step step1() {
		
		return stepBuilderFactory.get("step1")
		        // 创建 tasklet 或者chunk（itemread，itemprocess，itemwrite）
		        .tasklet(new Tasklet() {
			        @Override
			        public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
				        System.out.println("haee");
				        // 返回状态 finished标识执行完毕
				        return RepeatStatus.FINISHED;
			        }
		        }).build();
	}
	
	// 创建job 多step
	@Bean
	public Job jobDemo() {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("jobDemo")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加step
		        .start(stepDemo())
		        // 可添加多个 step 用next
		        .next(stepDemo2())
		        // 可添加多个 step 用next
		        .next(step1())
		        //
		        .build();
	}
	
	/**
	 * @方法名 stepDemo2
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 JobExecutionDecider
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Step stepDemo2() {
		return stepBuilderFactory.get("stepDemo2")
		        // 创建 tasklet 或者chunk（itemread，itemprocess，itemwrite）
		        .tasklet(new Tasklet() {
			        @Override
			        public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
				        System.out.println("stepDemo2");
				        // 返回状态 finished标识执行完毕
				        return RepeatStatus.FINISHED;
			        }
		        }).build();
	}
	
	/**
	 * @方法名 stepDemo
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Step stepDemo() {
		return stepBuilderFactory.get("stepDemo")
		        // 创建 tasklet 或者chunk（itemread，itemprocess，itemwrite）
		        .tasklet(new Tasklet() {
			        @Override
			        public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
				        System.out.println("stepDemo");
				        // 返回状态 finished标识执行完毕
				        return RepeatStatus.FINISHED;
			        }
		        }).build();
	}
	
	// 创建 job flow（ step集合）
	@Bean
	public Job flowjobDemo() {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("flowjobDemo")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(flowstepDemo())
		        //
		        .next(stepDemo2())
		        //
		        .end()
		        //
		        .build();
	}
	
	/**
	 * @方法名 flowstepDemo
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Flow flowstepDemo() {
		// 由flow 构建多个step集合
		return new FlowBuilder<Flow>("flowstepDemo")
		        //
		        .start(stepDemo2())
		        //
		        .next(step1())
		        //
		        .build();
	}
	
	// 创建 job split 异步
	@Bean
	public Job splitjobDemo() {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("splitjobDemo1")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(flowstepDemo())
		        // 并发使用 asynctask 添加step
		        .split(new SimpleAsyncTaskExecutor()).add(flowstepDemo2())
		        //
		        .end()
		        //
		        .build();
	}
	
	/**
	 * @方法名 flowstepDemo
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Flow flowstepDemo2() {
		// 由flow 构建多个step集合
		return new FlowBuilder<Flow>("flowstepDemo2")
		        //
		        .start(stepDemo())
		        //
		        .next(stepDemo2())
		        //
		        .build();
	}

	// 创建 job 决策器 decider
	@Bean
	public Job deciderjobDemo() {

		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("deciderjobDemo1")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(step1())
		        // 决策器
		        .next(myDecider())
		        //
		        .from(myDecider()).on("even").to(stepDemo())
		        //
		        .from(myDecider()).on("odd").to(stepDemo2())
		        //
		        .from(stepDemo2()).on("*").to(myDecider())
		        //
		        .end()
		        //
		        .build();
	}
	
	// 决策器
	@Bean
	public JobExecutionDecider myDecider() {
		return new MyDecider();
		
	}

	// 创建 job job嵌套
	@Bean
	public Job nestedjobDemo(JobRepository jobRepository, PlatformTransactionManager transactionManager) {

		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("nestedjobDemo")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(childJob1(jobRepository, transactionManager))
		        //
		        .next(childJob2(jobRepository, transactionManager))
		        //
		        .build();
	}

	/**
	 * @方法名 childJob2
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 JobExecutionDecider
	 * @author Administrator
	 * @throws
	 */
	private Step childJob2(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobStepBuilder(new StepBuilder("childJob2"))
		        // 将job转换step
		        .job(deciderjobDemo())
		        // 启动对象
		        .launcher(jobLauncher)
		        // repository 对象
		        .repository(jobRepository)
		        // 事务管理
		        .transactionManager(transactionManager)
		        //
		        .build();
	}

	/**
	 * @方法名 childJob1
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	private Step childJob1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobStepBuilder(new StepBuilder("childJob1"))
		        // 将job转换step
		        .job(splitjobDemo())
		        // 启动对象
		        .launcher(jobLauncher)
		        // repository 对象
		        .repository(jobRepository)
		        // 事务管理
		        .transactionManager(transactionManager)
		        //
		        .build();
	}
	
	// 创建 job Listener
	@Bean
	public Job listenerjobDemo(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("listenerjobDemo")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(listenerStep())
		        // 添加监听
		        .listener(new MyJobListener())
		        //
		        .build();
	}
	
	/**
	 * @方法名 listenerStep
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Step listenerStep() {
		return stepBuilderFactory.get("stepDemo")
		        // 创建 tasklet 或者chunk（itemread，itemprocess，itemwrite）
		        .<String, String> chunk(2)
		        // 容错
		        .faultTolerant()
		        // 添加监听
		        .listener(mychunkListener)
		        //
		        .reader(reader())
		        //
		        .writer(writer())
		        //
		        .build();
	}

	/**
	 * @方法名 writer
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 ItemWriter<? super String>
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public ItemWriter<String> writer() {

		return new ItemWriter<String>() {
			@Override
			public void write(List<? extends String> items) throws Exception {
				for (String string : items) {
					System.out.println(string);
				}
				System.out.println(mychunkListener.params);
			}
		};
	}

	/**
	 * @方法名 reader
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 ItemReader<? extends Object>
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public ItemReader<String> reader() {
		return new ListItemReader<>(Arrays.asList("java", "php", "myss"));
	}

	// 创建 job itemread
	@Bean
	public Job itemreadjobDemo() {
		
		return jobBuilderFactory
		        // 名称是job的标识符，
		        .get("itemreadjobDemo")
		        // 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
		        .incrementer(new RunIdIncrementer())
		        // 添加 flow
		        .start(itemreadstepDemo())
		        //
		        .build();
	}

	/**
	 * @方法名 itemreadstepDemo
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 Step
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public Step itemreadstepDemo() {
		return stepBuilderFactory.get("itemreadstepDemo")
		        //
		        .<String, String> chunk(2)
		        // 自定义读取
		        .reader(myRead())
		        //
		        .writer(list -> {
			        for (String string : list) {
				        System.out.println(string);
			        }
		        }).build();
	}
	
	/**
	 * @方法名 myRead
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @return
	 * @返回 ItemReader<? extends String>
	 * @author Administrator
	 * @throws
	 */
	@Bean
	public MyRead myRead() {
		List<String> list = Arrays.asList("张三", "李四", "王五", "赵六");
		return new MyRead(list);
	}
	
}
