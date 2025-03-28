package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EmployeeListPage {
    public static final Target FIRST_EDIT_EMPLOYEE = Target.the("Primer empleado a editar").locatedBy("(//button[@type='button']/child::i[contains(@class,'pencil')])[1]");
    public static final Target ICON_TRASH_EMPLOYEE = Target.the("Primer empleado a editar").locatedBy("(//div[contains(@class,'table-cell')][2]/child::div[text()='{0}']/following::i[contains(@class,'trash')])[1]");
    public static final Target LIST_NAME_EMPLOYEES = Target.the("Lista de nombres de empleados").locatedBy("//div[contains(@class,'table-cell')][3]/child::div");
    public static final Target LIST_ID_EMPLOYEES = Target.the("Lista de nombres de empleados").locatedBy("//div[contains(@class,'table-cell')][2]/child::div");

    public static final Target INPUT_SEARCH_NAME_EMPLOYEE = Target.the("Input del nombre del empleado").locatedBy("(//label[text()='Employee Name']/following::input)[1]");
    public static final Target INPUT_SEARCH_ID_EMPLOYEE = Target.the("Input del ID del empleado").locatedBy("(//label[text()='Employee Name']/following::input)[2]");

    public static final Target BUTTON_SEARCH = Target.the("Button search del  empleado").locatedBy("//button[@type='submit']");
    public static final Target BUTTON_YES_DELETE = Target.the("Button yes para eliminar").locatedBy("//button[contains(@class,'danger')]");


}
