/*
 * package com.Utilities;
 * 
 * import java.io.File; import java.text.SimpleDateFormat; import
 * java.util.Date; import org.apache.commons.io.FileUtils; import
 * org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot;
 * 
 * import Trivago_Com.Basecalss;
 * 
 * public class screenshot extends Basecalss {
 * 
 * 
 * 
 * public static void takescreenshot(String filename) throws Exception { String
 * date = new SimpleDateFormat("ddMMyyyy").format(new Date()); TakesScreenshot
 * take = (TakesScreenshot) driver;
 * 
 * File source =take.getScreenshotAs(OutputType.FILE);
 * 
 * FileUtils.copyDirectory(source, new File(System.getProperty("user.dir")+
 * "\\Screenshots\\trivago" + filename +date + ".png"));
 * 
 * 
 * }
 * 
 * }
 */