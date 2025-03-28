package com.orange.stepdefinitons;

import com.orange.tasks.AccessLoginTask;
import com.orange.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ManageEmployeesStepdefinition {

    @Given("the user is logged into OrangeHRM")
    public void theUserIsLoggedIntoOrangeHRM() {
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().the(HomePage.class),
                AccessLoginTask.withData()
        );

    }
    @When("the user adds a new employee with the data")
    public void theUserAddsANewEmployeeWithTheData(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("the employee should be created successfully with your data")
    public void theEmployeeShouldBeCreatedSuccessfullyWithYourData(io.cucumber.datatable.DataTable dataTable) {

    }
}
