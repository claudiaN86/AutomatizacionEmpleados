package com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.orange.userinterfaces.AddEmployeePage.POP_UP_SUCCESSFUL_SAVE;

public class VerifyMessage implements Question<Boolean> {

    private List<List<String>> data;

    public VerifyMessage(List<List<String>> data) {
        this.data = data;
    }

    public static VerifyMessage verify(List<List<String>> data) {
        return new VerifyMessage(data);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return POP_UP_SUCCESSFUL_SAVE.resolveFor(actor).getText().equals(data.get(0).get(3));
    }
}
