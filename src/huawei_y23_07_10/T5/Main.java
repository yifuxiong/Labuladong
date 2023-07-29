package huawei_y23_07_10.T5;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    private static String[] one2nine = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] ten2nineteen = {"ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] zero2ninety = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static int[] tableNum = {(int) 1e2, (int) 1e3, (int) 1e6, (int) 1e9, (int) 1e12};
    private static String[] tableStr = {"hundred", "thousand", "million", "billion"};

    public static String num2english(long num) {
        if (num < 10) {  // 10以内的英文是固定搭配
            return one2nine[(int)num];
        } else if (num < 20) {  // 20以内的英文是固定搭配
            return ten2nineteen[(int)(num % 10)];
        } else if (num < 100) {  // 100以内整十是固定搭配
            return zero2ninety[(int)(num / 10)] + (num % 10 == 0 ? "" : " " + one2nine[(int)(num % 10)]);
        }

        for (int i = 0; i < tableNum.length; i++) {
            if (num < tableNum[i + 1]) {  // 从100开始，每3位
                return num2english(num / tableNum[i]) + " " + tableStr[i] + (num % tableNum[i] == 0 ? "" : (i != 0 ? " " : " and ") + num2english(num % tableNum[i]));
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = Long.parseLong(scan.nextLine());

        String res = num2english(num);
        System.out.println(res);
    }
}