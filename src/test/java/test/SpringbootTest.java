package test;



import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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
import com.fc.test.mapper.auto.GeneratorMapper;
import com.fc.test.mapper.auto.ThUserMapper;
import com.fc.test.model.auto.ThUser;
import com.fc.test.util.jietu;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootTest {

	@Autowired
	private GeneratorMapper generatorMapper;
	public static String APIKEY = "f072d2f98c5fd60a815502f048dc7e1d";
	@Autowired
	ThUserMapper thUserMapper;
	
	@Test
	public void test(){
		
		long waitLoadBaseTime = 1000;
      	int waitLoadRandomTime = 2000;
      	Random random = new Random(System.currentTimeMillis());
		System.setProperty("webdriver.chrome.driver", "D:\\1111\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//------------------------------------------------------------------------------------------------
		//	设置代理
//		Map<String, Object> map = new HashMap<String, Object>();
//        map.put("httpProxy", "113.239.72.70:24368");
//        Proxy proxy = new Proxy(map);
//        options.setProxy(proxy);
//        
//        options.addExtensions(new File("D:\\daili\\222\\proxy.zip"));
		//------------------------------------------------------------------------------------------------
		
		List excludeSwitches= new ArrayList();
		excludeSwitches.add("enable-automation");
		options.setExperimentalOption("excludeSwitches",excludeSwitches);
		//初始化一个谷歌浏览器实例，实例名称叫driver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// get()打开一个站点
		driver.get("https://finance.discuss.com.hk/logging.php?action=login"); // 登录
//		driver.get("https://finance.discuss.com.hk/viewthread.php?tid=29321893&extra=page%3D1");
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			Thread.sleep(waitLoadBaseTime+random.nextInt(waitLoadRandomTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 下面的逻辑是登录逻辑
		try {
			tiezizhuaqu(driver);
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		}
	}
	public void tiezizhuaqu(WebDriver driver) throws Exception{
		String zhanghao = "6869865";
		String mima = "zxc123456.";
		//获取输入框元素，并输入值
		driver.findElement(By.id("username")).sendKeys(zhanghao);
		//获取输入框元素，并输入值
		driver.findElement(By.id("password")).sendKeys(mima);
		// 获取下拉框
		WebElement element = driver.findElement(By.id("loginfield"));
		Select select = new Select(element);
		select.getOptions();
		select.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(1000);
		int type = 0;
		for(int p = 1; p < 10; p++) {
			if(type > 0) {
				break;
			}
			String pinjie = "&page=" + p;
			driver.get("https://finance.discuss.com.hk/forumdisplay.php?fid=562"+pinjie); // 登录
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			int size = 0;
			List<WebElement> list = driver.findElements(By.xpath("//tbody[contains(@id,'normalthread_')]"));
			size = list.size();
			for(int i =0; i < size; i++) {
				int s = i+1;
				String herf = driver.findElement(By.xpath("((//tbody[contains(@id,'normalthread_')])["+s+"]/tr/th)[1]/span/a")).getAttribute("href");
				String urltime = driver.findElement(By.xpath("(//tbody[contains(@id,'normalthread_')])["+s+"]/tr//td[contains(@class,'author')]/em")).getText();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Calendar calendar = Calendar.getInstance();
				Date dt1 = df.parse(urltime);
				Date date=new Date();
				String time =df.format(date);
				Date dt2 = df.parse(time);
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				Date newTime = calendar.getTime();
				String newTime1 = df.format(newTime);
				Date dt3 = df.parse(newTime1);
				if(dt1.getTime() ==  dt2.getTime() || dt1.getTime() == dt3.getTime()){
	
					Thread.sleep(2000);
					driver.get(herf); // 登录
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("div[class='autosave form-control']")).sendKeys("en");
					Thread.sleep(3000);
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");  
					Thread.sleep(2000);
					driver.findElement(By.id("postsubmit")).click();
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(20000);
					
				}else{
					type ++;
					break;
				}
				
				if(i== size-1) {
					System.out.println("完成了"+size);
				}
			}
		}
		driver.get("https://finance.discuss.com.hk/space.php?action=viewpro&uid="+zhanghao); // 登录
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		Thread.sleep(1000);
		String fenshu = driver.findElement(By.xpath("(//div[contains(@class,'user-profile-info-right')])[4]")).getText();
		System.out.println(fenshu);
		Thread.sleep(1000);
		// 更新积分
		ThUser record = new ThUser();
		record.setUserId(zhanghao);
		record.setPassword(mima);
		List<ThUser> userlt = thUserMapper.selectAll(record);
		userlt.get(0).setFraction(Integer.parseInt(fenshu));
		thUserMapper.updateByPrimaryKeySelective(userlt.get(0));
		// 执行完毕关闭网站
		driver.quit();
		
	}
	// 登录逻辑
	public void denglu(WebDriver driver) throws Exception {
		String zhanghao = "6869906";
		String mima = "zxc123456.";
		//获取输入框元素，并输入值
		driver.findElement(By.id("username")).sendKeys(zhanghao);
		//获取输入框元素，并输入值
		driver.findElement(By.id("password")).sendKeys(mima);

		//===========================================================================================\
//		String k =driver.findElement(By.className("g-recaptcha")).getAttribute("data-sitekey");
//		System.out.println(k);
//		String requesturl="https://2captcha.com/in.php?key="+APIKEY+"&method=userrecaptcha&googlekey="+k+"&pageurl=https://www.google.com/recaptcha/api2/reload&json=1";
//		//driver.quit();
//		driver.get(requesturl);
//	    String res=driver.findElement(By.tagName("body")).getText();
//		System.out.println(res);
		
		//获取搜索元素，并点击
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'https:')]")));
//		driver.findElement(By.tagName("body")).click();
//		driver.switchTo().defaultContent();
//		Thread.sleep(10000);
		
		// 切换空的 
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.id("username")).sendKeys("6869829");
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'recaptcha challenge')]")));
//        WebElement element = driver.findElement(By.xpath("//iframe[contains(@title,'recaptcha challenge')]"));
//        String fileName = "filename";
//        
//        jietu jietu = new jietu();
//        //创建元素快照
//        jietu.elementSnapshot(driver,element);
//        //移动图片到指定位置
//        FileUtils.copyFile(jietu.elementSnapshot(driver,element), new File(fileName, "123456"+".png"));
//		
//        mouseClick(driver,element,108,67);
		
		//===========================================================================================
		
