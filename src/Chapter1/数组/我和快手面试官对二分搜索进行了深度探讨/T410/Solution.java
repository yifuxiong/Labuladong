package Chapter1.数组.我和快手面试官对二分搜索进行了深度探讨.T410;

import java.util.Arrays;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum() + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // split()函数随着mid增大单调递减
            int n = split(nums, mid);
            if (n == m) {
                right = mid;
            } else if (n < m) {
                // 往左靠
                right = mid;
            } else if (n > m) {
                left = mid + 1;
            }
        }
        return left;
    }

    // 每个子数组之和的最大值为ma，可以分为几组
    public int split(int[] nums, int ma) {
        int group = 1;
        int curSum = 0;
        for (int num : nums) {
            if (curSum + num > ma) {
                group++;
                curSum = 0;
            }
            curSum += num;
        }
        return group;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;

        Solution solut = new Solution();
        System.out.println(solut.splitArray(nums, m));
    }
}
