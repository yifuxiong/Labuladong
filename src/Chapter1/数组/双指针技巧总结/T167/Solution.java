package Chapter1.数组.双指针技巧总结.T167;

// 两数之和II
// 双指针

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];
        int left = 0, right = n - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;

        int[] numbers3 = {-1, 0};
        int target3 = -1;

        Solution solut = new Solution();
        int[] ans = solut.twoSum(numbers3, target3);
        System.out.println(ans[0] + ", " + ans[1]);
    }
}
