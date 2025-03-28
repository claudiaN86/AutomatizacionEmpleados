package com.orange.tasks;

import com.orange.interactions.ClearInputAction;
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
import static com.orange.userinterfaces.EmployeeListPage.FIRST_EDIT_EMPLOYEE;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;


public class EditPersonalDetailTask implements Task {

    private EmployeeModel data;

    public EditPersonalDetailTask(EmployeeModel data) {
        this.data = data;
    }

    public static Performable editInfo(EmployeeModel data) {
        return Tasks.instrumented(EditPersonalDetailTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPTION_PIM));


        actor.attemptsTo(
                Click.on(FIRST_EDIT_EMPLOYEE)
        );

        actor.attemptsTo(
                WaitUntil.the(INPUT_NAME_EMPLOYEE, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );

        actor.attemptsTo(
                ClearInputAction.clear(INPUT_NAME_EMPLOYEE),
                ClearInputAction.clear(INPUT_NAME_EMPLOYEE),
                Enter.keyValues(data.getFirstName()).into(INPUT_NAME_EMPLOYEE),
                ClearInputAction.clear(INPUT_LAST_NAME_EMPLOYEE),
                Enter.keyValues(data.getLastName()).into(INPUT_LAST_NAME_EMPLOYEE),
                Click.on(BUTTON_SAVE)
        );
    }
}
