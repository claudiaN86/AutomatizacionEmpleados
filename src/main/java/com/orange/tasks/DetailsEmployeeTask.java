package com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;


public class DetailsEmployeeTask implements Task {

    private List<List<String>> data;

    public DetailsEmployeeTask(List<List<String>> data) {
        this.data = data;
    }

    public static Performable addInfo(List<List<String>> data){
        return Tasks.instrumented(DetailsEmployeeTask.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }
}
