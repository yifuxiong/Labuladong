package niuke_meituan_2021_10.T1;

import java.util.*;

public class Main {
    Scanner scan = new Scanner(System.in);

    public Main() {
        String row1 = scan.nextLine();
        String[] r1 = row1.split(" ");
        int n = Integer.parseInt(r1[0]);
        int x = Integer.parseInt(r1[1]);
        int y = Integer.parseInt(r1[2]);

        String row2 = scan.nextLine();
        String[] r2 = row2.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(r2[i]);
        }

        Map<Integer, Integer> table = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            table.put(nums[i], table.getOrDefault(nums[i], 0) + 1);
        }

        int ans = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            int bound = entry.getKey();
            count += entry.getValue();
            if (count >= x && count <= y && n - count >= x && n - count <= y) {
                ans = bound;
                break;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Main();
    }
}
