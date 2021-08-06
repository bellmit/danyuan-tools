package org.danyuan.application.job;

import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @文件名 MyItemWriterDemo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月1日 上午10:31:03
 * @author Administrator
 * @版本 V1.0
 */
@Component
public class MyItemWriterDemo implements ItemWriter<Map<String, Object>> {

	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 write
	 * @参数 @param arg0
	 * @参数 @throws Exception
	 * @参考 @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 * @author Administrator
	 */
	
	@Override
	public void write(List<? extends Map<String, Object>> items) throws Exception {
		for (Map<String, Object> sysUserBaseInfo : items) {
			System.out.println(sysUserBaseInfo.toString());
		}
		
	}

}
