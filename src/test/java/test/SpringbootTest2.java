package test;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fc.SpringbootStart;
import com.fc.test.util.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootTest2 {
	private static ZipOutputStream outputStream;
	@Test
	public void test() throws Exception{
		ZipUtil z = new ZipUtil();
		List<File> fileList = new ArrayList<>();
		File file = new File("D:\\daili\\222\\111\\test.zip");
		if(!file.exists()) {
			file.createNewFile();
		}
//		FileOutputStream fOutputStream = new FileOutputStream(file);
//		ZipOutputStream zoutput = new ZipOutputStream(fOutputStream);
//		String string="test ZIP!";
//		byte[] buffer =string.getBytes();
//		ZipEntry zEntry  = new ZipEntry("test.txt");
//		zoutput.putNextEntry(zEntry);
//		File file1 =new File("D:\\daili\\222\\111\\background.js");
//		File file2 =new File("D:\\daili\\222\\111\\manifest.json");
//		fileList.add(file1);
//		fileList.add(file2);
//		z.toZip(fileList, file);
		
		
		
		//分别是2个文件的输入流
		InputStream in1 = new FileInputStream("D:\\daili\\222\\111\\background.js");
		InputStream in2 = new FileInputStream("D:\\daili\\222\\111\\manifest.json");
		//分别是2个文件读取时的缓冲区大小，1024Bytes,也就是说每次读1M,假如文件1有2.5M,那就要读三次
		byte[] b1=new byte[1024];
		byte[] b2=new byte[1024];
		//每个文件读完后，用一个字符串存储文件内容
		String s1="";
		String s2="";
		//下面这个while循环读文件的代码不知道你看不看得懂，我不知道该怎么写注释，你要是不懂再问我吧
		int len1=0;
		int len2=0;
		while((len1=in1.read(b1))!=-1){
			s1+=new String(b1, 0, len1);
		}
		while((len2=in2.read(b2))!=-1){
			s2+=new String(b2, 0, len2);
		}
		
		//定义输出流，目的地是aaa.zip
		FileOutputStream fout = new FileOutputStream("D:\\daili\\222\\111\\test.zip");
		//将三个文件的内容放进一个map里
		Map<String, byte[]> datas = new HashMap<String, byte[]>();
		datas.put("background.js", s1.getBytes());
		datas.put("manifest.json", s2.getBytes());
 
		//装饰器模式：用ZipOutputStream包装输出流，使其拥有写入zip文件的能力
		ZipOutputStream zipout = new ZipOutputStream(new BufferedOutputStream(fout));
		
		//遍历
		Set<String> keys = datas.keySet();
		for (String key : keys) {
			//下面就是循环把每个文件写进zip文件
			InputStream bin = new BufferedInputStream(new ByteArrayInputStream(datas.get(key)));
			byte[] b = new byte[1024];
			
			zipout.putNextEntry(new ZipEntry(key));
			int len = -1;
			while ((len = bin.read(b)) !=-1) {
				zipout.write(b, 0, len);
			}
		}
		
		
		zipout.close();
		
	}
	


}
