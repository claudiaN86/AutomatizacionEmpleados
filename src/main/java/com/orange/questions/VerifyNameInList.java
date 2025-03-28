package com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;

import static com.orange.userinterfaces.EmployeeListPage.LIST_NAME_EMPLOYEES;

public class VerifyNameInList implements Question<Boolean> {

    private String name;

    public VerifyNameInList(String name) {
        this.name = name;
    }

    public static VerifyNameInList verify(String name) {
        return new VerifyNameInList(name);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        for (WebElement webElement : LIST_NAME_EMPLOYEES.resolveAllFor(actor)) {
            if (!webElement.getText().contains(name)) {
                return false;
            }
        }

        return true;
    }
}
