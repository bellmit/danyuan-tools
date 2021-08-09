/**
 * 
 */
package org.danyuan.application.bean.manager.softm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;

/**
 * @author Administrator
 */
@Entity
@Table(name = "sys_user_base_info")
@NamedQuery(name = "SysUserBaseInfo.findAll", query = "SELECT s FROM SysUserBaseInfo s")
public class SysUserBaseInfo extends BaseEntity implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	// 用户名
	@Column(name = "user_name")
	private String				userName;
	
	// 密码
	@Column(name = "password")
	private String				password;
	
	// 加盐
	@Column(name = "solt")
	private String				solt;
	
	// 加盐
	@Column(name = "enabled")
	private Boolean				enabled;
	
	// 电话
	@Column(name = "phone")
	private String				phone;
	
	// 邮箱
	@Column(name = "email")
	private String				email;
	
	// 枷锁
	@Column(name = "locked")
	private Integer				locked;
	
	// 错误次数
	@Column(name = "error_times")
	private Integer				errorTimes;
	
	// 到期时间
	@Column(name = "out_of_time")
	private Date				outOfTime;
	
}
