package huawei_y23_07_10.T2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ipStr = scan.nextLine();
        // 傻逼了，这里不能写"."，表示任意字符，必须要写成"\\."
        String[] str = ipStr.split("\\.");

        if (str.length != 4) {
            System.out.println("NO");
            System.exit(0);
        }

        for (String s : str) {
            // 特殊用例 .1.3.8
            if (s.length() < 1){
                System.out.println("NO");
                System.exit(0);
            }
            // 是否都是数字
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
            // 非负数且小于255，不是0，则不能以0开头
            if (Integer.parseInt(s) > 255 || s.charAt(0) == '0' && s.length() > 1) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }
}