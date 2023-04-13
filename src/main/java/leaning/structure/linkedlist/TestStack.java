package leaning.structure.linkedlist;

import java.util.Stack;

/**
 * 测试栈
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> str = new Stack<String>();
        str.push("zhangsan");
        str.push("lisi");
        str.push("wangwu");
        while (str.size()>0){
            System.out.println(str.pop());
        }

    }
}
