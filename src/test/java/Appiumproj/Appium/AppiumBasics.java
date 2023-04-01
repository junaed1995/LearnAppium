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
			driver.findElement(By.xpath(TestConstants.preferenceDependecies)).click();
			Thread.sleep(500);
			driver.findElement(By.id(TestConstants.wifiCheckBox)).click();
			driver.findElement(By.xpath(TestConstants.wifiSettingstitle)).click();
			String wifiDialogHeader= driver.findElement(By.id(TestConstants.wifiAlertTitle)).getText();
			
			//Assertion of dialog title
			Assert.assertEquals("WiFi settings",wifiDialogHeader);
			
			// Set Wi-Fi name
			driver.findElement(By.id(TestConstants.wifiNameTextBox)).sendKeys("Test Wifi");
			driver.findElements(AppiumBy.className(TestConstants.dialogOkbutton)).get(1).click();
			
		}
	}
