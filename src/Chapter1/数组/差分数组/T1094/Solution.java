package Chapter1.数组.差分数组.T1094;

class Difference {
    int[] diff;
    int len;

    public Difference(int[] nums) {
        len = nums.length;
        diff = new int[len];
        diff[0] = nums[0];
        for (int i = 1; i < len; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < len) {
            diff[end + 1] -= val;
        }
    }

    public int[] getResult() {
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Difference D = new Difference(new int[1001]);
        for (int[] trip : trips) {
            // 左闭右开
            D.increment(trip[1], trip[2] - 1, trip[0]);
        }
        int[] res = D.getResult();

        for (int r : res) {
            if (r > capacity) {
                return false;
            }
        }
        return true;
    }
}
