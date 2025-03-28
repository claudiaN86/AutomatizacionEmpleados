package com.orange.stepdefinitons;

import com.orange.models.EmployeeModel;
import com.orange.questions.VerifyNameInList;
import com.orange.questions.VerifyNoVisibleTextElement;
import com.orange.questions.VerifyTextElement;
import com.orange.questions.VerifyValueElement;
import com.orange.tasks.*;
import com.orange.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_BODY;
import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_TITLE;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ManageEmployeesStepDefinition {

    private EmployeeModel employeeModel;

    @Given("the user is logged into OrangeHRM")
    public void theUserIsLoggedIntoOrangeHRM() {
        theActorInTheSpotlight().wasAbleTo(Open.browserOn().the(HomePage.class), AccessLoginTask.withData());
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
                GivenWhenThen.seeThat("Se espera que muestre pop-up Title Success: ",
                        VerifyTextElement.verify(ALERT_POP_UP_TITLE, employeeModel.getMessageTitle())),
                GivenWhenThen.seeThat("Se espera que muestre pop-up Body Success: ",
                        VerifyTextElement.verify(ALERT_POP_UP_BODY, employeeModel.getMessageBody())),
                GivenWhenThen.seeThat("Se espera que Full Name sea el ingresado: ",
                        VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName() + " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("Se espera que el Email sea el ingresado: ",
                        VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("Se espera que La Provincia sea el ingresado: ",
                        VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince())));
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
                GivenWhenThen.seeThat("Se espera que muestre pop-up Title info: ", VerifyTextElement.verify(ALERT_POP_UP_TITLE, employeeModel.getMessageTitle())),
                GivenWhenThen.seeThat("Se espera que muestre pop-up Body No Records Found: ", VerifyTextElement.verify(ALERT_POP_UP_BODY, employeeModel.getMessageBody())),
                GivenWhenThen.seeThat("Se espera que Full Name sea el ingresado: ", VerifyTextElement.verify(LABEL_FULL_NAME, employeeModel.getFirstName() + " " + employeeModel.getLastName())),
                GivenWhenThen.seeThat("Se espera que el Email sea el ingresado: ", VerifyValueElement.verify(INPUT_OTHER_EMAIL, employeeModel.getOtherEmail())),
                GivenWhenThen.seeThat("Se espera que La Provincia sea el ingresado: ", VerifyValueElement.verify(INPUT_STATE_PROVINCE, employeeModel.getProvince()))
        );
    }


    @When("the user on Employee List page searches an employee {string}")
    public void theUserOnEmployeeListPageSearchesAnEmployeeBySara(String name) {
        theActorInTheSpotlight().attemptsTo(SearchEmployeeTask.search(name));
    }

    @Then("the correct employee {string} should appear in the results")
    public void theCorrectEmployeeSaraShouldAppearInTheResults(String name) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat("Se espera que este el nombre este de la columna firstname de la lista: ", VerifyNameInList.verify(name)));
    }


    @When("the user on Employee List page deleted an employee in the list")
    public void theUserOnEmployeeListPageDeletedAnEmployeeInTheList() {
        theActorInTheSpotlight().attemptsTo(
                DeleteEmployeeTask.delete()
        );
    }

    @Then("the employee deleted show {string} {string} and should no longer be in the list")
    public void theEmployeeDeletedShowAndShouldNoLongerBeInTheList(String messageTitle, String messageBody) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que muestre pop-up Title info: ", VerifyTextElement.verify(ALERT_POP_UP_TITLE, messageTitle)),
                GivenWhenThen.seeThat("Se espera que muestre pop-up Body No Records Found: ", VerifyTextElement.verify(ALERT_POP_UP_BODY, messageBody))
        );
    }


    @When("the user on Contact Details uploads a valid file {string}")
    public void theUserOnContactDetailsUploadsAValidFile(String fileName) {
        theActorInTheSpotlight().attemptsTo(
                UploadFileTask.upload(fileName)
        );
    }

    @Then("the file should be visible below the form")
    public void theFileShouldBeVisibleBelowTheForm() {
        String newFileName = Serenity.sessionVariableCalled("newFileName").toString();

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que archivo se cargo: ",
                        VerifyTextElement.verify(LIST_FILENAME_ATTACHMENTS.of(newFileName), newFileName))
        );
    }

    @When("the user on Contact Details deletes the file {string}")
    public void theUserOnContactDetailsDeletesTheFile(String fileName) {
        theActorInTheSpotlight().attemptsTo(
                UploadFileTask.upload(fileName),
                DeleteFileTask.delete()
        );

    }

    @Then("messages must be visible {string} {string} and the file is no longer visible in the list")
    public void messagesMustBeVisibleAndTheFileIsNoLongerVisibleInTheList(String messageTitle, String messageBody) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("Se espera que muestre pop-up Title info: ", VerifyTextElement.verify(ALERT_POP_UP_TITLE, messageTitle)),
                GivenWhenThen.seeThat("Se espera que muestre pop-up Body No Records Found: ", VerifyTextElement.verify(ALERT_POP_UP_BODY, messageBody)),
                GivenWhenThen.seeThat("Se espera que no se visualice el archivo eliminado: ", VerifyNoVisibleTextElement.verify(LIST_FILENAME_ATTACHMENTS_DETAILS, Serenity.sessionVariableCalled("newFileName")))
        );
    }
}
