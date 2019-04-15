package configuracionbase;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.PageModel;
import utils.GenericMethods;
import utils.PSCException;
import utils.Driver;


@RunWith(Suite.class)
@SuiteClasses({})
public class BaseFlow {
    
    private static final Log log = LogFactory.getLog(BaseFlow.class);
    public static WebDriver driver;
    public static PageModel pageModel;
    private static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    public static SessionId session;
    
    @BeforeSuite
    public void BeforeSuite() {
        try {
            extentReports = new ExtentReports(Paths.get(System.getProperty("user.dir"), "report/index.html").toString());
            extentReports.loadConfig(new File(Paths.get(System.getProperty("user.dir"), "extent-report.xml").toString()));
        } catch (Exception e) {
            System.out.println("@BeforeSuite ->");
            e.printStackTrace();
        }
    }

    @AfterSuite(alwaysRun = true)
    public static void AfterSuite() {
        try {
          driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("@AfterSuite ->");
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void beforeClass() {
        try {
            driver = Driver.setup();
            GenericMethods.tiempoEspera(60);
            driver.manage().window().maximize();
            pageModel = PageFactory.initElements(driver, PageModel.class);
        } catch (Exception e) {
            System.out.println("@BeforeClass ->");
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        try {
            extentReports.endTest(extentTest);
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("@AfterClass ->");
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method testName){
        try {
            extentTest = extentReports.startTest(this.getClass().getSimpleName());
            ReportUtils.setLinea(extentTest);
            ReportUtils.setUsuario(extentTest);
        }catch (Exception e) {
            System.out.println("@BeforeMethod ->");
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        try {
            extentReports.flush();
        }catch (Exception e) {
            System.out.println("@AfterMethod ->");
            e.printStackTrace();
        }
    }

    private static String CrearCaptura(WebDriver driver) {
        UUID uuid = UUID.randomUUID();
        File Captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(Captura,
                    new File(Driver.curDir + "//report" + "//evidencias" + "//" + uuid + ".png"));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + Arrays.toString(e.getStackTrace()));
            // TODO: handle exception
        }
        return "evidencias//" + uuid + ".png";
    }

    public static void GenerarPasoExitoso(String exitoso) {
        extentTest.log(LogStatus.PASS, exitoso);
    }

    public static void GenerarPasoFallido(String fallido) {
        extentTest.log(LogStatus.FAIL, fallido + "\n" + extentTest.addScreenCapture(CrearCaptura(driver)));
        System.out.println("Ejecucion Fallida: " + fallido);
    }

    public static void GenerarPasoErroneo(String error) {
        extentTest.log(LogStatus.ERROR, error + "\n" + extentTest.addScreenCapture(CrearCaptura(driver)));
        System.out.println("Ejecucion con Error: " + error);
    }
    
    public static Boolean isActiveSessionDriver() throws Exception {
        session =  ((RemoteWebDriver) driver).getSessionId();
        try {
            if(session==null) {
                throw new PSCException("Session de driver web finalizada");
            }else {
                return true;
            }
        } catch (PSCException e) {
            throw e;
        }catch (Exception e) {
            log.error(e,e);
            throw e;
        }
    }
}