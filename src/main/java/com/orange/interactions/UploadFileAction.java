package com.orange.interactions;

import com.orange.utils.GenerateId;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

public class UploadFileAction implements Interaction {
    private Target target;
    private String fileName;

    public UploadFileAction(Target target, String fileName) {
        this.target = target;
        this.fileName = fileName;
    }

    public static Interaction upload(Target target, String fileName) {
        return Tasks.instrumented(UploadFileAction.class, target, fileName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String idGenerated = GenerateId.generateSerial(5);
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject + "\\src\\test\\resources\\data\\";
        String newNameFile = renameFile(pathFile, fileName, "", idGenerated);
        String pathFileWithName = pathFile + newNameFile;

        ((JavascriptExecutor) Serenity.getDriver()).executeScript("arguments[0].scrollIntoView(true);", target.resolveFor(actor));
        target.resolveFor(actor).sendKeys(pathFileWithName);

        Serenity.setSessionVariable("newFileName").to(newNameFile);

        renameFile(pathFile, fileName, newNameFile, idGenerated);
    }

    private String renameFile(String pathFile, String fileName, String newFileName, String idGenerated) {

        String newFileNameActual = fileName.replace("#", idGenerated);
        File oldFile = new File(pathFile + fileName);
        File newFile = new File(pathFile + newFileNameActual);

        if (fileName.contains("#") && newFileName.isEmpty()) {
            oldFile.renameTo(newFile);
            return newFileNameActual;
        } else {
            newFile.renameTo(oldFile);
            return fileName;
        }
    }


}
