package Appiumproj.Appium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;

public class AppiumBasics extends BaseClass
	{
		@Test
		public void test1() throws MalformedURLException, InterruptedException
		{
			driver.findElement(AppiumBy.accessibilityId(TestConstants.preferenceButton)).click();
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
			Thread.sleep(500);
			driver.findElement(By.id("android:id/checkbox")).click();
			driver.findElement(By.xpath("//android.widget.LinearLayout[2]")).click();
			String wifiDialogHeader= driver.findElement(By.id("android:id/alertTitle")).getText();
			
			//Assertion of dialog title
			Assert.assertEquals("WiFi settings",wifiDialogHeader);
			
			// Set Wi-Fi name
			driver.findElement(By.id("android:id/edit")).sendKeys("Test Wifi");
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
			
		}
	}
