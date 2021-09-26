package webTests;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import webTests.BaseTest;

import java.util.Optional;

public class TestListener extends BaseTest implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
//        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
//        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
//        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
//        TestWatcher.super.testFailed(context, cause);
        makeScreenshotOnFailure(context.getTestMethod().get().getName());

    }
    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
}
