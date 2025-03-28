package com.orange.tasks;

import com.orange.utils.GenerateId;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.orange.userinterfaces.AddEmployeePage.*;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
import static com.orange.userinterfaces.HorizontalNavbarPage.OPTION_ADD_EMPLOYEE;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;

public class AddEmployeeTask implements Task {
    private List<List<String>> data;

    public AddEmployeeTask(List<List<String>> data) {
        this.data = data;
    }

    public static Performable addWithData(List<List<String>> data) {
        return Tasks.instrumented(AddEmployeeTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPTION_PIM),
                Click.on(OPTION_ADD_EMPLOYEE),
                Enter.theValue(data.get(0).get(0)).into(INPUT_NAME_NEW_EMPLOYEE),
                Enter.theValue(data.get(0).get(1)).into(INPUT_LAST_NAME_EMPLOYEE)
        );
        Serenity.setSessionVariable("idEmployee").to(INPUT_ID_NEW_EMPLOYEE.resolveFor(actor).getValue());
        System.out.println((String) Serenity.sessionVariableCalled("idEmployee"));

        actor.attemptsTo(
                Click.on(BUTTON_SAVE),
                WaitUntil.the(POP_UP_SUCCESSFUL_SAVE, WebElementStateMatchers.isNotCurrentlyVisible()).forNoMoreThan(5).seconds(),
                Click.on(OPTION_CONTACT_DETAILS)
        );

        actor.attemptsTo(
                WaitUntil.the(INPUT_OTHER_EMAIL, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds(),
                Enter.keyValues(data.get(0).get(3)).into(INPUT_STATE_PROVINCE),
                Enter.keyValues(data.get(0).get(3)).into(INPUT_STATE_PROVINCE)

        );

        Serenity.setSessionVariable("email").to(data.get(0).get(2).replace("#", GenerateId.generateSerial(5)));

        actor.attemptsTo(
                Enter.keyValues(Serenity.sessionVariableCalled("email").toString()).into(INPUT_OTHER_EMAIL),
                Click.on(BUTTON_SAVE)
        );
    }
}
