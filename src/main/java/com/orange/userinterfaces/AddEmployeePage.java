package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddEmployeePage {
    public static final Target INPUT_NAME_NEW_EMPLOYEE = Target.the("Input del nombre del nuevo empleado").locatedBy("//input[contains(@class,'firstname')]");
    public static final Target INPUT_LAST_NAME_EMPLOYEE = Target.the("Input del apellido del nuevo empleado").located(By.name("lastName"));
    public static final Target INPUT_ID_NEW_EMPLOYEE = Target.the("Input del ID del nuevo empleado").locatedBy("//label[text()='Employee Id']//following::input[contains(@class,'active')]");
    public static final Target BUTTON_SAVE = Target.the("Button guardar del nuevo empleado").locatedBy("//button[@type='submit']");

    public static final Target POP_UP_SUCCESSFUL_SAVE = Target.the("POP up guardado exitoso del nuevo empleado").locatedBy("//div[contains(@id,'oxd-toaster_')]//child::p[contains(@class,'title')]");


}
