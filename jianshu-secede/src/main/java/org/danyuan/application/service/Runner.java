package org.danyuan.application.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.danyuan.application.common.utils.files.TxtFilesReader;
import org.danyuan.application.common.utils.files.TxtFilesWriter;
import org.danyuan.application.conf.UserConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： Runner.java
 * 包 名 ： org.danyuan.application.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wth
 * 时 间 ： 2021年8月15日 上午11:11:50
 * 版 本 ： V1.0
 */
@Service
public class Runner {
	
	@Autowired
	UserConf userConf;
	
	public void exec() {
		
		String newpath = userConf.getNewPath();
		String oldpath = userConf.getOldPath();
		
		// 读取文件
		File file = new File(oldpath);
		CloseableHttpClient client = HttpClients.createDefault();
		
		List<String> list = new ArrayList<>();
		
		readFile(file, newpath, oldpath, client, list, "");
		StringBuilder sb = new StringBuilder();
		for (String string : list) {
			sb.append(string + "\n");
		}
		TxtFilesWriter.writeToFile(sb.toString(), newpath + "\\dir.md");
		
	}
	
	private void readFile(File file, String newpath, String oldpath, CloseableHttpClient client, List<String> listMenu, String head) {
		
		File[] files = file.listFiles();
		for (File file2 : files) {
			String newp = file2.getPath().replace(oldpath, newpath);
			if (file2.isDirectory()) {
				File path = new File(newp);
				path.mkdirs();
				listMenu.add(head + "* " + file2.getName());
				readFile(file2, newpath, oldpath, client, listMenu, head + "\t");
			} else {
				List<String> list = TxtFilesReader.readFileByLines(file2.getPath());
				StringBuilder sb = new StringBuilder();
				int i = 0; // 计数
				for (String str : list) {
					if (StringUtils.isNotEmpty(str) && str.contains("![")) {
						// 提取链接
						String link = str.substring(str.indexOf("](") + 2, str.indexOf(")"));
						// 下载图片
						String path = newp.replace(newpath, "").replace(".md", "") + "\\" + i + ".png";
						String savePath = userConf.getImgPath() + path;
						if (StringUtils.isNotEmpty(link) && link.startsWith("http")) {
							httpGetImg(client, link, savePath);
						}
						sb.append(str.substring(0, str.indexOf("![")) + "![" + i + "](" + userConf.getRootPath() + path.replace("\\", "/") + ")\n");
						i++;
					} else {
						sb.append(str + "\n");
					}
				}
				listMenu.add(head + "* [" + file2.getName().replace(".md", "") + "](" + newp.replace(newpath, "/docs").replace("\\", "/") + ")");
				// 重写文件
				TxtFilesWriter.writeToFile(sb.toString(), newp);
			}
		}
		// 记录 文件路径
		
	}
	
	private void httpGetImg(CloseableHttpClient client, String imgUrl, String savePath) {
		// 发送get请求
		HttpGet request = new HttpGet(imgUrl);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000).build();
		
		// 设置请求头
		request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1");
		
		request.setConfig(requestConfig);
		try {
			CloseableHttpResponse response = client.execute(request);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				HttpEntity entity = response.getEntity();
				InputStream in = entity.getContent();
				FileUtils.copyInputStreamToFile(in, new File(savePath));
				System.out.println("下载图片成功:" + imgUrl);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			request.releaseConnection();
		}
	}
	
}
