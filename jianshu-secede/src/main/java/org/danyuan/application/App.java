package org.danyuan.application;

import org.danyuan.application.service.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements ApplicationRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	Runner runner;
	
	/**
	 * 方法名 ： run
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param args
	 * 参 数 ： @throws Exception
	 * 参 考 ： @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 * 作 者 ： wth
	 */
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		runner.exec();
	}
}