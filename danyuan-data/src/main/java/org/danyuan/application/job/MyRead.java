package org.danyuan.application.job;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @文件名 MyRead.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年10月31日 下午5:00:59
 * @author Administrator
 * @版本 V1.0
 */
public class MyRead implements ItemReader<String> {

	private Iterator<String> iterater;
	
	public MyRead(List<String> list) {
		this.iterater = list.iterator();
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 read
	 * @参数 @return
	 * @参数 @throws Exception
	 * @参数 @throws UnexpectedInputException
	 * @参数 @throws ParseException
	 * @参数 @throws NonTransientResourceException
	 * @参考 @see org.springframework.batch.item.ItemReader#read()
	 * @author Administrator
	 */
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (iterater.hasNext()) {
			return iterater.next();
		} else {
			return null;
		}
	}
	
}
