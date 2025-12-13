package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement login = $("[data-test-id=login] input");
    private SelenideElement pass = $("[data-test-id=password] input");
    private SelenideElement nextButton = $("[data-test-id=action-login]");

    public VerificationPage Loginning(String loginValue, String passwordValue) {
        login.setValue(loginValue);
        pass.setValue(passwordValue);
        nextButton.click();
        return new VerificationPage();
    }
}
