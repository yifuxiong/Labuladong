package 经典排序算法.归并排序;

public class SolutionII {
    int[] temp = new int[1000];

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
        int lt = left;
        int rt = mid + 1;
        int k = 0;
        while (lt <= mid && rt <= right) {
            if (nums[lt] <= nums[rt]) {
                temp[k] = nums[lt];
                k++;
                lt++;
            } else {
                temp[k] = nums[rt];
                k++;
                rt++;
            }
        }

        while (lt <= mid) {
            temp[k++] = nums[lt++];
        }
        while (rt <= right) {
            temp[k++] = nums[rt++];
        }

        // 赋值到nums
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 8, 4, 1, 0, 3, 6, 9};

        SolutionII solutII = new SolutionII();
        solutII.mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
