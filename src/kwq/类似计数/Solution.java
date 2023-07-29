package kwq.类似计数;

// kwq字节一面

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> hashMap = new HashMap<>();

    public Solution() {
        int[] nums = {1, 2, 3, 4, 5, 6, 3};
        int[] nums2 = {6, 2, 4, 1, 3, 5, 3, 56, 4, 1, 24, 3, 13, 6, 1, 1, 5, 236, 254, 7, 6, 23};

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        double ansi = 0;
        int sum = 0;
        for (int i = minVal; i <= maxVal; i++) {
            if (!hashMap.containsKey(i)) {
                continue;
            }
            if (sum < (double) n / 2 && sum + hashMap.get(i) > (double) n / 2) {
                ans = i;
                break;
            } else if (sum < n / 2 && sum + hashMap.get(i) == n / 2) {
                if (n % 2 == 0) {
                    int ans1 = i;
                    double ans2 = i + 0.000001;
                    for (int k = i + 1; k < maxVal; k++) {
                        if (hashMap.containsKey(k)) {
                            ans2 = k;
                            break;
                        }
                    }
                    ansi = (ans1 + ans2) / 2;
                    break;
                }
            }
            sum += hashMap.get(i);
        }

        if (n % 2 == 0) {
            System.out.println(ansi);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}
