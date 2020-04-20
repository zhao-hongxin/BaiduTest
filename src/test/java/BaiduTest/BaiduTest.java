package BaiduTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaiduTest {
	
	WebDriver driver=null;
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.baidu.com/");
	}
	
	@Test
	public void test1() throws InterruptedException {
		WebElement element=driver.findElement(By.id("kw"));
		element.submit();
	    Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(),"https://www.baidu.com/");
	}
	
	@Test
	public void test2() throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("//*[@id=\"kw\"]"));
		element.sendKeys("      ");
		element.submit();
		Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(),"https://www.baidu.com/");
	}
	
	@Test
	public void test3() throws InterruptedException {
		WebElement element=driver.findElement(By.cssSelector("#kw"));
		element.sendKeys("#￥%……@");
		element.submit();
		Thread.sleep(3000);
		assertEquals(driver.getTitle(),"#￥%……@_百度搜索");
	}
	
	@Test
	public void test4() throws InterruptedException {
		WebElement element=driver.findElement(By.id("kw"));
		element.sendKeys("软件测试就是利用测试工具按照测试方案和流程对产品进行功能和性能测试，甚至根据需要编写不同的测试工具，设计和维护测试系统，对测试方案可能出现的问题进行分析和评估。执行测试用例后，需要跟踪故障，以确保开发的产品适合需求。具有人工操作或者软件自动运行两种方式。 它是帮助识别开发完成（中间或最终的版本）的计算机软件（整体或部分）的正确度(correctness) 、完全度(completeness)和质量(quality)的软件过程；是SQA(software quality assurance)的重要子域。");
		element.submit();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.cssSelector("#content_left > div.hit_top_new > div")).getText().contains("后面的字词均被忽略"),true);
	}
	
	@Test
	public void test5() throws InterruptedException {
		WebElement element=driver.findElement(By.cssSelector("#kw"));
		element.sendKeys("selenium");
		element.submit();
		Thread.sleep(5000);
		assertEquals(driver.getTitle(),"selenium_百度搜索");
	}
	
	@After
	public void after() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();		
	}

}
