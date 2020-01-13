package com.gdufe.extend;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 11:53
 * @version V1.0
 */
public class RemoveOuterParentheses {

    public static String removeOuterParentheses(String S) {

        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        String outerStr = "";
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(') {
                stack.push("(");
                temp += "(";
            } else {
                temp += ")";
                String pop = stack.pop();
                if(stack.isEmpty()) {
                    // 这是一个原语
                    list.add(temp);
                    temp = "";
                }
            }
        }
        for(int i=0; i<list.size(); i++) {
            String str = list.get(i);
            outerStr += str.substring(1, str.length()-1);
        }
        return outerStr;
    }

    public static void main(String[] args) {
        String s = removeOuterParentheses("()()");
        System.out.println(s);

    }
}
