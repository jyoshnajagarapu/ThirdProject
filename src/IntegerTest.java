import java.lang.Integer;

class StudyTonight
{
    public static void main(String[] args)
    {
        int n1 = 100;
        int n2 = -200;
        int n3 = 300;
        int n4 = 100;

        System.out.println(Integer.compareUnsigned(n1, n2));  //Output will be less than zero

        System.out.println(Integer.compareUnsigned(n3, n1)); // Output will be greater than zero

        System.out.println(Integer.compareUnsigned(n1,n4));  // Output will be equal to zero

        int []n = {-100,-200,300,100};

        for(int i=0;i<4;i++)

        {
            System.out.println(Integer.compareUnsigned(n[0], n[i]));

        }
    }
}  