package util;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import steps.BaseSteps;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * Created by 777 on 08.05.2017.
 */
public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure) throws Exception {
        takeScreenshot();
        super.testFailure(failure);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
