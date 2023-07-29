package fwf.九的倍数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MOD = 1000000007;
        while (scanner.hasNext()) {
            char[] nums = scanner.nextLine().toCharArray();
//            int[] count = new int[10];
            int ans = 0;
//            for (char num : nums) {
//                count[num - '0']++;
//            }
            int[][] dp = new int[nums.length][9];
            dp[0][(nums[0] - '0') % 9]++;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j] = (dp[i - 1][(j + 9 - (nums[i] - '0')) % 9] + dp[i - 1][j]) % MOD;
                }
                dp[i][(nums[i] - '0') % 9]++;
//                dp[i][0]=(dp[i][0]+dp[i-1][0])%MOD;
//                if ((nums[0]-'0')%9==0) {
//                    dp[i][0]=(dp[i][0]+1)%MOD;
//                }
            }
            System.out.println(dp[nums.length - 1][0]);
        }
    }
}
