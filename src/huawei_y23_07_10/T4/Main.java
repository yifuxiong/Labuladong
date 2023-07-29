package huawei_y23_07_10.T4;

// 正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等，等价于[\f\n\r\t\v]
// \f -> 匹配一个换页
// \n -> 匹配一个换行符
// \r -> 匹配一个回车符
// \t -> 匹配一个制表符
// \v -> 匹配一个垂直制表符
//
//[\s]表示，只要出现空白就匹配
//[\S]表示，非空白就匹配

import java.util.Arrays;
import java.util.Scanner;

class Data {
    int index;
    String name;
    int score;

    Data() {
    }

    Data(int index, String name, int score) {
        this.index = index;
        this.name = name;
        this.score = score;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int flag = Integer.parseInt(scan.nextLine());

        Data[] lst = new Data[n];
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String[] str = s.split("\\s+");

            Data data = new Data(i, str[0], Integer.parseInt(str[1]));
            lst[i] = data;
        }
        // 0代表逆序，1代表顺序
        if (flag == 0) {
            Arrays.sort(lst, (o1, o2) -> {
                return o2.score - o1.score;
            });
        }else{
            Arrays.sort(lst, (o1, o2) -> {
                return o1.score - o2.score;
            });
        }

        for (int i = 0; i < n; i++){
            System.out.println(lst[i].name + " " + lst[i].score);
        }
    }
}
