// filename Main.java
class Grandparent {
    public void Print()
    {
        System.out.println("Grandparent's Print()");
    }
}

class Parent1 extends Grandparent {
    public void Print()
    {
        super.Print();
        System.out.println("Parent's Print()");
    }
}

class Child extends Parent1 {
    public void Print()
    {
        // Trying to access Grandparent's Print() will throw error
        // In Java, we can access grandparent’s members only through the parent class.
        //Why doesn’t java allow accessing grandparent’s methods?

        //It violates encapsulation. You shouldn’t be able to bypass the parent class’s behavior. It makes sense to sometimes be able to bypass your own class’s behavior (particularly from within the same method) but not your parent’s.
        //super.super.Print();
        super.Print();
        System.out.println("Child's Print()");
    }
}

 class Main2 {
    public static void main(String[] args)
    {
        Child c = new Child();
        c.Print();
    }
}

class SolarSystem {
}
class Earth extends SolarSystem {
}
class Mars extends SolarSystem {
}
 class Moon extends Earth {
    public static void main(String args[])
    {
        SolarSystem s = new SolarSystem();
        Earth e = new Earth();
        Mars m = new Mars();

        System.out.println(s instanceof SolarSystem);
        System.out.println(e instanceof Earth);
        System.out.println(m instanceof SolarSystem);
    }
}

