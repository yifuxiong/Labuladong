package c72_0219_2022.T5996;

// 第1题
// 统计数组中相等且可以被整除的数对

public class Solution {
    public int countPairs(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        int ans = 0;
        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int k = 2;

        Solution solut = new Solution();
        System.out.println(solut.countPairs(nums, k));
    }
}
