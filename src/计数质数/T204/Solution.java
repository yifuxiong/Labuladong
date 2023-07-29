package 计数质数.T204;

// 给定整数 n ，返回所有【小于】非负整数 n 的质数的数量 。

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                // 只判断目前仍显示true的数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 开始计数，2到n-1有多少个质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
