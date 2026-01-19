package Core_Advance_Java.Day_3.Collection_Framework_Topics;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(3);
        st.push(2);
        st.push(-9);
        System.out.println(st.peek());
        System.out.println(st);
//        System.out.println(st.pee);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
