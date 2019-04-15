package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracionbase.BaseFlow;

public final class GenericMethods {


	public static boolean isClickable(WebElement element,Integer timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseFlow.driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void tiempoEspera(long segundos) {
      Driver.driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }
}
