package com.fc.test.util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class jietu {
	/**
     * 根据Element截图指定区域方法
     *
     * @param driver
     * @param element  截图区域
     * @throws Exception
     */
    public static File elementSnapshot(WebDriver driver, WebElement element) throws Exception {
        //创建全屏截图
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(screen);

        //获取元素的高度、宽度
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        //创建一个矩形使用上面的高度，和宽度
        Rectangle rect = new Rectangle(width, height);
        //元素坐标
        Point p = element.getLocation();


        //对前面的矩形进行操作
        //TODO 使用可以截全图的方法（滚动条），暂未找到方式
        int w = rect.width; //指定矩形区域的宽度
        int h = rect.height;//指定矩形区域的高度
        int x = p.getX(); //指定矩形区域左上角的X坐标
        int y = p.getY(); //指定矩形区域左上角的Y坐标

        //driver的分辨率，这里设置1920*1080
        int w_driver = 1920;
        int h_driver = 1080;

        System.out.println("width:" + w);
        System.out.println("height:"+ h);
        System.out.println("x:"+ x);
        System.out.println("y:"+ y);

        System.out.println("y+height:"+(y + h));
        System.out.println("x+width:"+ (x + w));



        /**
         * 如果Element的Y坐标值加上高度超过driver的高度
         * 就会报错(y + height) is outside or not
         * 退而求其次，调整图片的宽度和高度, 调整到适合driver的分辨率
         * 此时会截图driver可见的元素区域快照
         * TODO 如果能找到跨滚动条截图的方式，可以不用裁剪
         */
        try{
            if ( y + h > h_driver){
                h = h- (y + h - h_driver); //

                System.out.println("修改后的height:" + h);
                System.out.println("修改后的y+height："+ (y+h));
            }
            //(x + width) is outside or not
            if (x + w > w_driver){
                w = x - (x + w - w_driver);

                System.out.println("修改后的width："+ w);
                System.out.println("修改后的x+width:"+ (x+w));
            }

            BufferedImage img = image.getSubimage(x, y, w, h);
            ImageIO.write(img, "png", screen);
            System.out.println("Screenshot By element success");

        }catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return screen;

    }
}
