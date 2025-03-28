package com.orange.models;

import com.orange.utils.GenerateId;

import java.util.List;

public class EmployeeModel {

    private String firstName;
    private String lastName;
    private String otherEmail;
    private String province;
    private String messageTitle;
    private String messageBody;

    public EmployeeModel(List<List<String>> data) {
        this.firstName = data.get(0).get(0);
        this.lastName = data.get(0).get(1);
        this.otherEmail = data.get(0).get(2).replace("#", GenerateId.generateSerial(5));
        this.province = data.get(0).get(3);
        this.messageTitle = data.get(0).get(4);
        this.messageBody = data.get(0).get(5);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    public String getProvince() {
        return province;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }
}
