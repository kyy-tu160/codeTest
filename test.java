package com.example.wx1.controller;

public class test {
    public static String handle(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        // 当前的相同数目
        int a = 1;
        // 当前的字符
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                a++;

            } else {
                if (a >= 3) {
                    String str = s.substring(i - a, i);
                    String res = s.replace(str, "");
                    System.out.println(res);
                    return handle(res);
                }

                a=1;
            }
        }
        return s;

    }

    public static String changeWord(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        // 当前的相同数目
        int a = 1;
        // 当前的字符
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                a++;

            } else {
                if (a >= 3) {
                    String str = s.substring(i - a, i);
                    int index = i - a - 1;
                    if (index<0){
                        String res = s.replace(str, "");
                        System.out.println(res);
                        return res;
                    }

                    char repchar = s.charAt(index);
                    String res = s.replace(str, Character.toString(repchar));
                    System.out.println(res+", ccc is replaced by "+ repchar);
                    return changeWord(res);
                }

                a=1;
            }
        }
        return s;

    }

    public static void main(String[] args) {
        String s = "aabcccbbad";
        changeWord(s);
        handle(s);
    }
}
