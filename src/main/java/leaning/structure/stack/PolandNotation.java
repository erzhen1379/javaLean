package leaning.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //1先定义一个逆波兰表达式
        //(30+4)x5-6 =>3 4 + 5 x 6 -
        //4 * 5 -8 + 60 + 8/2=>4 5 * 8 - 60 + 8 2 / +
        //为了说明方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1.先将3 4 + 5 * 6 -放到Arralist中
        //2将ArrayList传递给一个方法，遍历ArrayList配合栈完成
        List<String> rpnListString = getListString(suffixExpression);
        System.out.println(rpnListString);
        int res=calculate(rpnListString);
        System.out.println("计算的结果是="+res);

    }

    /**
     * 将一个逆波兰表达式，依次将数据和运算符放到ArrayList
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
            System.out.println(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     * 1)从左至右扫描，将3和4压入堆栈；
     * 2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3)将5入栈；
     * 4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5)将6入栈；
     * 6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     *
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls) {
        //1创建一个栈，只需要一个栈
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式来取数
            if (item.matches("\\d+")) { //匹配的是多位数
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                //pop出两个数，并运算，在入栈
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }

        }
        return Integer.parseInt(stack.pop());
    }

}
