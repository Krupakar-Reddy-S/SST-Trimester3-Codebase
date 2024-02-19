# Access Modifiers in Java

Access modifiers in Java determine the scope of a class, constructor, variable, method or data member. There are four types of access modifiers available in Java:

1. **Default (No keyword):** If no access modifier is specified for a class, method, or data member, it will be accessible by any other class in the same package. The classes in other packages will not be able to access these members.

    Example:
    ```java
    class MyClass {
        int num;  // No access modifier, so it's default
        void display() {
            //...
        }
    }
    ```

2. **Private:** The `private` access modifier is specified using the keyword `private`. The methods or data members declared as private are accessible only within the class in which they are declared.

    Example:
    ```java
    public class MyClass {
        private int num;  // Private variable
        private void display() {
            //...
        }
    }
    ```

3. **Public:** The `public` access modifier is specified using the keyword `public`. The methods or data members declared as public are accessible from any other class.

    Example:
    ```java
    public class MyClass {
        public int num;  // Public variable
        public void display() {
            //...
        }
    }
    ```

4. **Protected:** The `protected` access modifier is specified using the keyword `protected`. The methods or data members declared as protected are accessible within the same package or subclasses in different packages.

    Example:
    ```java
    public class MyClass {
        protected int num;  // Protected variable
        protected void display() {
            //...
        }
    }
    ```

In conclusion, access modifiers are used to set the accessibility of classes, interfaces, variables, methods, and data members. Proper use of access modifiers promotes encapsulation and improves maintainability and security of code.