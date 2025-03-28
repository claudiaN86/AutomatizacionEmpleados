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
import static com.orange.userinterfaces.DetailsEmployeePage.*;

public class AccessContactDetailsTask implements Task {

    private EmployeeModel data;

    public AccessContactDetailsTask(EmployeeModel data) {
        this.data = data;
    }

    public static Performable withData(EmployeeModel data) {
        return Tasks.instrumented(AccessContactDetailsTask.class, data);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPTION_CONTACT_DETAILS),
                WaitUntil.the(INPUT_OTHER_EMAIL, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds(),
                ClearInputAction.clear(INPUT_STATE_PROVINCE),
                Enter.keyValues(data.getProvince()).into(INPUT_STATE_PROVINCE)

        );

        actor.attemptsTo(
                ClearInputAction.clear(INPUT_OTHER_EMAIL),
                Enter.keyValues(data.getOtherEmail()).into(INPUT_OTHER_EMAIL),
                Click.on(BUTTON_SAVE),
                WaitUntil.the(POP_UP_SUCCESSFUL_SAVE, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );
    }
}
