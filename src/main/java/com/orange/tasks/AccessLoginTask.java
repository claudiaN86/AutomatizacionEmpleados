package com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.orange.userinterfaces.LoginPage.*;

public class AccessLoginTask implements Task {

    public static Performable withData() {
        return Tasks.instrumented(AccessLoginTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Admin").into(INPUT_USERNAME),
                Enter.theValue("admin123").into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
    }
}
