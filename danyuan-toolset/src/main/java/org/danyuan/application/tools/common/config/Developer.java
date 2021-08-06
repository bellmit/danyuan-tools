package org.danyuan.application.tools.common.config;

import java.util.Arrays;

public class Developer {

	private String username;

	private String webset;

	private String description;

	private String qq;

	private String email;

	private String[] skills;

	/**
	 * 返 回 : the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 参 数 : username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 返 回 : the webset
	 */
	public String getWebset() {
		return webset;
	}

	/**
	 * 参 数 : webset the webset to set
	 */
	public void setWebset(String webset) {
		this.webset = webset;
	}

	/**
	 * 返 回 : the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 参 数 : description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 返 回 : the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * 参 数 : qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * 返 回 : the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 参 数 : email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 返 回 : the skills
	 */
	public String[] getSkills() {
		return skills;
	}

	/**
	 * 参 数 : skills the skills to set
	 */
	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Developer [username=" + username + ", webset=" + webset + ", description=" + description + ", qq=" + qq
				+ ", email=" + email + ", skills=" + Arrays.toString(skills) + "]";
	}

}
