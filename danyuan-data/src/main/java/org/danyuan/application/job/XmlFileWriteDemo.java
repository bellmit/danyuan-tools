package org.danyuan.application.job;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @文件名 XmlFileWriteDemo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月4日 上午10:30:16
 * @author Administrator
 * @版本 V1.0
 */
@Component
public class XmlFileWriteDemo implements ItemWriter<Depent> {
	
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
	public void write(List<? extends Depent> items) throws Exception {
		for (Depent depent : items) {
			System.out.println(depent);
		}
	}

}
