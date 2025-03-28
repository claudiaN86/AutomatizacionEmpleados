package com.orange.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class ClearInputAction implements Interaction {
    private Target target;

    public ClearInputAction(Target target) {
        this.target = target;
    }

    public static Interaction clear(Target target){
        return Tasks.instrumented(ClearInputAction.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      //  ((JavascriptExecutor) Serenity.getDriver()).executeScript("arguments[0].value = '';", target.resolveFor(actor));

        target.resolveFor(actor).sendKeys(Keys.CONTROL + "a");
        target.resolveFor(actor).sendKeys(Keys.DELETE);

    }
}
