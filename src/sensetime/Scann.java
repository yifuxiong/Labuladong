package sensetime;

import java.util.Scanner;

public class Scann {
    public void funNext() {
        // 使用 next 方法
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            String str = scan.next();
            System.out.println("输入数据为：" + str);
        }
        scan.close();
    }

    public void funNextLine(){
        // 使用 nextLine 方法
        Scanner scanner = new Scanner(System.in);

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        if (scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println("输入数据为：" + str);
        }
        scanner.close();
    }

    // 如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，
    // 但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取
    public void funHasNextInt(){
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()){
            int ans = scanner.nextInt();
            System.out.println("输入数字为：" + ans);
        }
        if (scanner.hasNextFloat()){
            float f = scanner.nextFloat();
            System.out.println("输入小数为：" + f);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scann scn = new Scann();
        // scn.funNext();  // 字符串中间不能有空格
        // scn.funNextLine();  // 输入可以有空格
        scn.funHasNextInt();
    }
}
