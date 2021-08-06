package org.danyuan.application.job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.validation.BindException;

/**
 * @文件名 MytestReder.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月1日 上午9:54:55
 * @author Administrator
 * @版本 V1.0
 */
@Configuration
public class MytestReder {

	// 负责创建任务
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	// 负责创建step 任务由step决定
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("dbItemWriter")
	private JdbcBatchItemWriter<XiaoShuo> dbItemWriter;

	@Autowired
	@Qualifier("myFlatFileItemWriter")
	private FlatFileItemWriter<SysUserBaseInfo> myFlatFileItemWriter;

	@Autowired
	@Qualifier("xmlFileWriteDemo")
	private XmlFileWriteDemo xmlFileWriteDemo;

	@Autowired
	@Qualifier("xlmFileWrite")
	private StaxEventItemWriter<SysUserBaseInfo> xlmFileWrite;

	@Autowired
	private CompositeItemWriter<SysUserBaseInfo> multifileItermWrite;

	// 创建job 数据库读取
	@Bean
	public Job itemReadJobemo() {

		return jobBuilderFactory
				// 名称是job的标识符，
				.get("itemReadJobemo")
				// 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
				.incrementer(new RunIdIncrementer())
				// 添加step
				.start(itemReadstepDemo())
				//
				.build();
	}

	/**
	 * @方法名 itemReadstepDemo @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回 Step @author
	 *      Administrator @throws
	 */
	@Bean
	public Step itemReadstepDemo() {
		return stepBuilderFactory.get("itemReadstepDemo")
				// 创建 tasklet 或者chunk（itemread，itemprocess，itemwrite）
				.<SysUserBaseInfo, SysUserBaseInfo>chunk(2)
				// 读取对象
				.reader(itemReaderDemo())
				// 测试输出
//		        .writer(myItemWriterDemo)
				// 自定义输出到文件
//		        .writer(myFlatFileItemWriter)
				// 自定义输出到xml中
//		        .writer(xlmFileWrite)
				// 输出到多个文件
				.writer(multifileItermWrite)
				//
				.build();
	}

	/**
	 * @方法名 itemReaderDemo @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回 ItemReader<?
	 *      extends String> @author Administrator @throws
	 */
	@Bean
	@StepScope
	public JdbcPagingItemReader<SysUserBaseInfo> itemReaderDemo() {
		JdbcPagingItemReader<SysUserBaseInfo> reader = new JdbcPagingItemReader<>();
		// 设置数据源
		reader.setDataSource(dataSource);
		// 每次读取记录数
		reader.setFetchSize(2);

		// 结果映射对象
		reader.setRowMapper(new RowMapper<SysUserBaseInfo>() {

			@Override
			public SysUserBaseInfo mapRow(ResultSet rs, int rownum) throws SQLException {
				SysUserBaseInfo info = new SysUserBaseInfo();
				info.setUserName(rs.getString(1));
				info.setPassword(rs.getString(2));
				info.setAge(rs.getInt(3));
				info.setEducation(rs.getString(4));
				info.setEmail(rs.getString(5));
				return info;
			}
		});
		// 指定查询语句
		MySqlPagingQueryProvider pagingQueryProvider = new MySqlPagingQueryProvider();
		pagingQueryProvider.setSelectClause("user_name,password,age,education,email");
		pagingQueryProvider.setFromClause(" From sys_user_base_info");
		// 排序
		Map<String, Order> sort = new HashMap<>();
		sort.put("age", Order.ASCENDING);
		pagingQueryProvider.setSortKeys(sort);

		//
		reader.setQueryProvider(pagingQueryProvider);

		return reader;
	}

	// 创建job 文件读取
	@Bean
	public Job fileReadJobemo() {

		return jobBuilderFactory
				// 名称是job的标识符，
				.get("fileReadJobemo")
				// 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
				.incrementer(new RunIdIncrementer())
				// 添加step
				.start(fileReadstepDemo())
				//
				.build();
	}

