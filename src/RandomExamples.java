// file name: Main.java
// file name: Main.java
 class Mainty {
    public static void main(String args[]) {
        Integer x = 400, y = 400;
        if (x == y)
            System.out.println("Same");
        else
            System.out.println("Not Same");
    }
}


class Main1r {
    public static void main(String args[]) {
        Integer x = 40, y = 40;
        if (x == y)
            System.out.println("Same");
        else
            System.out.println("Not Same");
    }
}

// file name: Main.java
 class Mainhj {
    public static void main(String args[]) {
        Integer x = new Integer(40), y = new Integer(40);
        if (x == y)
            System.out.println("Same");
        else
            System.out.println("Not Same");
    }
}

class GFGbh
{
    public static void main(String[] args)
    {
        Integer X = new Integer(10);
        Integer Y = 10;

        // Due to auto-boxing, a new Wrapper object
        // is created which is pointed by Y
        System.out.println(X == Y);
    }
}


