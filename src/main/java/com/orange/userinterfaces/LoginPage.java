package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target INPUT_USERNAME= Target.the("Input del nombre del usuario").locatedBy("//input[@name='username']");
    public static final Target INPUT_PASSWORD= Target.the("Input de la contraseña del usuario").locatedBy("//input[@name='password']");
    public static final Target BUTTON_LOGIN= Target.the("Botón de login").locatedBy("//button[text()=' Login ']");

}
