package com.orange.stepdefinitons;

import com.orange.models.EmployeeModel;
import com.orange.questions.VerifyTextElement;
import com.orange.questions.VerifyValueElement;
import com.orange.tasks.AccessContactDetailsTask;
import com.orange.tasks.AccessLoginTask;
import com.orange.tasks.AddEmployeeTask;
import com.orange.tasks.EditPersonalDetailTask;
import com.orange.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static com.orange.userinterfaces.AddEmployeePage.POP_UP_SUCCESSFUL_SAVE;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ManageEmployeesStepDefinition {

    private EmployeeModel employeeModel;

    @Given("the user is logged into OrangeHRM")
    public void theUserIsLoggedIntoOrangeHRM() {
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().the(HomePage.class),
                AccessLoginTask.withData()
        );
    }

    @When("the user adds a new employee with the data")
    public void theUserAddsANewEmployeeWithTheData(List<List<String>> data) {
        employeeModel=new EmployeeModel(data);

        theActorInTheSpotlight().attemptsTo(
                AddEmployeeTask.addWithData(employeeModel),
                AccessContactDetailsTask.withData(employeeModel)
        );

    }

    @Then("the employee should be created successfully with your data")
    public void theEmployeeShouldBeCreatedSuccessfullyWithYourData() {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Fallo botón Save", VerifyTextElement.verify(POP_UP_SUCCESSFUL_SAVE, employeeModel.getMessage())),
                GivenWhenThen.seeThat("El Full Name es diferente", VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName()+ " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("El Email es diferente", VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("La Provincia es diferente", VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince()))
        );

    }

    @When("the user updates an existing employee's details")
    public void theUserUpdatesAnExistingEmployeeSDetails(List<List<String>> data) {
        employeeModel=new EmployeeModel(data);
        theActorInTheSpotlight().attemptsTo(
                EditPersonalDetailTask.editInfo(employeeModel),
                AccessContactDetailsTask.withData(employeeModel)
        );

    }
    @Then("the updated details should be visible in the list")
    public void theUpdatedDetailsShouldBeVisibleInTheList() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Fallo botón Save", VerifyTextElement.verify(POP_UP_SUCCESSFUL_SAVE, employeeModel.getMessage())),
                GivenWhenThen.seeThat("El Full Name es diferente", VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName()+ " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("El Email es diferente", VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("La Provincia es diferente", VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince()))
        );
    }
}
