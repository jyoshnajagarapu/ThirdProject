package InterfacePack;

class B extends Geek
{
    public static void main(String args[])
    {
        B obj = new B();
        System.out.println("public" + obj.d);
        //System.out.println("private" + obj.b);
        System.out.println("default" + obj.a );
        System.out.println("protected" + obj.c );
        obj.display();
        obj.display2();
        //obj.display1();
        obj.display3();

        Geek obj1 = new Geek();
        System.out.println("public" + obj1.d);
        //System.out.println("private" + obj.b);
        System.out.println("default" + obj1.a );
        System.out.println("protected" + obj1.c );
        obj1.display();
        obj1.display2();
        //obj1.display1();
        obj1.display3();
    }

}