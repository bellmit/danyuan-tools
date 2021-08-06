package org.danyuan.application.tools.common.utils;

import java.io.File;

/**
 * 文件名： FileDelete.java
 * 包 名： org.danyuan.application.common.utils.files
 * 描 述： TODO(用一句话描述该文件做什么)
 * 时 间： 2019年1月18日 下午6:27:52
 * 作 者： Administrator
 * 版 本： V1.0
 */
public class FileDelete {
	/***
	 * 删除指定文件夹下所有文件
	 *
	 * 参 数 : path
	 *            文件夹完整绝对路径
	 * 返 回 :
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (String element : tempList) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + element);
			} else {
				temp = new File(path + File.separator + element);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + element);// 先删除文件夹里面的文件
				delFolder(path + "/" + element);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/***
	 * 删除文件夹
	 *
	 * 参 数 : folderPath文件夹完整绝对路径
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
