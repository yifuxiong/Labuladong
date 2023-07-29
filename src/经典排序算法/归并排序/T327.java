package 经典排序算法.归并排序;

// leetcode 327
// 归并排序的一个应用
public class T327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += nums[i - 1];
            preSum[i] = s;
        }
        return countRangeSumRecursive(preSum, lower, upper, 0, n);
    }

    public int countRangeSumRecursive(long[] preSum, int lower, int upper, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int n1 = countRangeSumRecursive(preSum, lower, upper, left, mid);
        int n2 = countRangeSumRecursive(preSum, lower, upper, mid + 1, right);
        int ret = n1 + n2;

        // 计算区间个数
        int l1 = mid + 1;
        int l2 = mid + 1;
        int i = left;
        while (i <= mid) {
            while (l1 <= right && preSum[l1] - preSum[i] < lower) {
                l1++;
            }
            while (l2 <= right && preSum[l2] - preSum[i] <= upper) {
                l2++;
            }
            ret += (l2 - l1);
            i++;
        }

        merge(preSum, left, mid, right);
        return ret;
    }

    public void merge(long[] preSum, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int l1 = left;
        int l2 = mid + 1;
        int k = 0;

        while (l1 <= mid && l2 <= right) {
            if (preSum[l1] <= preSum[l2]) {
                temp[k] = preSum[l1];
                k++;
                l1++;
            } else {
                temp[k] = preSum[l2];
                k++;
                l2++;
            }
        }

        while (l1 <= mid) {
            temp[k] = preSum[l1];
            k++;
            l1++;
        }

        while (l2 <= right) {
            temp[k] = preSum[l2];
            k++;
            l2++;
        }

        // 再把temp中的值赋到原本的preSum中
        for (int i = left; i <= right; i++) {
            preSum[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;

        T327 t = new T327();
        System.out.println(t.countRangeSum(nums, lower, upper));
    }
}
