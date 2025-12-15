package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReplenishPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]").sibling(0);
    private SelenideElement summ = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");

    public void verifyIsReplenishPage() {
        heading.shouldHave(text("Пополнение карты"));
    }

    public void relenishAccount(String summValue, String fromValue) {
        verifyIsReplenishPage();
        summ.setValue(summValue);
        from.setValue(fromValue);
        transferButton.click();
    }
}