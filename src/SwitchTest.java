// Java program to demonstrate
// nested switch case statement
 class Test90 {
    public static void main(String[] args)
    {
        String Branch = "CSE";
        int year = 2;

        switch (year) {
            case 1:
                System.out.println("elective courses : Advance english, Algebra");
                break;
                //default can be anywhere but it should have break to stop exceution to go to next statement
            default:
                System.out.println("Elective courses : Optimization");
                break;
            //Duplicate case values are not allowed.
//            case 1:
//                System.out.println("elective courses : Advance english, Algebra");
//                break;
            //The value for a case must be a constant or a literal. Variables are not allowed.
//            case year:
////                System.out.println("elective courses : Advance english, Algebra");
////                break;
            case 2:
                switch (Branch) // nested switch
                {
                    case "CSE":
                        //The break statement is optional. If omitted, execution will continue on into the next case.
                    case "CCE":
                        System.out.println("elective courses : Machine Learning, Big Data");
                        break;

                    case "ECE":
                        System.out.println("elective courses : Antenna Engineering");
                        break;

                    default:
                        System.out.println("Elective courses : Optimization");
                }
        }
    }
}
