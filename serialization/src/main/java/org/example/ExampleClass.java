package org.example;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExampleClass {

    private String stringAttr;
    private Double doubleAttr;
    private int intattr;
    private Date date;
    private Map<String,String> properies;
    private ExampleEnum anEnum;
    private List<HelperClass> listAttr;

    public String getStringAttr() {
        return stringAttr;
    }

    public void setStringAttr(String stringAttr) {
        this.stringAttr = stringAttr;
    }

    public Double getDoubleAttr() {
        return doubleAttr;
    }

    public void setDoubleAttr(Double doubleAttr) {
        this.doubleAttr = doubleAttr;
    }

    public int getIntattr() {
        return intattr;
    }

    public void setIntattr(int intattr) {
        this.intattr = intattr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, String> getProperies() {
        return properies;
    }

    public void setProperies(Map<String, String> properies) {
        this.properies = properies;
    }

    public ExampleEnum getAnEnum() {
        return anEnum;
    }

    public void setAnEnum(ExampleEnum anEnum) {
        this.anEnum = anEnum;
    }

    public List<HelperClass> getListAttr() {
        return listAttr;
    }

    public void setListAttr(List<HelperClass> listAttr) {
        this.listAttr = listAttr;
    }

    @Override
    public String toString() {
        return "ExampleClass{" +
                "stringAttr='" + stringAttr + '\'' +
                ", doubleAttr=" + doubleAttr +
                ", intattr=" + intattr +
                ", date=" + date +
                ", properies=" + properies +
                ", anEnum=" + anEnum +
                ", listAttr=" + listAttr +
                '}';
    }
}
