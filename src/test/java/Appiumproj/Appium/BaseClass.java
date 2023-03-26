package Appiumproj.Appium;

import AutomationConstants.AutomationConstants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void SetupClass() throws MalformedURLException
	{
		  // Start the server
		  service = new AppiumServiceBuilder().withAppiumJS(new File(AutomationConstants.pathToMainJs))
		  .usingDriverExecutable(new File(AutomationConstants.installedNodeLocation))
		  .withIPAddress(AutomationConstants.ipAddress).usingPort(AutomationConstants.portNumber).build();
		  
		  service.start();
		
		// Preferences of config
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(AutomationConstants.deviceName);
		options.setApp(".\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://"+
		AutomationConstants.ipAddress+":"+
		AutomationConstants.portNumber), options);
	}
	
	@AfterClass
	public void ShutdownClass()
	{
		driver.quit();
		service.stop();
	}
	
}
