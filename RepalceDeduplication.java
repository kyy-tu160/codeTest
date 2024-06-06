package com.example.demomongo;


import ch.qos.logback.core.util.StringUtil;

/**
 * * Instead of removing the consecutively identical characters, replace them with a
 * single character that comes before it alphabetically.
 */
public class RepalceDeduplication {

    public String handle(String s) {

        if (StringUtil.isNullOrEmpty(s)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        // 当前的相同数目
        int a = 1;
        // 当前的字符
        char c = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            // 当前字符和前一个字符相同
            if (s.charAt(i) == c) {
                a++;

                if (i == s.length() - 1){
                    while (a > 0) {
                        sb.append(c);
                        a--;
                    }
                }
            } else {
                while (a > 0) {
                    if (a==3){
                        if (i!=3){
                            sb.append(s.charAt(i-4));
                        }
                        break;
                    }
                    sb.append(c);
                    a--;
                }
                //保存一下本次的。
                a = 1;
                c = s.charAt(i);
                if (i == s.length() - 1){
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
        return sb.toString();

    }

    public  void hasThreeConsecutiveDuplicates(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                String res = this.handle(str);
                hasThreeConsecutiveDuplicates(res);
            }
        }
    }


    public static void main(String[] args) {
        //
        String s = "abcccbad";
        System.out.println(s);
        new RepalceDeduplication().hasThreeConsecutiveDuplicates(s);
    }

}