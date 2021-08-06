package org.danyuan.application.job;

import java.util.Arrays;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @文件名 MultiFileItemWriteDemo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月4日 上午11:17:52
 * @author Administrator
 * @版本 V1.0
 */
@Configuration
public class MultiFileItemWriteDemo {

	@Autowired
	@Qualifier("xlmFileWrite")
	private StaxEventItemWriter<SysUserBaseInfo>	xlmFileWrite;

	@Autowired
	@Qualifier("myFlatFileItemWriter")
	private FlatFileItemWriter<SysUserBaseInfo>		myFlatFileItemWriter;
	
	@Bean
	public CompositeItemWriter<SysUserBaseInfo> multifileItermWrite() throws Exception {
		CompositeItemWriter<SysUserBaseInfo> writer = new CompositeItemWriter<>();
		writer.setDelegates(Arrays.asList(xlmFileWrite, myFlatFileItemWriter));
		writer.afterPropertiesSet();
		return writer;
	}
}
