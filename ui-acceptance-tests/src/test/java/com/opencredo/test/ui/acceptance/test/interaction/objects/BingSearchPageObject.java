package com.opencredo.test.ui.acceptance.test.interaction.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class BingSearchPageObject extends PageObject {

    private final static String PAGE_PATH = "/";
    private final By bingSearchBox = By.name("q");


    public BingSearchPageObject(String baseUrl, WebDriver driver, int waitTimeOutSeconds) {
        super(baseUrl + PAGE_PATH, driver, waitTimeOutSeconds);
    }

    public void search(String searchCriteria) {
        setText(find(bingSearchBox), searchCriteria);
        submit(find(bingSearchBox));

    }

    public boolean searchResult(String resultUrl) {
        return is_text_present(resultUrl);

    }






}
