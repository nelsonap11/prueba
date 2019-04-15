package utils;

import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ValidarCompraArticulo {
	
	public static WebDriver driver;
	public static String curDir = System.getProperty("user.dir");
	public static String browser = "chrome";
	
	// Variables de declaradas en el S.O para que pueda salir por el proxy especificado en esas variables
	static String user = System.getenv("USERNAME");
	static String password = System.getenv("PASSWORD");

	public static WebDriver setup() throws MalformedURLException {

		System.out.println("BROWSER :" + browser);
		System.out.println("DIRECTORIO " + curDir);
	
		if (browser.equalsIgnoreCase("chrome")) {

			String downloadFilepath = curDir + "\\src\\test\\java\\dataXML";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			chromePrefs.put("safebrowsing.enabled", "true"); 
		    
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs); 
			
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", curDir + "\\WebDriver\\Chrome\\Windows\\chromedriver701.exe");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		 }
		
		if (browser.equalsIgnoreCase("ie")) {

			 DesiredCapabilities capabilities = new DesiredCapabilities();

			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 System.setProperty("webdriver.ie.driver", curDir  +"\\drivers\\IEDriverServer.exe");
			 
			 driver = new InternetExplorerDriver(capabilities);
			 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}
		 return driver;
	}
	public static String GetNavegador() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		return cap.getBrowserName() + "_" + cap.getVersion();
	}
}
