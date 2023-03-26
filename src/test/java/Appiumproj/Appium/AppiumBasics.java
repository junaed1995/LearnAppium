package Appiumproj.Appium;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;

public class AppiumBasics extends BaseClass
	{
		@Test
		public void test1() throws MalformedURLException, InterruptedException
		{
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			driver.navigate().back();
			Thread.sleep(1000);
			
		}
	}
