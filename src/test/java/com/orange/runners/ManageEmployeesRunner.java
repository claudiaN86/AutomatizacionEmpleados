package com.orange.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/manage_employees.feature",
        glue = "com.orange",
        //tags = "@EditEmployee",
        tags = "@AddingEmployee",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ManageEmployeesRunner {
}
