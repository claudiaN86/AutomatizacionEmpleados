package com.orange.tasks;

import com.orange.models.EmployeeModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.orange.userinterfaces.EmployeeListPage.BUTTON_SEARCH;
import static com.orange.userinterfaces.EmployeeListPage.INPUT_SEARCH_NAME_EMPLOYEE;
import static com.orange.userinterfaces.VerticalNavbarPage.OPTION_PIM;

public class SearchEmployeeTask implements Task {
    private String name;

    public SearchEmployeeTask(String name) {
        this.name = name;
    }

    public static Performable search(String name) {
        return Tasks.instrumented(SearchEmployeeTask.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(OPTION_PIM));

        actor.attemptsTo(
                Enter.keyValues(name).into(INPUT_SEARCH_NAME_EMPLOYEE),
                Click.on(BUTTON_SEARCH)
        );
    }
}
