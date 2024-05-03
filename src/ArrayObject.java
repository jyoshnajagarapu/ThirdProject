
class ArrayObject
{
    public int roll_no;
    public String name;
    ArrayObject(int roll_no, String name)
    {
        this.roll_no = roll_no;
        this.name = name;
    }
}

// Elements of the array are objects of a class ArrayObject.
 class GFG45
{
    public static void main (String[] args)
    {
        // declares an Array of integers.
        ArrayObject[] arr;

        // allocating memory for 5 objects of type ArrayObject.
        arr = new ArrayObject[5];

        // initialize the first elements of the array
        arr[0] = new ArrayObject(1,"aman");

        // initialize the second elements of the array
        arr[1] = new ArrayObject(2,"vaibhav");

        // so on...
        arr[2] = new ArrayObject(3,"shikar");
        arr[3] = new ArrayObject(4,"dharmesh");
        arr[4] = new ArrayObject(5,"mohit");

        // accessing the elements of the specified array
        for (int i = 0; i < arr.length; i++)
            System.out.println("Element at " + i + " : " +
                    arr[i].roll_no +" "+ arr[i].name);
    }
}
