package com.opencredo.test.ui.acceptance.test.step.definitions;

import com.opencredo.test.ui.acceptance.test.interaction.objects.BingSearchPageObject;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class BingSearchStepDefs extends AbstractStepDefinition {


    @Autowired
    private BingSearchPageObject bingSearchPage;

    @Before
    //read more
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @Given("^open a Firefox browser, seacrh toll Bing$")
    public void openAFirefoxBrowserSeacrhTollBing() throws Throwable {
        bingSearchPage.goToAndWait();
    }

    @Then("^Search criteria is \"([^\"]*)\"$")
    public void searchCriteriaIs(String searchCriteria) throws Throwable {
        bingSearchPage.search(searchCriteria);

    }

    @And("^website of \"([^\"]*)\" must be shown in results$")
    public void websiteOfMustBeShownInResults(String resultUrl) throws Throwable {
        bingSearchPage.searchResult(resultUrl);

    }

}
