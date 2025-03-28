package com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyNoVisibleTextElement implements Question<Boolean> {

    private Target target;
    private String fileName;


    public VerifyNoVisibleTextElement(Target target, String fileName) {
        this.target = target;
        this.fileName = fileName;

    }

    public static VerifyNoVisibleTextElement verify(Target target, String fileName) {
        return new VerifyNoVisibleTextElement(target, fileName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !target.of(fileName).isVisibleFor(actor);
    }
}
