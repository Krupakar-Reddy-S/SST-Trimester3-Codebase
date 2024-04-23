public class MyClass {
    public int publicField;
    private String privateField;

    public void setPrivateField(String value) {
        this.privateField = value;
    }

    public String getPrivateField() {
        return this.privateField;
    }

    public void doSomething() {
        System.out.println("This is a public method.");
    }

    protected void doSomethingElse() {
        System.out.println("This is a protected method.");
    }
}

