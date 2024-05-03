//In Java, we can also add variables, methods and constructors to it.
//Enum declaration can be done outside a Class or inside a Class but not inside a Method.
//The main objective of enum is to define our own data types(Enumerated Data Types).
//Every enum constant represents an object of type enum.
//enum type can be passed as an argument to switch statement.
//We can declare the main() method inside the enum. Hence we can invoke enum directly from the Command Prompt.
//All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot extend anything else.
//toString() method is overridden in java.lang.Enum class, which returns enum constant name.
//enum can implement many interfaces.
//values() method can be used to return all values present inside enum.
//Order is important in enums.By using ordinal() method, each enum constant index can be found, just like array index.
//valueOf() method returns the enum constant of the specified string value, if exists.
//enum can contain a constructor and it is executed separately for each enum constant at the time of enum class loading.
//We can’t create enum objects explicitly and hence we can’t invoke enum constructor directly.
//enum can contain both concrete methods and abstract methods. If an enum class has an abstract method, then each instance of the enum class must implement it
enum Color
{
    RED, GREEN, BLUE;
    // Driver method
    public static void main(String[] args)
    {
        Color c3 = Color.BLUE;
        System.out.println();
    }
    // enum constructor called separately for each
    // constant
    private Color() //Modifier 'public' not allowed here
    {
        System.out.println("Constructor called for : " +
                this.toString());
    }

    public void colorInfo()
    {
        System.out.println("Universal Color");
    }

}

/* internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/
 class Test9
{
    enum Color1
    {
        RED, GREEN, BLUE;
    }
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
        Color1 c2 = Color1.GREEN;
        System.out.println(c2);
    }
}



// An Enum class
enum Day
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY,;
}

// Driver class that contains an object of "day" and
// main().
 class Testenum8
{
    Day day;

    // Constructor
    public Testenum8(Day day)
    {
        this.day = day;
    }

    // Prints a line about Day using switch , all access specifiers allowed
    public void dayIsLike()
    {
        switch (day)
        {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        String str = "MONDAY";
        Testenum8 t1 = new Testenum8(Day.valueOf(str));
        Testenum8 t2 = new Testenum8(Day.SATURDAY);
        t1.dayIsLike();
        t2.dayIsLike();

        Day arr[] = Day.values();

        // enum with loop
        for (Day col : arr)
        {
            // Calling ordinal() to find index
            // of color.
            System.out.println(col + " at index "
                    + col.ordinal());
        }
    }
}

 enum Country {

    US {

        public String getCurrency(int a) {
            return "DOLLAR";
        }
    }, RUSSIA {

        public String getCurrency(int a) {
            return "RUBLE";
        }
    }, INDIA {

        public String getCurrency(int a) {
            return "RUPEE";
        }
    };

    public abstract String getCurrency(int a);
}

 class ListCurrency {
    public static void main(String[] args) {
        for (Country country : Country.values()) {
            System.out.println(country.getCurrency(1) + " is the currecny of " + country.name());
        }
    }
}



enum TrafficSignal
{
    // This will call enum constructor with one
    // String argument
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");

    // declaring private variable for getting values, public,protected, default access specifier is allowed
     private String action;

    // getter method
    public String getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected, if commented will throw Expected 0 arguments but found 1
    private TrafficSignal(String action)
    {
        this.action = action;
    }
}

// Driver code
 class EnumConstructorExample
{
    public static void main(String args[])
    {
        // let's print name of each enum and there action
        // - Enum values() examples
        TrafficSignal[] signals = TrafficSignal.values();

        for (TrafficSignal signal : signals)
        {
            // use getter method to get the value
            System.out.println("name : " + signal.name() +
                    " action: " + signal.getAction() );
        }
    }
}

