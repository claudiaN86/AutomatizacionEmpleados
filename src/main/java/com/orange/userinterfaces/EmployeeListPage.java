package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EmployeeListPage {
    public static final Target FIRST_EDIT_EMPLOYEE = Target.the("Primer empleado de editar").locatedBy("(//button[@type='button']/child::i[contains(@class,'pencil')])[1]");


}
