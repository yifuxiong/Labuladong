package Chapter3.数学运算技巧.T268;

// 方法1：等差数列求和公式。
// 可以这样理解：等差数列中少了一个数，请找出来
// 那就是第0项到到第n+1项的和 - 当前这个nums的总和

// 方法2：利用异或的交换律，遍历每个元素和当前索引进行异或
// 最后值与索引相同会因为异或而变为0，而缺失值没有与自己进行异或，会成为最后结果

public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        // 先和新补的索引异或一下，因为一共有n+1个索引，n个数
        res ^= nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int[] nums2 = {0, 1};

        Solution solut = new Solution();
        System.out.println(solut.missingNumber(nums2));
    }
}
