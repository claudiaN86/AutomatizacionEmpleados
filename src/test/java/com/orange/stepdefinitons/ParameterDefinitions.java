package com.orange.stepdefinitons;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ParameterDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Ramiro");
    }

    @After
    public void closeStage() {
        Serenity.getWebdriverManager().closeCurrentDrivers();
    }

}
