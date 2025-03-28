package com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyTextElement implements Question<Boolean> {

    private Target target;
    private String value;


    public VerifyTextElement(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static VerifyTextElement verify(Target target, String value) {
        return new VerifyTextElement(target, value);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().equals(value);
    }
}
