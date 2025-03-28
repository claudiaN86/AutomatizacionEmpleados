package com.orange.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetailsEmployeePage {

    public static final Target OPTION_CONTACT_DETAILS = Target.the("opcion contact details de vertical navbar del perfil").locatedBy("//div[@role='tab']/child::a[text()='Contact Details']");
    public static final Target INPUT_STATE_PROVINCE = Target.the("Input provincia del nuevo empleado").locatedBy("(//label[text()='State/Province']/following::div/input)[1]");
    public static final Target INPUT_OTHER_EMAIL = Target.the("Input Otro Email del nuevo empleado").locatedBy("(//label[text()='Other Email']/following::div/input)[1]");
    public static final Target LABEL_FULL_NAME = Target.the("Nombre del nuevo empleado").locatedBy("//div[contains(@class,'name')]/h6");
    public static final Target BUTTON_PLUS_ATTACHMENTS = Target.the("Button plus para Attachment file empleado").locatedBy("//i[contains(@class,'icon bi-plus')]//parent::button");
    public static final Target BUTTON_BROWSE_ATTACHMENTS = Target.the("Button navegadir para buscar file empleado").locatedBy("//input[contains(@class,'file-input')]");
    public static final Target BUTTON_SAVE_ATTACHMENTS = Target.the("Button save file  empleado") .located(By.xpath("//h6[text()='Add Attachment']//following::button[contains(@class,'button--secondary')]"));
    public static final Target LIST_FILENAME_ATTACHMENTS = Target.the("Lista de documentos cargados").locatedBy("//div[contains(@class,'table-cell')][2]/child::div[text()='{0}']");
    public static final Target ICON_DELETE_FILE= Target.the("Icono de eliminación de archivo").locatedBy("(//div[contains(@class,'table-cell')][2]/child::div[text()='{0}']/following::i[contains(@class,'trash')])[1]");
    public static final Target BUTTON_DELETE_FILE_CONFIRMATION= Target.the("Botón de confirmación de eliminacion del archivo").locatedBy("//i[@class='oxd-icon bi-trash oxd-button-icon']");
    public static final Target LIST_FILENAME_ATTACHMENTS_DETAILS= Target.the("Documento cargado").locatedBy("//div[contains(text(),'{0}')]");

}
