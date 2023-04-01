package Appiumproj.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseClass{
		
	@Test
	public void longPressTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId(TestConstants.viewsOption)).click();
		driver.findElement(AppiumBy.accessibilityId(TestConstants.expandableListOptions)).click();
		driver.findElement(AppiumBy.accessibilityId(TestConstants.customAdapterOption)).click();
	
		WebElement peopleNames = driver.findElement(By.xpath(TestConstants.peopleNamesXpath));
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) peopleNames).getId(),"duration",1000));
		
		Thread.sleep(2000);
		
		
	}

}
