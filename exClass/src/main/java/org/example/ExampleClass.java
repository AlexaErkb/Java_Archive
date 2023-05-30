package org.example;

public class ExampleClass {
    private int privateVariable=5;
    protected float protectedVariable=6.0f;
    public String publicVariable="whatever!";
    double noModifierVariable=1111.000000;

    public ExampleClass()
    {

    }

    public ExampleClass(int privateVariable, float protectedVariable, String publicVariable, double noModifierVariable) {
        this.privateVariable = privateVariable;
        this.protectedVariable = protectedVariable;
        this.publicVariable = publicVariable;
        this.noModifierVariable = noModifierVariable;
    }

    public int getPrivateVariable() {
        return privateVariable;
    }

    public void setPrivateVariable(int privateVariable) {
        this.privateVariable = privateVariable;
    }

    public float getProtectedVariable() {
        return protectedVariable;
    }

    public void setProtectedVariable(float protectedVariable) {
        this.protectedVariable = protectedVariable;
    }

    public String getPublicVariable() {
        return publicVariable;
    }

    public void setPublicVariable(String publicVariable) {
        this.publicVariable = publicVariable;
    }

    @Deprecated()
    public double getNoModifierVariable() {
        return noModifierVariable;
    }

    public void setNoModifierVariable(double noModifierVariable) {
        this.noModifierVariable = noModifierVariable;
    }

    private void privateMethod()
    {

    }
}
