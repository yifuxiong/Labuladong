package fwf.baidu2;

// 4堆金币，往左往右不动
// 从源点开始最后到源点，能够吃最多的金币
// 1, 2, 3, 1

public class Solution {
    int[] dirs = {-1, 0, 1};
    int ans = 0;

    // 吃金币
    public int function(int[] nums, int k) {
        dfs(nums, k, 0, k);
        return ans;
    }

    public void dfs(int[] nums, int pos, int golds, int k) {
        int n = nums.length;
        if (pos < 0 || pos >= n) {
            return;
        }

        if (nums[pos] == 0) {
            // 没有金币了
            if (pos == k){
                // 判断是否回到原位
                ans = Math.max(ans, golds);
            }
            return;
        }

        golds += 1;
        nums[pos] -= 1;
        for (int dir : dirs) {
            int nextPos = pos + dir;
            dfs(nums, nextPos, golds, k);
        }
        nums[pos] += 1;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 2;  // 索引2的位置上

        int[] nums2 = {0, 1, 4, 1, 2};
        int k2 = 2;

        Solution solut = new Solution();
        System.out.println(solut.function(nums, k));
    }
}
