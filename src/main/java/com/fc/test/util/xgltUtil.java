package com.fc.test.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class xgltUtil {
	public static List<String> list = Arrays.asList(
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
			"Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
			"Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
			"Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
			"Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
			"Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
			"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
			"Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
			"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
			"Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52"
			);
	
	public static String Referer = "https://finance.discuss.com.hk/forumdisplay.php?fid=719";
	
	
	/**	
	 * 爬取数据
	 * 
	 */
	public void  qidongfangwen(String ip) throws IOException{
	  String url2 = "https://finance.discuss.com.hk/viewthread.php?tid=29301303&extra=page%3D1";
	  // String url2 = "http://httpbin.org/ip";
	   //String url2 = "https://www.baidu.com";
	   // ip 先写死
	   ip = "156.251.125.133:12125";
	   InputStream is = null;
       BufferedReader br = null;
       String temp="";
       BufferedReader brs = null;  //包装流,加快读取速度
       StringBuffer res = new StringBuffer();
       try {
           HttpURLConnection httpUrlConn = null;
           URL url = new URL(url2);
           if(ip!=null){
        	   // 首先分开ip 和端口号
        	   String dkh[] = ip.split(":");
        	   
               String str[] = dkh[0].split("\\.");
               byte[] b =new byte[str.length];
               for(int i=0,len=str.length;i<len;i++){
                   b[i] = (byte)(Integer.parseInt(str[i],10));
               }
                Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(InetAddress.getByAddress(b), Integer.parseInt(dkh[1])));  //b是绑定的ip，生成proxy代理对象，因为http底层是socket实现，
                httpUrlConn = (HttpURLConnection) url.openConnection(proxy);
           }else{
                httpUrlConn = (HttpURLConnection) url.openConnection(); 
           }
           httpUrlConn.setRequestMethod("GET");
           // 设置 User-agent
           String agent = qqt();
           httpUrlConn.setRequestProperty("user-Agent",agent);//为连接设置ua
           //httpUrlConn.setRequestProperty("accept-encoding","");//为连接设置ua
           //httpUrlConn.setRequestProperty("content-type", "text/html; charset=UTF-8");
			 
           httpUrlConn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
           
           //httpUrlConn.setRequestProperty("referer", Referer);
           
           
           //httpUrlConn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
           httpUrlConn.setDoOutput(true);
           httpUrlConn.setConnectTimeout(50000);
           httpUrlConn.setReadTimeout(50000);
           httpUrlConn.setDefaultUseCaches(false);
           httpUrlConn.setUseCaches(false);
           httpUrlConn.connect();
           
           is = httpUrlConn.getInputStream();
           brs= new BufferedReader(new InputStreamReader(is));
           while ((temp = brs.readLine()) != null) {
   	        /*html.append(temp);*/
        	   System.out.println(temp);
   	       }
           if(is!=null)        //接下来是关闭流,防止资源的浪费;
	        {
        	   is.close();
        	   is=null;
	        }
		
		/*HttpURLConnection myConn = null;
		
		URL url1 = new URL(url); //获取URL;
		myConn = (HttpURLConnection)url1.openConnection();//打开连接
		String agent = qqt();
		myConn.setRequestProperty("User-agent",agent);//为连接设置ua
		myConn.setRequestProperty("Content-type", "application/x-java-serialized-object");
		myConn.setRequestMethod("GET"); 
		myConn.setDoInput(true);
		myConn.connect();
		myConn.setConnectTimeout(30000); //设置连接主机超时（单位：毫秒）
		myConn.setReadTimeout(30000);	// 设置从主机读取数据超时（单位：毫秒）
		InputStream inStrm = myConn.getInputStream();*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
			is.close();
		}
	}
	
	
   public String qqt() {
	   List<String> qingqiutou = list;
	   Random r = new Random();
	   int number = r.nextInt(qingqiutou.size());
	   return qingqiutou.get(number);
   }
}
