package com.fc.test.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteJS {
	public void sc(String host,String port,String name,String password,String wenjianming) {
		OutputStreamWriter osw = null;
		try {
			String filePath = "C:\\"+wenjianming+".js";
			FileOutputStream out=new FileOutputStream(filePath);
			osw =new OutputStreamWriter(out,"UTF-8");
			String str="var config = {\r\n" + 
					"    mode: \"fixed_servers\",\r\n" + 
					"    rules: {\r\n" + 
					"      singleProxy: {\r\n" + 
					"        scheme: \"http\",\r\n" + 
					"        host: \""+host+"\",\r\n" + 
					"        port: parseInt(\""+port+"\")\r\n" + 
					"      },\r\n" + 
					"      bypassList: [\"foobar.com\"]\r\n" + 
					"    }\r\n" + 
					"  };\r\n" + 
					" \r\n" + 
					"chrome.proxy.settings.set({value: config, scope: \"regular\"}, function() {});\r\n" + 
					" \r\n" + 
					"function callbackFn(details) {\r\n" + 
					"    return {\r\n" + 
					"        authCredentials: {\r\n" + 
					"            username: \""+name+"\",\r\n" + 
					"            password: \""+password+"\"\r\n" + 
					"        }\r\n" + 
					"    };\r\n" + 
					"}\r\n" + 
					" \r\n" + 
					"chrome.webRequest.onAuthRequired.addListener(\r\n" + 
					"        callbackFn,\r\n" + 
					"        {urls: [\"<all_urls>\"]},\r\n" + 
					"        ['blocking']\r\n" + 
					");";
			osw.write(str);
			osw.close();//新建的txt文件就是UTF-8 编码
		} catch (Exception e) {
			try {
				osw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
