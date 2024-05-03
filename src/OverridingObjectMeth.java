class Complex9 {

    private double re, im;
    int Eid;
    String Ename;

    public Complex9(double re, double im,int Eid, String Ename) {
        this.re = re;
        this.im = im;
        this.Eid = Eid;
        this.Ename = Ename;
    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

		/* Check if o is an instance of Complex or not
		"null instanceof [type]" also returns false */
        if (!(o instanceof Complex9)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Complex9 c = (Complex9) o;

        // Compare the data members and return accordingly
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0 && this.Eid == c.Eid && this.Ename.equals(c.Ename);


    }
    @Override//overriding toString method of object
    public String toString()
    {
        return "toStringMethod";
    }
}

// Driver class to test the Complex class
 class Main6 {

    public static void main(String[] args) {
        Complex9 c1 = new Complex9(10, 15,10, "Geek1");
        Complex9 c2 = new Complex9(10, 15,10, "Geek1");
        if (c1.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }

        //Object.toString this method was getting automatically called when the print statement is written
        //The default toString() method in Object prints “class name @ hash code”
        System.out.println(c1);//prints Complex9@d041cf if not overriden
    }
}
