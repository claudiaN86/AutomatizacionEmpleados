package com.orange.stepdefinitons;

import com.orange.models.EmployeeModel;
import com.orange.questions.VerifyNameInList;
import com.orange.questions.VerifyTextElement;
import com.orange.questions.VerifyValueElement;
import com.orange.tasks.*;
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
        employeeModel = new EmployeeModel(data);

        theActorInTheSpotlight().attemptsTo(
                AddEmployeeTask.addWithData(employeeModel),
                AccessContactDetailsTask.withData(employeeModel)
        );

    }

    @Then("the employee should be created successfully with your data")
    public void theEmployeeShouldBeCreatedSuccessfullyWithYourData() {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que muestre pop-up Success: ", VerifyTextElement.verify(POP_UP_SUCCESSFUL_SAVE, employeeModel.getMessage())),
                GivenWhenThen.seeThat("Se espera que Full Name sea el ingresado: ", VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName() + " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("Se espera que el Email sea el ingresado: ", VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("Se espera que La Provincia sea el ingresado: ", VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince()))
        );

    }

    @When("the user updates an existing employee's details")
    public void theUserUpdatesAnExistingEmployeeSDetails(List<List<String>> data) {
        employeeModel = new EmployeeModel(data);
        theActorInTheSpotlight().attemptsTo(
                EditPersonalDetailTask.editInfo(employeeModel),
                AccessContactDetailsTask.withData(employeeModel)
        );

    }

    @Then("the updated details should be visible in the list")
    public void theUpdatedDetailsShouldBeVisibleInTheList() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que muestre pop-up Success: ", VerifyTextElement.verify(POP_UP_SUCCESSFUL_SAVE, employeeModel.getMessage())),
                GivenWhenThen.seeThat("Se espera que Full Name sea el ingresado: ", VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName() + " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("Se espera que el Email sea el ingresado: ", VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("Se espera que La Provincia sea el ingresado: ", VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince()))
        );
    }


    @When("the user on Employee List page searches an employee {string}")
    public void theUserOnEmployeeListPageSearchesAnEmployeeBySara(String name) {
        theActorInTheSpotlight().attemptsTo(
                SearchEmployeeTask.search(name)
        );
    }

    @Then("the correct employee {string} should appear in the results")
    public void theCorrectEmployeeSaraShouldAppearInTheResults(String name) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que este el nombre este de la columna firstname de la lista: ", VerifyNameInList.verify(name))
        );
    }
}
