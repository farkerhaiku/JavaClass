package edu.stlcc.jasonmayer.javaclass.models;

import android.text.TextUtils;
import android.util.Log;

public class ProjectFourEmployee {
    public static final String[] COLUMNS = new String[]{
            "Empno", "Firstname", "Lastname", "MiddleInit", "Suffix",
            "Address1", "Address2", "City", "State", "Zip", "Phone",
            "Gender", "Status", "HireDate", "TerminateDt", "PayCd"};

    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String suffix;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String gender;
    private String status;
    private String hireDate;
    private String terminationDate;
    private String payCode;

    @Override
    public String toString() {
        return "ProjectFourEmployee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", suffix='" + suffix + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", terminationDate='" + terminationDate + '\'' +
                ", payCode='" + payCode + '\'' +
                '}';
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }


    public static ProjectFourEmployee from(String[] string) {
        if(string.length != COLUMNS.length) {
            throw new UnsupportedOperationException("failed to parse data correctly for " + TextUtils.join(",", string));
        }

        ProjectFourEmployee employee = new ProjectFourEmployee();
        employee.setEmployeeNumber(string[0]);
        employee.setFirstName(string[1]);
        employee.setLastName(string[2]);
        employee.setMiddleInitial(string[3]);
        employee.setSuffix(string[4]);
        employee.setAddress1(string[5]);
        employee.setAddress2(string[6]);
        employee.setCity(string[7]);
        employee.setState(string[8]);
        employee.setZip(string[9]);
        employee.setPhone(string[10]);
        employee.setGender(string[11]);
        employee.setStatus(string[12]);
        employee.setHireDate(string[13]);
        employee.setTerminationDate(string[14]);
        employee.setPayCode(string[15]);
        return employee;
    }
}
