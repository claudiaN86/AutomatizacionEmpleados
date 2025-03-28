package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AlertsPopUpPage {
    public static final Target ALERT_POP_UP_TITLE = Target.the("Alert POP up Title").locatedBy("//div[contains(@id,'oxd-toaster_')]//child::p[contains(@class,'title')]");
    public static final Target ALERT_POP_UP_BODY = Target.the("Alert POP up Body").locatedBy("//div[contains(@id,'oxd-toaster_')]//child::p[contains(@class,'message')]");

}
