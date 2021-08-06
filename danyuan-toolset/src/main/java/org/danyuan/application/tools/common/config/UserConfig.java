package org.danyuan.application.tools.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "user")
public class UserConfig {
	// 开发者信息
	List<Developer> developers = new ArrayList<>();

	// 语言
	private String language;

	/**
	 * 返 回 : the developers
	 */
	public List<Developer> getDevelopers() {
		return developers;
	}

	/**
	 * 参 数 : developers the developers to set
	 */
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	/**
	 *
	*  方法名 ： toString
	*  功    能 ： TODO(这里用一句话描述这个方法的作用)
	*  参    数 ： @return
	*  参    考 ： @see java.lang.Object#toString()
	*  作    者 ： wth
	 */

	@Override
	public String toString() {
		return "UserConfig [developers=" + developers + ", language=" + language + "]";
	}


}
