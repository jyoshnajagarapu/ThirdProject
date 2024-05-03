class Hellow {
    public static void main(String[] args)
    {
        String s = new String("RR");
        s = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    protected void finalize()
    {
        System.out.println("finalize method overriden");
    }
}
//Note : Here above output came only Main Completes and not “finalize method overriden” because Garbage Collector call finalize method on that class object which is eligible for Garbage collection. Here above we have done->
//s = null and ‘s’ is the object of String class, so String class finalize method is going to be called and not our class(i.e, Hello class). So we modify our code like->
//
//Hello s = new Hello();
//s = null;

class Hellowe {
    public static void main(String[] args)
    {
        Hellowe s = new Hellowe();
        s = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
        System.out.println("Main Completes");
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    protected void finalize()
    {
        System.out.println("finalize method overriden");
    }
}
//So basically, Garbage Collector calls finalize method on that class object which is eligible for Garbage collection.So if String object is eligible for Garbage Collection then String class finalize method is going to be called and not the Hello class finalize method.
class Bye {
    public static void main(String[] args)
    {
        Bye m = new Bye();

        // Calling finalize method Explicitly.
        m.finalize();//call by programmer but object won't gets destroyed.
        m.finalize();//call by programmer but object won't gets destroyed.
        m = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize()
    {
        System.out.println("finalize method overriden");
    }
}

//If programmer calls finalize method, while executing finalize method some unchecked exception rises.
//JVM does not ignore all exceptions while executing finalize method, but it ignores only Unchecked exceptions. If the corresponding catch block is there then JVM won’t ignore and corresponding catch block will be executed.
//System.gc() is just a request to JVM to execute the Garbage Collector. It’s up-to JVM to call Garbage Collector or not.Usually JVM calls Garbage Collector when there is not enough space available in the Heap area or when the memory is low
class Hi {
    public static void main(String[] args)
    {
        Hi j = new Hi();

        // Calling finalize method Explicitly.
        j.finalize();//comment this and check output

        j = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize()
    {
        System.out.println("finalize method overriden");
        System.out.println(10 / 0);
    }
}

