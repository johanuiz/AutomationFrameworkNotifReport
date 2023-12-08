package com.anhtester.projects.cms.admin.pages.logins;

import com.anhtester.constants.FrameworkConstants;
import com.anhtester.helpers.PropertiesHelpers;
import com.anhtester.projects.cms.CommonPageCMS;
import com.anhtester.projects.cms.users.pages.dashboard.DashboardPage;
import org.openqa.selenium.By;

import static com.anhtester.keywords.WebUI.*;

public class LoginNotifTest extends CommonPageCMS {

    private ElementControl elementControl; // Agregar una instancia de ElementControl

    private By closeAdvertisementPopup = By.xpath("//button[@data-key='website-popup']");
    private By buttonLogin = By.xpath("(//a[normalize-space()='Registration']/parent::li)/preceding-sibling::li");
    private By buttonSubmitLogin = By.xpath("//button[normalize-space()='Login']");
    private By titleLoginPage = By.xpath("//h1[normalize-space() = 'Login to your account.']");
    private By messageRequiredEmail = By.xpath("//strong[contains(text(),'The email field is required when phone is not present.')]");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By messageAccDoesNotExist = By.xpath("//span[@data-notify='message']");
    private By messageRequiredPassword = By.xpath("//input[contains(@class, 'is-invalid') and @id = 'password']");
    private By titleAnhTesterAdminPage = By.xpath("//img[@alt='Active eCommerce CMS']");

    public LoginNotifTest(ElementControl elementControl) {
        this.elementControl = elementControl;
    }

    public void clickCloseAdvertisementPopup() {
        elementControl.clickElement(closeAdvertisementPopup);
    }

    public void openLoginPage() {
        openWebsite(FrameworkConstants.URL_CMS_USER);
        elementControl.clickElement(closeAdvertisementPopup);
        elementControl.clickElement(buttonCookies);
        elementControl.clickElement(buttonLogin);
        waitForPageLoaded();
        verifyElementVisible(titleLoginPage, "Login page is NOT displayed");
    }

    public void verifyRedirectToAdminPage() {
        verifyElementVisible(avatarProfile, "Can not redirect to Admin page.");
    }

    public void loginFailWithEmailNull() {
        openLoginPage();
        sleep(2);
        elementControl.clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyEquals(elementControl.getTextElement(messageRequiredEmail).trim(), "The email field is required when phone is not present.", "");
    }

    public void loginFailWithEmailDoesNotExist(String email, String password) {
        openLoginPage();
        sleep(2);
        elementControl.setText(inputEmail, email);
        elementControl.setText(inputPassword, password);
        elementControl.clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementVisible(messageAccDoesNotExist, "Email is incorrect but valid is NOT displayed.");
    }

    public void loginFailWithNullPassword(String email) {
        openLoginPage();
        sleep(2);
        elementControl.setText(inputEmail, email);
        elementControl.clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementPresent(messageRequiredPassword, "No warning password input");
    }

    public void loginFailWithIncorrectPassword(String email, String password) {
        openLoginPage();
        sleep(2);
        elementControl.setText(inputEmail, email);
        elementControl.clearText(inputPassword);
        elementControl.setText(inputPassword, password);
        elementControl.clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        verifyElementVisible(messageAccDoesNotExist, "Password is failed but valid is NOT displayed.");
    }

    public void loginSuccessWithCustomerAccount(String email, String password) {
        openLoginPage();
        sleep(2);
        elementControl.setText(inputEmail, email);
        elementControl.clearText(inputPassword);
        elementControl.setText(inputPassword, password);
        elementControl.clickElement(buttonSubmitLogin);
        waitForPageLoaded();
        sleep(1);
        waitForElementVisible(DashboardPage.titleDashboard);
        verifyElementVisible(DashboardPage.titleDashboard, "Dashboard page is NOT displayed.");
    }

    public CommonPageCMS loginSuccessAdminPage(String email, String password) {
        openWebsite(FrameworkConstants.URL_CMS_ADMIN);
        elementControl.setText(inputEmail, email);
        elementControl.setText(inputPassword, password);
        elementControl.clickElement(buttonSubmitLogin);
        waitForElementVisible(titleAnhTesterAdminPage);
        verifyElementVisible(titleAnhTesterAdminPage, "Admin page is NOT displayed.");
        return new CommonPageCMS();
    }

    public CommonPageCMS loginSuccessAdminPage() {
        openWebsite(FrameworkConstants.URL_CMS_ADMIN);
        elementControl.setText(inputEmail, PropertiesHelpers.getValue("email"));
        elementControl.setText(inputPassword, PropertiesHelpers.getValue("password"));
        elementControl.clickElement(buttonSubmitLogin);
        waitForElementVisible(titleAnhTesterAdminPage);
        verifyElementVisible(titleAnhTesterAdminPage, "Admin page is NOT displayed.");
        return new CommonPageCMS();
    }

    public void loginToApplication(String username, String password) {
        elementControl.setText(inputEmail, username);
        elementControl.setText(inputPassword, password);
        elementControl.clickElement(buttonSubmitLogin);
    }
}
