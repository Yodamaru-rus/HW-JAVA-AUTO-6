package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verifyCode = $("[data-test-id=code] input");
    private SelenideElement nextVerifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorPopup = $(".notification__content");

    public VerificationPage() {
        verifyCode.shouldBe(visible);
    }

    public DashboardPage validVerify(String verifyCodeValue) {
        verifyCode.setValue(verifyCodeValue);
        nextVerifyButton.click();
        return new DashboardPage();
    }

    public void ifCodeIsInvalid() {
        errorPopup.shouldHave(text("Ошибка! Неверно указан код! Попробуйте ещё раз."));
    }
}
