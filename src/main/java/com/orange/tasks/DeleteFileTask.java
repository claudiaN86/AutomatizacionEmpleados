package com.orange.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.orange.userinterfaces.DetailsEmployeePage.BUTTON_DELETE_FILE_CONFIRMATION;
import static com.orange.userinterfaces.DetailsEmployeePage.ICON_DELETE_FILE;

public class DeleteFileTask implements Task {

    public static Performable delete() {
        return Tasks.instrumented(DeleteFileTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String newfileName = Serenity.sessionVariableCalled("newFileName").toString();
        actor.attemptsTo(
                Scroll.to(ICON_DELETE_FILE.of(newfileName)).andAlignToTop(),
                Click.on(ICON_DELETE_FILE.of(newfileName)),
                Click.on(BUTTON_DELETE_FILE_CONFIRMATION)
        );
    }
}
