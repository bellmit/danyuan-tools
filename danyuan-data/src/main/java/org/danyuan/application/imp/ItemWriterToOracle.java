package org.danyuan.application.imp;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.danyuan.application.common.utils.dbutils.OracleConnUtils;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * @文件名 MyItemWriterDemo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月1日 上午10:31:03
 * @author Administrator
 * @版本 V1.0
 */
@Component
public class ItemWriterToOracle implements ItemWriter<Map<String, Object>> {

	public String	tableName	= "qy法人单位1";
	public long		size		= 0;
	public String	idName		= "id";

	@Override
	public void write(List<? extends Map<String, Object>> items) throws Exception {

//		JdbcBatchItemWriter<Map<String, Object>> writer = new JdbcBatchItemWriter<>();
//		DataSource dataSource = DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql:///application?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false").username("root").password("514840279@qq.com").build();
	
//		writer.setDataSource(dataSource);
		Connection conn = OracleConnUtils.getConnection();
//		Connection conn = MysqlConnUtils.getConnection();
		Statement statement = conn.createStatement();
		//
		Iterator<? extends Map<String, Object>> map = items.iterator();
		while (map.hasNext()) {
			
			StringBuilder stringBuilder = new StringBuilder();
			Map<String, Object> row = map.next();
			Set<String> set = row.keySet();
			Iterator<? extends String> columns = set.iterator();
			stringBuilder.append("insert into " + tableName + "(");
			while (columns.hasNext()) {
				stringBuilder.append(columns.next());
				if (columns.hasNext()) {
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(") values('");
			columns = set.iterator();
			while (columns.hasNext()) {
				String data = String.valueOf(row.get(columns.next())).toString().replace("'", "");
				data = data.replace("\\", "").replace("null", "").replace("NULL", "").replace("&", "").replace("#", "").replace("——", "-").replace("？", "").trim();
				stringBuilder.append(data);
				if (columns.hasNext()) {
					stringBuilder.append("','");
				}
			}
			stringBuilder.append("')");
			try {
				// System.out.println(stringBuilder.toString());
				// 执行插入
				statement.execute(stringBuilder.toString());
			} catch (java.sql.SQLSyntaxErrorException e) {
				// 字符串文字太长
				if (e.getErrorCode() == 1704) {
					columns = set.iterator();
					String idData = null;
					stringBuilder = new StringBuilder();
					stringBuilder.append("insert into " + tableName + "(");
					while (columns.hasNext()) {
						String columnName = columns.next();
						if (columnName == idName) {
							idData = row.get(columnName) == null ? UUID.randomUUID().toString() : row.get(columnName).toString();
						}
						if (row.get(columnName) != null && row.get(columnName).toString().length() > 1000) {
							continue;
						}
						stringBuilder.append(columnName);
						if (columns.hasNext()) {
							stringBuilder.append(",");
						}
					}
					stringBuilder.append(") values('");
					columns = set.iterator();
					while (columns.hasNext()) {
						String columnName = columns.next();
						if (row.get(columnName) != null && row.get(columnName).toString().length() > 1000) {
							continue;
						}
						String data = String.valueOf(row.get(columnName)).toString().replace("'", "");
						data = data.replace("\\", "").replace("null", "").replace("NULL", "").replace("&", "").replace("#", "").replace("——", "-").replace("？", "").trim();
						stringBuilder.append(data);
						if (columns.hasNext()) {
							stringBuilder.append("','");
						}
					}
					stringBuilder.append("')");
					statement.execute(stringBuilder.toString());
					
					// 更新语句
					columns = set.iterator();
					StringBuilder updateBuilder = null;
					while (columns.hasNext()) {
						String columnName = columns.next();
						if (row.get(columnName) != null && row.get(columnName).toString().length() > 1000) {
							updateBuilder = new StringBuilder();
							String data = String.valueOf(row.get(columnName)).toString().replace("'", "");
							data = data.replace("\\", "").replace("null", "").replace("NULL", "").replace("&", "").replace("#", "").replace("-", "").replace("——", "").trim();
							while (data.length() > 0) {
								updateBuilder.append("update " + tableName);
								updateBuilder.append(" set " + columnName + "=" + columnName + "||'" + (data.length() > 1000 ? data.substring(0, 1000) : data) + "'");
								updateBuilder.append(" where " + idName + "='" + idData + "'");
								data = data.length() > 1000 ? data.substring(1000) : "";
								try {
									statement.execute(updateBuilder.toString());
								} catch (java.sql.SQLSyntaxErrorException ex) {
									// 修改数据类型为clob
									if (ex.getErrorCode() == 1704) {
										/*修改原字段名name为name_tmp*/
										statement.execute("alter table " + tableName + " rename column " + columnName + " to name_tmp");
										
										/*增加一个和原字段名同名的字段name*/
										statement.execute("alter table " + tableName + " add " + columnName + " clob");
										
										/*方式二:*/
										statement.execute("update " + tableName + " set " + columnName + " =trim(name_tmp)");
										
										/*更新完，删除原字段name_tmp*/
										statement.execute("alter table " + tableName + "  drop column name_tmp");
										
										statement.execute(updateBuilder.toString());
									}
								}
							}
						}
					}

				} else
				// 表创建
				if (e.getErrorCode() == 942) {
					columns = set.iterator();
					StringBuilder createStringBuilder = new StringBuilder();
					createStringBuilder.append("create table " + tableName + "(");
					while (columns.hasNext()) {
						createStringBuilder.append(columns.next() + " varchar2(4000)");
						if (columns.hasNext()) {
							createStringBuilder.append(",");
						}
					}
					createStringBuilder.append(")");
					System.out.println(createStringBuilder.toString());
					statement.execute(createStringBuilder.toString());
					statement.execute(stringBuilder.toString());
				} else {
					e.printStackTrace();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		size += items.size();
		System.out.println(size);
		OracleConnUtils.close(conn);
	}
	
}
