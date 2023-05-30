package org.example;

public enum ExampleEnum {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer attr1;
    private String attr2;

    ExampleEnum(Integer attr1, String attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }
}
