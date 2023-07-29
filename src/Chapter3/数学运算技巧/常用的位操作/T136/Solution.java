package Chapter3.数学运算技巧.T136;

// 一个数和它本身作异或运算为0，和0作异或运算等于它本身，即
// a ^ a == 0;    a ^ 0 == a

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num: nums){
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        Solution solut = new Solution();
        System.out.println(solut.singleNumber(nums));
    }
}
