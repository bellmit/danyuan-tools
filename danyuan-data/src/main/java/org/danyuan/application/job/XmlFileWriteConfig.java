package org.danyuan.application.job;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

/**
 * @文件名 XmlFileWrite.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月4日 上午10:39:43
 * @author Administrator
 * @版本 V1.0
 */
@Configuration
public class XmlFileWriteConfig {

	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 write
	 * @参数 @param arg0
	 * @参数 @throws Exception
	 * @参考 @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 * @author Administrator
	 */

	@Bean
	public StaxEventItemWriter<SysUserBaseInfo> xlmFileWrite() throws Exception {
		StaxEventItemWriter<SysUserBaseInfo> writer = new StaxEventItemWriter<>();

		XStreamMarshaller marshaller = new XStreamMarshaller();
		Map<String, Class<SysUserBaseInfo>> aliases = new HashMap<>();
		aliases.put("user", SysUserBaseInfo.class);
		marshaller.setAliases(aliases);

		writer.setRootTagName("users");
		writer.setMarshaller(marshaller);
		String pathString = "F://user.xml";
		File file = new File(pathString);

		if (!file.exists()) {
			file.createNewFile();
		}
		writer.setResource(new FileSystemResource(pathString));
		writer.afterPropertiesSet();
		return writer;
	}

}
