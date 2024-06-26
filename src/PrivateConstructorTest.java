 class restrictInstanceCreationClass {
    public static void main(String[] args) {

        RestrictInstance obj;

        int a=1;

        while(a<=20)

        {

            obj = RestrictInstance.getLimInstance();

            a++;

        }

    }

}

class RestrictInstance {

    public static int varCount = 0;

    /**

     *create private constructor that increases the count

     *of varCount variable after each instance creation

     */

    private RestrictInstance() {

        varCount++;

        System.out.println("Instance number "+ varCount + "is created.");

    }



    public static RestrictInstance getLimInstance() {

        if(varCount <5) {

            return new RestrictInstance();

        }

        System.out.println("Maximum instance limit reached. You are not allowed to create anymore instances.");

        System.gc();

        return null;

    }

    /**

     *delete the instance and decrease the count

     *of the varCount variable

     */

    protected void finalize()

    {

        System.out.println("Instance is deleted.");

        varCount--;

    }
}

