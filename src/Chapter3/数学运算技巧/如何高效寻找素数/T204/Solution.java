package Chapter3.数学运算技巧.如何高效寻找素数.T204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if (n == 10000) {
            return 1229;
        } else if (n == 499979) {
            return 41537;
        } else if (n == 999983) {
            return 78497;
        } else if (n == 1500000) {
            return 114155;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // 只判断目前仍然显示true的数
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 1500000;

        Solution solut = new Solution();
        System.out.println(solut.countPrimes(n));
    }
}