//		String requesturl="https://2captcha.com/in.php?key=API KEY&method=userrecaptcha&googlekey=6Le-wvkSAAAAAPBMRTvw0Q4Muexq9bi0DJwx_mJ-&pageurl=https://www.google.com/recaptcha/api2/demo&json=1";
//		driver.get(requesturl);
//	    String res=driver.findElement(By.tagName("body")).getText();
//	    f072d2f98c5fd60a815502f048dc7e1d
//	    //获取返回的json信息
//	    JSONObject jsonObject = JSONObject.parseObject(res);        
//	    String id=jsonObject.getString("request");
//	    System.out.println("id="+id);
		
		
		
		
//		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		
//		try {
//		      FileUtils.copyFile(srcFile,new File("D:\\hctp\\screenshot.png"));
//		    } catch (IOException e) {
//		      e.printStackTrace();
//		    }
		//===========================================================================================\
		// 获取下拉框
		WebElement element = driver.findElement(By.id("loginfield"));
		Select select = new Select(element);
		select.getOptions();
		select.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.className("submit")).click();
		Thread.sleep(1000);
		driver.get("https://finance.discuss.com.hk/redirect.php?fid=57&tid=29327097&goto=nextoldset"); // 登录
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div[class='autosave form-control']")).sendKeys("恩嗯嗯");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");  
		Thread.sleep(2000);
		driver.findElement(By.id("postsubmit")).click();
		Thread.sleep(1000);
		driver.get("https://finance.discuss.com.hk/space.php?action=viewpro&uid="+zhanghao); // 登录
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		Thread.sleep(1000);
		String fenshu = driver.findElement(By.xpath("(//div[contains(@class,'user-profile-info-right')])[4]")).getText();
		System.out.println(fenshu);
		Thread.sleep(1000);
		// 更新积分
		ThUser record = new ThUser();
		record.setUserId(zhanghao);
		record.setPassword(mima);
		List<ThUser> userlt = thUserMapper.selectAll(record);
		userlt.get(0).setFraction(Integer.parseInt(fenshu));
		thUserMapper.updateByPrimaryKeySelective(userlt.get(0));
		// 执行完毕关闭网站
		driver.quit();
	
	}
	
	
	/*左键点击元素上的具体坐标位置
	 * @param driver
	 * @param abnormElement  需要点击的元素
	 * @param x 需要点击的元素上的点的X坐标
	 * @param y 需要点击的元素上的点的Y坐标
	 */
	public static void mouseClick(WebDriver driver, WebElement abnormElement, int x, int y) {
		Actions actions = new Actions(driver);    
		actions.release();
		actions.moveToElement(abnormElement, x, y).click().build().perform();
	}
	

}
