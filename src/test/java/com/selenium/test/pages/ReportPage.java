package com.selenium.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenium.test.utils.DayQualifier;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Aleksandr on 11.04.2017.
 */
public class ReportPage {
    @FindBy(css = "body > div.workspace > div:nth-child(3) > div > div:nth-child(1) > input")
    private SelenideElement loginLabel;

    @FindBy(css = "#input-password")
    private SelenideElement passwordLabel;

    @FindBy(css = "#firstAuth")
    private SelenideElement loginButton;

    @FindBy(css = "#xsx > button:nth-child(1)")
    private SelenideElement CreateButton;

    @FindBy(css = "#DF")
    private SelenideElement StartDateInputFilter;

    @FindBy(css = "#DT")
    private SelenideElement EndDateInputFilter;

    @FindBy(css = "#s2id_combobox > a > span.select2-arrow > b")
    private SelenideElement TypeReportArrow;

    @FindBy(className = "select2-input")
    private SelenideElement FilterTextInputLabel;

    @FindBy(className = "select2-results")
    private SelenideElement SubmitSerchResult;

    @FindBy(css = "#DATEFROM_new")
    private SelenideElement StartDateInputLabel;

    @FindBy(css = "#DATETO_new")
    private SelenideElement EndDateInputLabel;

    @FindBy(css = "#INKASRTP_new")
    private SelenideElement SubTypeDropdown;

    @FindBy(css = "#modal > div > div.modal-footer > button.btn.btn-primary")
    private SelenideElement CreateReportButton;

    @FindBy(css = "#exam_filter > label > input[type=\"search\"]")
    private SelenideElement ReportFilter;

    @FindBy(css = "td:nth-child(8)")
    private SelenideElement ReportState;


    public void crateAndGetAnnualInkasrReport() {
        SimpleDateFormat curentFormatDate = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -1);
        String startDate = curentFormatDate.format(calendar.getTime());
/*        CreateButton.click();
        TypeReportArrow.click();
        FilterTextInputLabel.sendKeys("INKASR");
        SubmitSerchResult.click();*/
        DayQualifier dayQualifier = new DayQualifier();
        int currentDayNum = dayQualifier.getWeekDay(new java.util.Date());
        Calendar newCalendar = Calendar.getInstance();
        if (currentDayNum == 1) {
            newCalendar.add(Calendar.DATE, -3);
            String endDate = curentFormatDate.format(newCalendar.getTime());
            /*EndDateInputLabel.sendKeys(endDate);*/
        } else {
            newCalendar.add(Calendar.DATE, -1);
            String endDate = curentFormatDate.format(newCalendar.getTime());
            /*EndDateInputLabel.sendKeys(endDate);*/
        }
        /*StartDateInputLabel.sendKeys(startDate);
        SubTypeDropdown.selectOptionContainingText("TRANSACTION - Отчёт по транзакциям инкасаторов");
        CreateReportButton.click();*/
        ReportFilter.sendKeys("INKASR");
        int reportCount = $$("td:nth-child(8)").size();
        if (reportCount > 1) {
            sleep(180000);
            refresh();
            for (int i = 1; i <= reportCount; i++) {
                System.out.println(i);
                String dateSelector = ("#exam > tbody > tr:nth-child(" + i + ") > td:nth-child(6)");
                String reportDate = StringUtils.substring($(dateSelector).getText(), 0, 10);
                String reportDateFormat = String.format("%1$s/%2$s/%3$s",
                        StringUtils.substring(reportDate, 0, 4),
                        StringUtils.substring(reportDate, 5, 7),
                        StringUtils.substring(reportDate, 8, 10));
                Calendar reportCalendar = Calendar.getInstance();
                String reportStartDate = curentFormatDate.format(reportCalendar.getTime());
                System.out.println(reportStartDate);
                String selector = "#exam > tbody > tr:nth-child(" + i + ") > td:nth-child(8)";
                if (reportDateFormat.equals(reportStartDate)) {
                    $(selector).click();
                    sleep(15000);
                }
            }
        } else {
            String selector = "#exam > tbody > tr:nth-child(1) > td:nth-child(8)";
            while ($(selector).getText().equals("Файл не создан")) {
                try {
                    Thread.sleep(180000);
                    refresh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            $(selector).click();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList<String> getAnnualInkasrReportName() {
        int reportCount = $$("td:nth-child(8)").size();
        ArrayList<String> reportNames = new ArrayList<>();
        for (int i = 1; i <= reportCount; i++) {
            String selector = "#exam > tbody > tr:nth-child(" + i + ") > td:nth-child(8)";
            reportNames.add($(selector).getText());
        }
        return reportNames;
    }
}
