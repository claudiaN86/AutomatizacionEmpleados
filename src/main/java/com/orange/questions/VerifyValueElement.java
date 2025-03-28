package com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyValueElement implements Question<Boolean> {

    private Target target;
    private String value;


    public VerifyValueElement(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static VerifyValueElement verify(Target target, String value) {
        return new VerifyValueElement(target, value);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getValue().equals(value);
    }
}
