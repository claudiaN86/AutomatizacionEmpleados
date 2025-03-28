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
import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_TITLE;
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
                Enter.theValue(data.getFirstName()).into(INPUT_NAME_EMPLOYEE),
                Enter.theValue(data.getLastName()).into(INPUT_LAST_NAME_EMPLOYEE)
        );

        actor.attemptsTo(
                Click.on(BUTTON_SAVE),
                WaitUntil.the(ALERT_POP_UP_TITLE, WebElementStateMatchers.isNotCurrentlyVisible()).forNoMoreThan(5).seconds()

        );

    }
}