	/**
	 * @方法名 fileReadstepDemo @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回 Step @author
	 *      Administrator @throws
	 */
	@Bean
	public Step fileReadstepDemo() {
		return stepBuilderFactory.get("fileReadstepDemo")
				//
				.<XiaoShuo, XiaoShuo>chunk(100)
				// flatfileitemreader 读取文件
				.reader(flatFileItemReader())
				//
//		        .writer(flatFileItemWriter)
				// 自定义输出到数据库
				.writer(dbItemWriter)

				//
				.build();
	}

	/**
	 * @方法名 flatFileItemReader @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回
	 *      ItemReader<? extends Object> @author Administrator @throws
	 */
	@Bean
	@StepScope
	public FlatFileItemReader<XiaoShuo> flatFileItemReader() {
		FlatFileItemReader<XiaoShuo> reader = new FlatFileItemReader<>();
		// 从那个文件读取
		reader.setResource(new ClassPathResource("小说大全.csv"));
		// 从那两个位置读取 -跳过前几行
		reader.setLinesToSkip(1);

		// 映射数据对象
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames(
				new String[] { "nameString", "autherString", "msgString", "instroString", "urlString", "picString" });
		//
		DefaultLineMapper<XiaoShuo> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		lineMapper.setFieldSetMapper(new FieldSetMapper<XiaoShuo>() {

			@Override
			public XiaoShuo mapFieldSet(FieldSet fieldSet) throws BindException {
				XiaoShuo xiaoShuo = new XiaoShuo();
				xiaoShuo.setId(UUID.randomUUID().toString());
				xiaoShuo.setNameString(fieldSet.readString("nameString"));
				xiaoShuo.setAutherString(fieldSet.readString("autherString"));
				xiaoShuo.setMsgString(fieldSet.readString("msgString"));
				xiaoShuo.setInstroString(fieldSet.readString("instroString"));
				xiaoShuo.setUrlString(fieldSet.readString("urlString"));
				xiaoShuo.setPicString(fieldSet.readString("picString"));
				return xiaoShuo;
			}
		});
		lineMapper.afterPropertiesSet();
		reader.setLineMapper(lineMapper);
		return reader;
	}

	// 创建job xml读取
	@Bean
	public Job xmlReadJobemo() {

		return jobBuilderFactory
				// 名称是job的标识符，
				.get("xmlReadJobemo")
				// 新增incrementer(new RunIdIncrementer())的配置使每个job的运行id都唯一
				.incrementer(new RunIdIncrementer())
				// 添加step
				.start(xmlReadstepDemo())
				//
				.build();
	}

	/**
	 * @方法名 xmlReadstepDemo @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回 Step @author
	 *      Administrator @throws
	 */
	@Bean
	public Step xmlReadstepDemo() {
		return stepBuilderFactory.get("xmlReadstepDemo")
				//
				.<Depent, Depent>chunk(2)
				// 从xml文件中读
				.reader(xmlFileReadDemo())
				// 输出到xml
				.writer(xmlFileWriteDemo)

				//
				.build();
	}

	/**
	 * @方法名 xmlFileReadDemo @功能 TODO(这里用一句话描述这个方法的作用) @参数 @return @返回 ItemReader<?
	 *      extends Depent> @author Administrator @throws
	 */
	@Bean
	@StepScope
	public StaxEventItemReader<Depent> xmlFileReadDemo() {
		StaxEventItemReader<Depent> reader = new StaxEventItemReader<>();
		reader.setResource(new ClassPathResource("pom.xml"));
		// 指点根标签
		reader.setFragmentRootElementName("dependency");
		// 转xml 为对象
		XStreamMarshaller unMarshaller = new XStreamMarshaller();
		Map<String, Class<Depent>> map = new HashMap<>();
		map.put("dependency", Depent.class);
		unMarshaller.setAliases(map);

		reader.setUnmarshaller(unMarshaller);
		return reader;
	}

}
