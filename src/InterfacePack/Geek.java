package InterfacePack;
//access specifier test
public class Geek
{
    int a =1 ;
    private int b  = 2;
    protected int c = 3;
    public int d = 4;

    void display()
    {
        System.out.println("default");
    }

    private void display1()
    {
        System.out.println(" private GeeksforGeeks");
    }

    protected void display2()
    {
        System.out.println(" protected GeeksforGeeks");
    }

    public void display3()
    {
        System.out.println(" public GeeksforGeeks");
    }
}