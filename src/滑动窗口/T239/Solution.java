package 滑动窗口.T239;

public class Solution {
    // 滑动窗口
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int x = 0;

        int left = 0, right = 0;
        int maxVal = nums[0];
        int index = 0;

        while (right < n) {
            int c = nums[right];
            // 更新系数
            if (c > maxVal) {
                maxVal = c;
                index = right;
            }
            right++;

            while (right - left >= k) {
                ans[x++] = maxVal;

                int d = nums[left];
                // 更新系数
                if (index <= left) {
                    maxVal = -10001;
                    for (int i = left + 1; i <= (right >= n ? n - 1 : right); i++) {
                        if (nums[i] > maxVal) {
                            maxVal = nums[i];
                            index = i;
                        }
                    }
                }
                left++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] nums2 = {1, -1, -2};
        int k2 = 1;

        int[] nums3 = {9, 10, 9, -7, -4, -8, 2, -6};
        int k3 = 5;

        Solution solut = new Solution();
        int[] ans = solut.maxSlidingWindow(nums, k);
        for (int a : ans) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
}
