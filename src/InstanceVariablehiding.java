public class InstanceVariablehiding {
    // Instance variable or member variable
    private int value = 10;

    // Method
    void method() {

        // This local variable hides instance variable
        int value = 40;

        // Note: this keyword refers to the current instance

        // Printing the value of instance variable
        System.out.println("Value of Instance variable : "
                + this.value);

        // Printing the value of local variable
        System.out.println("Value of Local variable : "
                + value);
    }
}

class GFG76 {

    // Main driver method
    public static void main(String args[]) {

        // Creating object of current instance
        // inside main() method
        InstanceVariablehiding obj1 = new InstanceVariablehiding();

        // Callling method of above class
        obj1.method();
    }
}