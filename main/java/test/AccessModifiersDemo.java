// File: AccessModifiersDemo.java
package main.java.test;
// The public class AccessModifiersDemo can be accessed from any other class.
public class AccessModifiersDemo {

    // Public member variable
    // Can be accessed from any other class
    public int publicVar = 10;

    // Protected member variable
    // Can be accessed within the same package and by subclasses (even if in a different package)
    protected int protectedVar = 20;

    // Default (package-private) member variable
    // Can be accessed only within the same package
    int defaultVar = 30;

    // Private member variable
    // Can be accessed only within this class
    private int privateVar = 40;

    // Public method
    // Can be called from any other class
    public void publicMethod() {
        System.out.println("This is a public method");
        // Public methods can access all members of the class
        System.out.println("Accessing all variables:");
        System.out.println("publicVar: " + publicVar);
        System.out.println("protectedVar: " + protectedVar);
        System.out.println("defaultVar: " + defaultVar);
        System.out.println("privateVar: " + privateVar);
    }

    // Protected method
    // Can be called within the same package and by subclasses
    protected void protectedMethod() {
        System.out.println("This is a protected method");
    }

    // Default (package-private) method
    // Can be called only within the same package
    void defaultMethod() {
        System.out.println("This is a default method");
    }

    // Private method
    // Can be called only within this class
    private void privateMethod() {
        System.out.println("This is a private method");
    }

    // Inner class to demonstrate access modifiers within the same class
    public class InnerClass {
        public void accessMembers() {
            // Inner classes can access all members of the enclosing class,
            // including private members
            System.out.println("InnerClass accessing privateVar: " + privateVar);
            privateMethod();
        }
    }
}

// This class is in the same file to demonstrate default access
class SameFileClass {
    public void accessMembers() {
        AccessModifiersDemo demo = new AccessModifiersDemo();
        // Can access public, protected, and default members
        System.out.println("SameFileClass accessing publicVar: " + demo.publicVar);
        System.out.println("SameFileClass accessing protectedVar: " + demo.protectedVar);
        System.out.println("SameFileClass accessing defaultVar: " + demo.defaultVar);
        // Cannot access private members
        // System.out.println(demo.privateVar); // This would cause a compilation error

        demo.publicMethod();
        demo.protectedMethod();
        demo.defaultMethod();
        // demo.privateMethod(); // This would cause a compilation error
    }
}

// File: SubClass.java (Assume this is in the same package)

// Subclass in the same package
class SubClass extends AccessModifiersDemo {
    public void accessMembers() {
        // Can access public, protected, and default members of the superclass
        System.out.println("SubClass accessing publicVar: " + publicVar);
        System.out.println("SubClass accessing protectedVar: " + protectedVar);
        System.out.println("SubClass accessing defaultVar: " + defaultVar);
        // Cannot access private members of the superclass
        // System.out.println(privateVar); // This would cause a compilation error

        publicMethod();
        protectedMethod();
        defaultMethod();
        // privateMethod(); // This would cause a compilation error
    }
}