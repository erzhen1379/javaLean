package leaning.structure.leetCode;


import java.util.ArrayDeque;
import java.util.Deque;


public class Demo20 {
    public static void main(String[] args) {
        System.out.println(isVaild("{[(])}"));
    }

    public static boolean isVaild(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '(' && c != ')') {
                        return false;
                    } else if (stack.peek() == '[' && c != ']') {
                        return false;
                    } else if (stack.peek() == '{' && c != '}') {
                        return false;
                    }
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }
}
