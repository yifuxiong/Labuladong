package niuke_meituan_2021_10.T2;

import java.util.*;

public class Main {
    Scanner scan = new Scanner(System.in);

    public Main() {
        String row1 = scan.nextLine();
        int n = Integer.parseInt(row1);
        String row2 = scan.nextLine();
        String[] r2 = row2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(r2[i]);
        }

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++){
            int diff = Math.abs(nums[i] - (i + 1));
            count += diff;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        new Main();
    }
}
