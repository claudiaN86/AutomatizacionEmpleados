package com.orange.tasks;

import com.orange.interactions.UploadFileAction;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.orange.userinterfaces.AddEmployeePage.INPUT_NAME_EMPLOYEE;
import static com.orange.userinterfaces.AlertsPopUpPage.ALERT_POP_UP_TITLE;
import static com.orange.userinterfaces.DetailsEmployeePage.*;
import static com.orange.userinterfaces.EmployeeListPage.FIRST_EDIT_EMPLOYEE;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;

public class UploadFileTask implements Task {

    private String fileName;

    public UploadFileTask(String fileName) {
        this.fileName = fileName;
    }

    public static Performable upload(String fileName) {
        return Tasks.instrumented(UploadFileTask.class, fileName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(OPTION_PIM),
                Click.on(FIRST_EDIT_EMPLOYEE),
                WaitUntil.the(INPUT_NAME_EMPLOYEE, WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );

        actor.attemptsTo(
                Click.on(OPTION_CONTACT_DETAILS),
                Click.on(BUTTON_PLUS_ATTACHMENTS),
                UploadFileAction.upload(BUTTON_BROWSE_ATTACHMENTS, fileName)

        );
        actor.attemptsTo(
                Scroll.to(BUTTON_SAVE_ATTACHMENTS).andAlignToTop(),
                Click.on(BUTTON_SAVE_ATTACHMENTS),
                Ensure.that(ALERT_POP_UP_TITLE).text().isEqualTo("Success"),
                WaitUntil.the(LIST_FILENAME_ATTACHMENTS.of(Serenity.sessionVariableCalled("newFileName").toString()), WebElementStateMatchers.isPresent()).forNoMoreThan(5).seconds()
        );

    }
}
