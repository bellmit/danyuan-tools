package org.danyuan.application.dic.ajfx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 文件名 ： LoadDic.java
 * 包 名 ： org.danyuan.application.dic.ajfx.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年9月9日 下午3:31:25
 * 版 本 ： V1.0
 */
@Component
public class LoadDic implements ApplicationRunner {
	
	@Autowired
	AjfxLoadDicService ajfxLoadDicService;
	
	/**
	 * 方法名 ： run
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param args
	 * 参 数 ： @throws Exception
	 * 参 考 ： @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 * 作 者 ： Administrator
	 */
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 案件分析字典导入
		// ajfxLoadDicService.loadDics();
		
	}
	
}
