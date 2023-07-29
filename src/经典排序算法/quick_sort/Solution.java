package 经典排序算法.quick_sort;

import java.util.Random;

public class Solution {
    Random rand = new Random();

    // 优化后的快速排序
    public int parti(int[] nums, int low, int high) {
        int pivotIdx = rand.nextInt(high - low + 1) + low;
        int pivot = nums[pivotIdx];

        // 将pivot交换到头部
        int temp = nums[low];
        nums[low] = pivot;
        pivot = temp;

        int left = low, right = high;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 一般的快速排序
    public int partition(int[] nums, int low, int high) {
        int memo = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= memo) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= memo) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = memo;
        return low;
    }

    public int topK(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;

        int left = 0, right = n - 1;
        while (true) {
            int idx = parti(nums, left, right);
            if (idx == target) {
                return nums[idx];
            } else if (idx < target) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9, 8, 3, 4, 4, 8, 8};
        int k = 4;

        Solution solut = new Solution();
        System.out.println(solut.topK(nums, k));
    }
}
