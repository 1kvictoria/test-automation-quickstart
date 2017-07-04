package com.opencredo.test.api.acceptance.test.step.definitions;

import com.opencredo.test.api.acceptance.test.interaction.api.objects.TflApi;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class LineDisruptionStepDefs {


    @Autowired
    private TflApi tflApi;
    private String freeline;
    private ResponseEntity<Void> responseFromService;

    @Given("^a line without disruptions$")
    public void aLineWithoutDisruptions() throws Throwable {
       // a function takes first String line provided --
        // create a loop, first line which has no disruption is taken for function.
        freeline = tflApi.getLineWithoutDisruptions();
    }

    @When("^i retrieve a disruption$")
    public void iRetrieveADisruption() throws Throwable {
        // Send a request to tfl api
        responseFromService = tflApi.getDisruption(freeline);

    }

    @Then("^I should get a '(\\d+)' response from the service$")
    // Check a response from service http code - '200'
    public void iShouldGetAResponseFromTheService(int expectedResponseValue) throws Throwable {
        HttpStatus actualStatus = responseFromService.getStatusCode();
        HttpStatus expectedStatus = HttpStatus.valueOf(expectedResponseValue);

        assertThat(actualStatus).isEqualTo(expectedStatus);

    /*    ResponseEntity<Void> response = tflApi.getDisruption(line);
        assertThat(response.getStatusCode().value()).isEqualTo(expectedResponseValue);
*/
   }

    @And("^I should be not shown any disruptions$")
    public void iShouldBeNotShownAnyDisruptions() throws Throwable {
        // write an Assert, described in class MessagingStepDefs. Don't forget to import the public static ... (line15)
        assertThat(responseFromService.getBody()).isNull();

    }
}
