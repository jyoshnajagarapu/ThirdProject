
 class Test4 {

    // Normal main()
    public static void main(String[] args) {
        System.out.println("Hi Geek (from main)");
        Test4.main("Geek");
    }

    // Overloaded main methods
    public static void main(String arg1) {
        System.out.println("Hi, " + arg1);
        Test4.main("Dear Geek","My Geek");
    }
    public static void main(String arg1, String arg2) {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}

