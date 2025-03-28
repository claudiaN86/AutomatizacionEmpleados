package com.orange.tasks;

import com.orange.models.EmployeeModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orange.userinterfaces.AddEmployeePage.*;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
import static com.orange.userinterfaces.HorizontalNavbarPage.OPTION_ADD_EMPLOYEE;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;

public class AddEmployeeTask implements Task {
    private EmployeeModel data;

    public AddEmployeeTask(EmployeeModel data) {
        this.data = data;
    }

    public static Performable addWithData(EmployeeModel data) {
        return Tasks.instrumented(AddEmployeeTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPTION_PIM),
                Click.on(OPTION_ADD_EMPLOYEE),
                Enter.theValue(data.getFirstName()).into(INPUT_NAME_NEW_EMPLOYEE),
                Enter.theValue(data.getLastName()).into(INPUT_LAST_NAME_EMPLOYEE)
        );

        actor.attemptsTo(
                Click.on(BUTTON_SAVE),
                WaitUntil.the(POP_UP_SUCCESSFUL_SAVE, WebElementStateMatchers.isNotCurrentlyVisible()).forNoMoreThan(5).seconds(),
                Click.on(OPTION_CONTACT_DETAILS)
        );

        actor.attemptsTo(
                WaitUntil.the(INPUT_OTHER_EMAIL, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds(),
                Enter.keyValues(data.getProvince()).into(INPUT_STATE_PROVINCE),
                Enter.keyValues(data.getProvince()).into(INPUT_STATE_PROVINCE)

        );

        actor.attemptsTo(
                Enter.keyValues(data.getOtherEmail()).into(INPUT_OTHER_EMAIL),
                Click.on(BUTTON_SAVE)
        );
    }
}
