package Chapter3.数学运算技巧.讲两道常考的阶乘算法题.T793;

// 0 <= k <= 10^9
public class Solution {
    public int preimageSizeFZF(int k) {
        // 就这个特殊测试用例
        if (k == 0){
            return 5;
        }
        long left = getLeft(k);
        long right = getRight(k);
        return (int) (right - left + 1);
    }

    public int getK(long n) {
        int res = 0;
        for (long d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }

    public long getLeft(long target) {
        long left = 0;
        // 主要难点是怎么确定上界
        long right = 10 * target + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (getK(mid) >= target) {
                // 单调递增，找左边界
                right = mid;
            } else if (getK(mid) < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public long getRight(long target) {
        long left = 0;
        // 主要难点是怎么确定上界
        long right = 10 * target + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (getK(mid) <= target) {
                // 单调递增，找右边界
                left = mid + 1;
            } else if (getK(mid) > target) {
                right = mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int k = 5;

        Solution solut = new Solution();
        System.out.println(solut.preimageSizeFZF(k));
    }
}
