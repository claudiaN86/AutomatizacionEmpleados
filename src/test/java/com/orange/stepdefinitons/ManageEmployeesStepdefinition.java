package com.orange.stepdefinitons;

import com.orange.questions.VerifyTextElement;
import com.orange.questions.VerifyValueElement;
import com.orange.tasks.AccessLoginTask;
import com.orange.tasks.AddEmployeeTask;
import com.orange.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static com.orange.userinterfaces.AddEmployeePage.POP_UP_SUCCESSFUL_SAVE;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
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
    public void theUserAddsANewEmployeeWithTheData(List<List<String>> data) {
        theActorInTheSpotlight().attemptsTo(
                AddEmployeeTask.addWithData(data)
        );

    }

    @Then("the employee should be created successfully with your data")
    public void theEmployeeShouldBeCreatedSuccessfullyWithYourData(List<List<String>> data) {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Fallo botón Save", VerifyTextElement.verify(POP_UP_SUCCESSFUL_SAVE, data.get(0).get(3))),
                GivenWhenThen.seeThat("El Full Name es diferente", VerifyTextElement.verify(LABEL_FULL_NAME, data.get(0).get(0) + " " + data.get(0).get(1))),
                GivenWhenThen.seeThat("El Email es diferente", VerifyValueElement.verify(INPUT_OTHER_EMAIL, Serenity.sessionVariableCalled("email").toString())),
                GivenWhenThen.seeThat("La Provincia es diferente", VerifyValueElement.verify(INPUT_STATE_PROVINCE, data.get(0).get(2)))
        );

    }
}
