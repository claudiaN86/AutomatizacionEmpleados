package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetailsEmployeePage {

    public static final Target OPTION_CONTACT_DETAILS = Target.the("opcion contact details de vertical navbar del perfil").locatedBy("//div[@role='tab']/child::a[text()='Contact Details']");
    public static final Target INPUT_STATE_PROVINCE = Target.the("Input provincia del nuevo empleado").locatedBy("(//label[text()='State/Province']/following::div/input)[1]");
    public static final Target INPUT_OTHER_EMAIL = Target.the("Input Otro Email del nuevo empleado").locatedBy("(//label[text()='Other Email']/following::div/input)[1]");
    public static final Target LABEL_FULL_NAME = Target.the("Nombre del nuevo empleado").locatedBy("//div[contains(@class,'name')]/h6");

}
