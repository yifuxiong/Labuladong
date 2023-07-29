package Chapter3.暴力搜索算法.集合划分问题.T698;

// n个数字分配到k个桶中

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 方法一：以数的角度
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] bucket = new int[k];

        // 如果我们提前对 nums 数组排序，把大的数字排在前面，那么大的数字会先被分配到 bucket 中，
        // 对于之后的数字，bucket[i] + nums[index] 会更大，更容易触发剪枝的 if 条件
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backtrack(nums, target, 0, bucket);
    }

    public boolean backtrack(int[] nums, int target, int index, int[] bucket) {
        if (index == nums.length) {
            // 检查所有桶的值是否都为target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (nums[index] + bucket[i] > target) {
                continue;
            }

            bucket[i] += nums[index];
            if (backtrack(nums, target, index + 1, bucket)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        // 将nums[index]装到哪个桶都不行
        return false;
    }

    // 方法二：以桶的角度
    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        // 当前数组是否已经装到别的桶了
        int[] used = new int[nums.length];
        return backtrack2(nums, 0, 0, k, target, used);
    }

    public boolean backtrack2(int[] nums, int index, int bucket, int k, int target, int[] used) {
        if (k == 0) {
            // 桶装完了
            return true;
        }

        if (bucket == target) {
            // 当前桶达到目标值，开始装下一个桶
            return backtrack2(nums, 0, 0, k - 1, target, used);
        }

        for (int i = index; i < nums.length; i++) {
            // 如果当前这个数字已经装到别的桶里去了
            if (used[i] != 0) {
                continue;
            }

            if (nums[i] + bucket > target) {
                continue;
            }

            used[i] = 1;
            bucket += nums[i];
            // 下一个数组 装入 当前桶，所以 i+1, k
            if (backtrack2(nums, i + 1, bucket, k, target, used)) {
                return true;
            }
            bucket -= nums[i];
            used[i] = 0;
        }
        return false;
    }

    // 记录n个数的状态
    private Map<Integer, Boolean> memo;

    // 方法二改进
    public boolean canPartitionKSubsets3(int[] nums, int k) {
        memo = new HashMap<>();
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        // state记录当前所有数的装入状态，位运算
        return backtrack3(nums, 0, 0, k, target, 0);
    }

    public boolean backtrack3(int[] nums, int index, int bucket, int k, int target, int state) {
        if (k == 0) {
            // 所有桶都装完了
            return true;
        }

        if (bucket == target) {
            // 装下一个桶，数组从头开始
            boolean res = backtrack3(nums, 0, 0, k - 1, target, state);
            memo.put(state, res);
            return res;
        }

        for (int i = index; i < nums.length; i++) {
            // 把这个数装进桶之后，状态如何
            int tmp = (state >> i) & 1;
            if (tmp == 1) {
                // 这个数已经装入到别的桶中
                continue;
            }

            if (bucket + nums[i] > target) {
                continue;
            }

            state |= (1 << i);
            bucket += nums[i];
            if (backtrack3(nums, i + 1, bucket, k, target, state)){
                // 下一个数
                return true;
            }
            bucket -= nums[i];
            state ^= (1 << i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        int[] nums2 = {1, 2, 3, 4};
        int k2 = 3;

        Solution solut = new Solution();
        System.out.println(solut.canPartitionKSubsets(nums2, k2));
        System.out.println(solut.canPartitionKSubsets2(nums2, k2));
        System.out.println(solut.canPartitionKSubsets3(nums2, k2));
    }
}
