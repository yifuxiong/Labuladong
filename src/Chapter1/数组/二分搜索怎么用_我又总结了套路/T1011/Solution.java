package Chapter1.数组.二分搜索怎么用_我又总结了套路.T1011;

import java.util.Arrays;

// 这题和T875一样的思路，
// 时间和运送重量成反比，构造单调递减函数f(x)
public class Solution {
    /*
     * 1 <= days <= weights.length <= 5 * 104
     * 1 <= weights[i] <= 500
     * */
    public int shipWithinDays(int[] weights, int D) {
        // 左闭右开
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum() + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == D) {
                right = mid;
            } else if (f(weights, mid) > D) {
                // f是个单调函数
                // 这里是往右靠拢
                left = mid + 1;
            } else if (f(weights, mid) < D) {
                right = mid;
            }
        }
        return left;
    }

    /*
     * f(x)是单调递减函数
     * 返回天数
     * */
    public int f(int[] weights, int size) {
        int day = 1;
        int curWeight = 0;
        for (int weight : weights) {
            if (curWeight + weight > size) {
                day++;
                curWeight = 0;
            }
            curWeight += weight;
        }
        return day;
    }

    public static void main(String[] args) {
        /*
         * 1 <= days <= weights.length <= 5 * 104
         * 1 <= weights[i] <= 500
         * */
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;

        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int D2 = 3;

        int[] weights3 = {1, 2, 3, 1, 1};
        int D3 = 4;

        Solution solut = new Solution();
        System.out.println(solut.shipWithinDays(weights3, D3));
    }
}
