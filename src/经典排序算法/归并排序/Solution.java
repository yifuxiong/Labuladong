package 经典排序算法.归并排序;

public class Solution {
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l1 = left;
        int l2 = mid + 1;

        int k = 0;
        while (l1 <= mid && l2 <= right) {
            if (nums[l1] <= nums[l2]) {
                temp[k] = nums[l1];
                l1++;
                k++;
            } else {
                temp[k] = nums[l2];
                l2++;
                k++;
            }
        }

        while (l1 <= mid) {
            temp[k] = nums[l1];
            l1++;
            k++;
        }

        while (l2 <= right) {
            temp[k] = nums[l2];
            l2++;
            k++;
        }

        // 再把temp中的值赋到原本的nums中
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 8, 4, 1, 0, 3, 6, 9};

        Solution solut = new Solution();
        solut.mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
