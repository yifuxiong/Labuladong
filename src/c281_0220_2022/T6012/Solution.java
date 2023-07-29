package c281_0220_2022.T6012;

public class Solution {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            if (isValid(i)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isValid(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int num = 30;

        Solution solut = new Solution();
        System.out.println(solut.countEven(num));
    }
}
