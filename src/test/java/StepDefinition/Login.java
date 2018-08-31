package StepDefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login {
	static AppiumDriver<MobileElement> driver=null;

	
	@Given("^Launch the application in Mobile device$")
	public static void deviceCapabilities() throws Exception
	{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S8");
	capabilities.setCapability(MobileCapabilityType.UDID, "ce12171cc5023a3905");
	capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
	capabilities.setCapability("appPackage","com.snapwork.hdfc");
	capabilities.setCapability("appActivity","com.snapwork.hdfc.HDFCBank");

	try
	{
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	Thread.sleep(10000);
	System.out.println(driver.getContext());
	Set<String>set=driver.getContextHandles();
	
	for(String str:set) {
		System.out.println(str);
	}
	
	
	
	driver.context("NATIVE_APP");
	
	driver.findElementByXPath("//*[@text='Customer ID / User ID']").click();
	}
	catch(MalformedURLException e)
	{


	}
}
}
