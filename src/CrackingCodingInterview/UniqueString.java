package CrackingCodingInterview;

public class UniqueString {
    public static void main(String args[] ){
        String str = "uniquecharacterstring";
        boolean result = uniqueString(str);
       System.out.println(result);
        String str1 = "uniqe";
        boolean result1 = uniqueString(str1);
        System.out.println(result1);
    }

    private static boolean uniqueString(String str) {
        //boolean unique = false;
        int[] array = new int[128];
        for(char a: str.toCharArray()){
            //System.out.println("a" + a);
            int index = a;
            //System.out.println(index);
            if(array[index] != 0) return false;
            else array[index] = 1;
        }
        return true;
    }
}
