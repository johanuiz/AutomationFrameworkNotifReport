package com.anhtester.projects.cms.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.FrameworkConstants;
import com.anhtester.helpers.ExcelHelpers;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Regression Test CMS")
@Feature("Login Test")
public class LoginNotifTest extends BaseTest {

    @Test(priority = 1)
    public void TC_LoginFailWithEmailNull() {
        getLoginPageNotif().loginFailWithUserPasswordNull();
    }
/*
    @Test(priority = 2)
    public void TC_LoginFailWithEmailDoesNotExist() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageNotif().loginFailWithEmailDoesNotExist(excel.getCellData(1, "email"), excel.getCellData(1, "password"));
    }

    @Test(priority = 3)
    public void TC_LoginFailWithNullPassword() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageNotif().loginFailWithNullPassword(excel.getCellData(2, "email"));
    }

    @Test(priority = 4)
    public void TC_LoginFailWithIncorrectPassword() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageNotif().loginFailWithIncorrectPassword(excel.getCellData(3, "email"), excel.getCellData(3, "password"));
    }

    @Test(priority = 5)
    public void TC_LoginSuccessWithCustomerAccount() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageNotif().loginSuccessWithCustomerAccount(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
    }
*/

}
