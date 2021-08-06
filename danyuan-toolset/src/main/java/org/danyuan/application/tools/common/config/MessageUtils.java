package org.danyuan.application.tools.common.config;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

/**
 * 国际化工具类
 */
@Component
public class MessageUtils {

	private ResourceBundle bundle = ResourceBundle.getBundle("static/i18n/messages");

	// 可以拼接字符串的
	public String get(String msgKey, String args) {
		return MessageFormat.format(bundle.getString(msgKey), args);
	}

	/**
	 * 获取单个国际化翻译值
	 */
	public String get(String msgKey) {
		try {
			return bundle.getString(msgKey);
		} catch (Exception e) {
			return msgKey;
		}
	}
}