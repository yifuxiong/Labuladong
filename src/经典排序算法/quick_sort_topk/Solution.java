package 经典排序算法.quick_sort_topk;

import java.util.Arrays;
import java.util.Random;

// LeetCode T215
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/-by-wu-di-gua-ke-nan-f35v/

public class Solution {
    Random rand = new Random();

    /*********************************/
    /***********  普通快排  ***********/
    /*********************************/
    // 返回单次partition确定pivot元素固定到的位置
    public int partition(int[] nums, int from, int to) {

        // 从from到to之间选一个
        int pivotIdx = rand.nextInt(to - from + 1) + from;
        int pivot = nums[pivotIdx];

        // 随机pivot交换到头部
        int temp = nums[from];
        nums[from] = pivot;
        pivot = temp;

        int left = from, right = to;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        return left;
    }

    public int findTopK(int[] nums, int k) {
        int n = nums.length;
        // 第k大元素，即排序后下标为n-k的元素（因为是从小到大排）
        int target = n - k;

        int from = 0, to = n - 1;
        while (true) {
            int idx = partition(nums, from, to);
            if (idx == target) {
                return nums[target];
            } else if (idx > target) {
                to = idx - 1;
            } else {
                from = idx + 1;
            }
        }
    }


    /*********************************/
    /***********  荷兰国旗  ***********/
    /*********************************/
    public int[] partitionBatch(int[] nums, int from, int to) {
        int pivotIdx = rand.nextInt(to - from + 1) + from;
        int pivot = nums[pivotIdx];

        int less = from - 1, more = to + 1;
        int p = from;
        while (p < more) {
            if (nums[p] < pivot) {
                less += 1;
                swap(nums, p, less);
                p++;
            } else if (nums[p] > pivot) {
                more -= 1;
                swap(nums, p, more);
            } else {
                ++p;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public int findTopKBatch(int[] nums, int k) {
        int n = nums.length;
        // 第k大元素，即排序后下标为n-k的元素（因为是从小到大排）
        int target = n - k;

        int from = 0, to = n - 1;
        while (true) {
            int[] idx = partitionBatch(nums, from, to);
            if (idx[0] <= target && target <= idx[1]) {
                return nums[target];
            } else if (idx[0] > target) {
                to = idx[0] - 1;
            } else {
                from = idx[0] + 1;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9, 8, 3, 4, 4, 8, 8};
        int k = 4;

        Solution solut = new Solution();
        System.out.println(solut.findTopK(nums, k));
        System.out.println(solut.findTopKBatch(nums, k));
    }
}
