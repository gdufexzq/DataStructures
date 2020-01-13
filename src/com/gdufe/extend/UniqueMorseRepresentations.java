package com.gdufe.extend;

import java.util.ArrayList;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 17:36
 * @version V1.0
 */
public class UniqueMorseRepresentations {
    static String[] morseArr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public static int uniqueMorseRepresentations(String[] words) {
//        String[] morseArr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            String s = words[i].toLowerCase();
            String temp = "";
            for(int j=0; j<s.length(); j++) {
                String morse = morseArr[s.charAt(j) - 97];
                temp += morse;
            }
            if(!list.contains(temp)) {
                list.add(temp);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(morseArr['a'-97]);
        String[] words = {"gin", "zen", "gig", "msg"};
        int count = uniqueMorseRepresentations(words);
        System.out.println(count);
    }
}
