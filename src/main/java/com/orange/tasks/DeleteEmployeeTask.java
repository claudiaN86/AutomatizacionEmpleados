package com.orange.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_BODY;
import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_TITLE;
import static com.orange.userinterfaces.EmployeeListPage.*;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;

public class DeleteEmployeeTask implements Task {

    public static Performable delete() {
        return Tasks.instrumented(DeleteEmployeeTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(OPTION_PIM));

        String idEmployee = LIST_ID_EMPLOYEES.resolveAllFor(actor).get(0).getText();
        Serenity.setSessionVariable("idEmployee").to(idEmployee);

        actor.attemptsTo(
                Click.on(ICON_TRASH_EMPLOYEE.of(idEmployee)),
                Click.on(BUTTON_YES_DELETE),
                WaitUntil.the(ALERT_POP_UP_TITLE, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds(),
                Ensure.that(ALERT_POP_UP_BODY).text().isEqualTo("Successfully Deleted"),
                WaitUntil.the(ALERT_POP_UP_BODY, WebElementStateMatchers.isNotCurrentlyVisible()).forNoMoreThan(5).seconds()
        );

        actor.attemptsTo(

                Enter.keyValues(idEmployee).into(INPUT_SEARCH_ID_EMPLOYEE),
                Click.on(BUTTON_SEARCH),
                WaitUntil.the(ALERT_POP_UP_TITLE, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );
    }
}
