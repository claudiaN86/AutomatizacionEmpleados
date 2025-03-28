package com.orange.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;

public class UploadFileAction implements Interaction {
    private Target target;
    private String fileName;

    public UploadFileAction(Target target, String fileName) {
        this.target = target;
        this.fileName = fileName;
    }

    public static Interaction upload(Target target, String fileName) {
        return Tasks.instrumented(UploadFileAction.class, target, fileName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String pathProject = System.getProperty("user.dir");

        ((JavascriptExecutor) Serenity.getDriver()).executeScript("arguments[0].scrollIntoView(true);", target.resolveFor(actor));
        target.resolveFor(actor).sendKeys(pathProject + "\\src\\test\\resources\\data\\" + fileName);

    }
}
