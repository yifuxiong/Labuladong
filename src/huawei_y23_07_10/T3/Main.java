package huawei_y23_07_10.T3;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();

        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < s1.length(); i++){
            if (Character.isDigit(s1.charAt(i))){
                int n = ((int)(s1.charAt(i) - '0') + 1) % 10;
                sb1.append(n);
            }else{
                char c = s1.charAt(i);
                if (c >= 'A' && c <= 'Z'){
                    if (c == 'Z'){
                        c = 'a';
                    }else{
                        c = (char)(c + 33);
                    }
                }else{
                    if (c == 'z'){
                        c = 'A';
                    }else{
                        c = (char)(c - 31);
                    }
                }
                sb1.append(c);
            }
        }
        String s1t = sb1.toString();
        System.out.println(s1t);

        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < s2.length(); i++){
            if (Character.isDigit(s2.charAt(i))){
                int n = ((int)(s2.charAt(i) - '0') + 9) % 10;
                sb2.append(n);
            }else{
                char c = s2.charAt(i);
                if (c >= 'A' && c <= 'Z'){
                    if (c == 'A'){
                        c = 'z';
                    }else{
                        c = (char)(c + 31);
                    }
                }else{
                    if (c == 'a'){
                        c = 'Z';
                    }else{
                        c = (char)(c - 33);
                    }
                }
                sb2.append(c);
            }
        }
        String s2t = sb2.toString();
        System.out.println(s2t);
    }
}
