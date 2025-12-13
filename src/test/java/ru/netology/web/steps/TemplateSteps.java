package ru.netology.web.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.PendingException;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.VerificationPage;


public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    @Пусть("пользователь залогинен с именем {string} и паролем {string},")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.Loginning(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @И("пользователь нажимает кнопку пополнить {int} счета с номером {string} и забирает {string} рублей со {int} счета с номером {string}")
    public void topUpAccount(int to, String numberAccTo, String summ, int from, String numberAccFrom) {
        dashboardPage.topUpAccount(to, from, summ, numberAccTo, numberAccFrom);
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyDashboardPage() {
        dashboardPage.verifyIsDashboardPage();
    }

    @Тогда("появляется ошибка о неверном коде проверки")
    public void ifCodeIsInvalid() {
        verificationPage.ifCodeIsInvalid();
    }

    @Тогда("происходит успешная передача денег")
    public void successfulTransfer() {
        dashboardPage.successTransfer();
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {int} карту с главной страницы,")
    public void topUpAccountV2(String summ, String numberAccFrom, int to) {
        int from = dashboardPage.getAccountID(numberAccFrom);
        String numberAccTo = dashboardPage.getAccountNumber(to);
        dashboardPage.topUpAccount(to, from, summ, numberAccTo, numberAccFrom);
    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int} рублей.")
    public void endBalanse(int numberCard, int balance) {
        dashboardPage.successTransfer(numberCard, balance);
    }
}