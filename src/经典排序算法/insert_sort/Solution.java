package 经典排序算法.insert_sort;

public class Solution {
    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            int j = i;
            while (j > 0 && cur < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;

            // 打印一遍
            for (int k = 0; k < nums.length; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {31, 17, 13, 26, 4, 13, 45, 12, 25, 12, 13};

        Solution solut = new Solution();
        solut.insertSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
