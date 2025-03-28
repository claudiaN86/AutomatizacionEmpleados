package com.orange.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/manage_employees.feature", glue = "com.orange",
        //tags = "@AddingEmployee",
        //tags = "@EditEmployee",
        //tags = "@SearchEmployee",
        tags = "@DeleteEmployee",
        // tags = "@UploadFile",
        //tags = "@DeleteUploadFile",
       // tags = "@ManageEmployee",
        plugin = {"pretty"}, snippets = CucumberOptions.SnippetType.CAMELCASE)

public class ManageEmployeesRunner {
}
