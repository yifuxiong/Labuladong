package wp_tengxun_22_10_16.T1;

import java.util.*;
public class Main {
    Scanner scan = new Scanner(System.in);
    public Main() {
        int T = Integer.parseInt(scan.nextLine());
        for (int t = 0; t < T; t++) {
            String row = scan.nextLine();
            String[] s = row.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int ans = 1;
            for (int i = 0; i <= k; i++){
                int l1 = x + i;
                int r1 = y + (k - i);
                int l2 = x + (k - i);
                int r2 = y + i;

                int res1 = func(l1, r1);
                int res2 = func(l2, r2);
                ans = Math.max(ans, res1);
                ans = Math.max(ans, res2);
            }
            System.out.println(ans);
        }
    }
    public int func(int x, int y) {
        int ans = 1;
        while (x != 0 && y != 0){
            ans = x % y;
            x = y;
            y = ans;
        }
        return x;
    }
    public static void main(String[] args) {
        new Main();
    }
}