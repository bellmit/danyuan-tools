package org.danyuan.application.job;

/**
 * @文件名 Depent.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月4日 上午10:11:11
 * @author Administrator
 * @版本 V1.0
 */
public class Depent {
	private String	groupId;
	private String	artifactId;
	private String	version;
	private String	scope;

	/**
	 * @方法名 getGroupId
	 * @功能 返回变量 groupId 的值
	 * @return String
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @方法名 setGroupId
	 * @功能 设置变量 groupId 的值
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @方法名 getArtifactId
	 * @功能 返回变量 artifactId 的值
	 * @return String
	 */
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * @方法名 setArtifactId
	 * @功能 设置变量 artifactId 的值
	 */
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	/**
	 * @方法名 getVersion
	 * @功能 返回变量 version 的值
	 * @return String
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @方法名 setVersion
	 * @功能 设置变量 version 的值
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @方法名 getScope
	 * @功能 返回变量 scope 的值
	 * @return String
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @方法名 setScope
	 * @功能 设置变量 scope 的值
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @方法名 toString
	 * @参数 @return
	 * @参考 @see java.lang.Object#toString()
	 * @author Administrator
	 */

	@Override
	public String toString() {
		return "Depent [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + ", scope=" + scope + "]";
	}
	
}
