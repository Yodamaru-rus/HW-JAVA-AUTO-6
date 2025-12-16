package ru.netology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection accountCashs = $$(".list__item DIV");
    private ElementsCollection replenishButtons = $$("[data-test-id=action-deposit]");
    private SelenideElement reloadButton = $("[data-test-id=action-reload]");

    public void verifyIsDashboardPage() {
        heading.shouldBe(visible);
    }

    public ReplenishPage topUpAccount(int to) {
        to -= 1;
        verifyIsDashboardPage();
        replenishButtons.get(to).click();
        return new ReplenishPage();
    }

    public void successTransfer(int card, int balance) {
        reloadButton.click();
        accountCashs.get(card - 1).shouldHave(text(" баланс: " + balance + " р."));
    }

}