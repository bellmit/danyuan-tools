package org.danyuan.application.job;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @文件名 JdbcItemWriter.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月1日 下午4:24:46
 * @author Administrator
 * @版本 V1.0
 */
@Configuration
public class JdbcItemWriter {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcBatchItemWriter<XiaoShuo> dbItemWriter() {

		JdbcBatchItemWriter<XiaoShuo> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource);
		writer.setSql("insert into xiao_suo(id,name_string,auther_string,msg_string,instro_string,url_string,pic_string) values"
		        //
		        + "(:id,:nameString,:autherString,:msgString,:instroString,:urlString,:picString)");
		
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<XiaoShuo>());
		
		return writer;
		
	}
}
