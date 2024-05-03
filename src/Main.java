import java.util.*;


public class Main {
    static Stack<Integer> st = new Stack<Integer>();

    public static void main(String[] args) {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        System.out.println(st);
        reverse();
        System.out.println(st);
    }


    private static void reverse () {
        if (st.size() > 0) {
            int x = st.pop();
            reverse();
            insertAtEnd(x);
        }
    }

    private static void insertAtEnd(int x) {

        if(st.isEmpty()) {
            st.push(x);
        } else {
            int a = st.pop();
            insertAtEnd(x);
            st.push(a);
        }
    }



}
