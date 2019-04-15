package configuracionbase;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Constants;

public class ReportUtils {

    public static void setLinea(ExtentTest extentTest) {
        String URL = Constants.URL;
        extentTest.assignCategory(URL);
    }

    public static void setUsuario(ExtentTest extentTest) {
        if (System.getenv("") != null)
            extentTest.assignAuthor(System.getenv(""));
        else
            extentTest.assignAuthor("Nelson Pernia");
    }

}
