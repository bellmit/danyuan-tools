package org.danyuan.application.jsontomap;

import java.io.File;

import org.danyuan.application.jsontomap.config.UserConfig;
import org.danyuan.application.jsontomap.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App implements ApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@RequestMapping(value = "/")
	String hello() {
		return "Hello World!";
	}
	
	@Autowired
	UserConfig		userConfig;
	
	@Autowired
	ParserService	parserService;
	
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
		// 专利信息字典信息读取到内纯中做全局变量,如果没有读取到就自动生成并且解析部分数据生成字典到dic
		
		System.out.println(userConfig.toString());
		
		File dic = new File(userConfig.getDic());
		if (!dic.exists()) {
			dic.mkdirs();
		} else {
			// 读取dic中的字典
		}
		
		// String jsonStr = TxtFilesReader.readToString(userConfig.getPath() + "翻译.txt", "UTF-8");
		// System.out.println(jsonStr);
		//
		// parserService.paserPatent(jsonStr);
		// List<String> jsonStrs = TxtFilesReader.readFileByLines(userConfig.getPath() + "深圳新宙邦科技股份有限公司 - 副本.txt");
		// for (String string : jsonStrs) {
		// if ("".equals(string)) {
		// continue;
		// }
		// parserService.paserPatentListStr(string);
		// }
		//
		// List<String> jsonStrs2 = TxtFilesReader.readFileByLines(userConfig.getPath() + "张家港市国泰华荣化工新材料有限公司 - 副本.txt", "GB2312");
		// for (String string : jsonStrs2) {
		// if ("".equals(string)) {
		// continue;
		// }
		// parserService.paserPatentListStr(string);
		// }
		
	}
}