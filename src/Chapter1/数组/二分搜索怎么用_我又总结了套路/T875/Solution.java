package Chapter1.数组.二分搜索怎么用_我又总结了套路.T875;

// 二分查找，自定义f(x)

public class Solution {
    /*
     * 1 <= piles.length <= 10^4
     * piles.length <= H <= 10^9
     * 1 <= piles[i] <= 10^9
     *
     * 根据下面的f函数定义，吃香蕉的时间限制h自然就是target
     * target是对f(x)返回值的最大约束
     * */
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        // 这题是要返回左边界，我们设定为左闭右开
        int left = 1, right = 1000000001;
        // left这里是最小速度，为1
        // right是最大速度，10^9+1

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                right = mid;
            } else if (f(piles, mid) > h) {
                // 注意：f(x)是单减函数
                // 所有这里往右靠拢
                left = mid + 1;
            } else if (f(piles, mid) < h) {
                right = mid;
            }
        }
        return left;
    }

    /*
     * 定义：速度为x时，需要f(x)小时吃完所有香蕉
     * f(x)随着x的增加单调递减
     *
     * 因此，定义吃香蕉的速度为x根/小时，则需要f(x)小时吃完所有香蕉
     * */
    public int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {
        /*
         * 1 <= piles.length <= 10^4
         * piles.length <= H <= 10^9
         * 1 <= piles[i] <= 10^9
         * */
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;

        Solution solut = new Solution();
        System.out.println(solut.minEatingSpeed(piles3, h3));
    }
}
