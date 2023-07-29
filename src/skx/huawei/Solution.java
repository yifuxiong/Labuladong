package skx.huawei;

public class Solution {
    int ans = 0;

    public int function(int q1, int s1, int q2, int s2, int q3, int s3, int k, int target) {
        int n = q1 + q2 + q3;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < q1) {
                nums[i] = s1;
            } else if (i < q1 + q2) {
                nums[i] = s2;
            } else {
                nums[i] = s3;
            }
        }

        dfs(nums, 0, 0, target, 0, k);
        return ans;
    }

    public void dfs(int[] nums, int index, int cur_val, int target, int bad, int k) {
        if (bad == k) {
            if (cur_val == target) {
                ans++;
            }
            return;
        }

        if (index == nums.length) {
            if (cur_val == target) {
                ans++;
            }
            return;
        }

        dfs(nums, index + 1, cur_val + nums[index], target, bad, k);
        dfs(nums, index + 1, cur_val, target, bad + 1, k);
    }

    public static void main(String[] args) {
        int q1 = 10, s1 = 5;
        int q2 = 5, s2 = 8;
        int q3 = 6, s3 = 10;
        int k = 3;
        int target = 94;

        Solution solut = new Solution();
        System.out.println(solut.function(q1, s1, q2, s2, q3, s3, k, target));
    }
}
