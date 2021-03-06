package io.qameta.allure.examples.testng;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class AllureSimpleTest {

    @Test(description = "allureSimpleTest displayName")
    public void allureSimpleTest() {
        step("Simple step");
        step("Simple step with status", Status.FAILED);
        step("Simple lambda step", () -> {
            step("Simple step inside lambda step");
        });
        simpleTestMethod("method parameter");
    }

    @Step("Simple test method with step annotation")
    public void simpleTestMethod(String param) {
        step("Method parameter: " + param);
        step("Simple step inside test method");
    }

    @Test(enabled = false)
//    @Test(description = "This will be disabled")
    @Description("This is disabled test")
    public void allureSimpleTestDisabled() {
        step("Must not appear anywhere");
        step("Simple step with status", Status.PASSED);
        step("Simple lambda step", () -> {
            step("Simple step inside lambda step");
        });
        simpleTestMethod("method parameter");
    }


}
