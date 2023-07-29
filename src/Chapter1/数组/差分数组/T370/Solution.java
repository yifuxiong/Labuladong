package Chapter1.数组.差分数组.T370;

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

    public void increment(int start, int end, int inc) {
        diff[start] += inc;
        if (end + 1 < len) {
            diff[end + 1] -= inc;
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
    public int[] getModifiedArray(int length, int[][] updates) {
        Difference D = new Difference(new int[length]);
        for (int[] update : updates) {
            D.increment(update[0], update[1], update[2]);
        }
        return D.getResult();
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        Solution solut = new Solution();
        int[] res = solut.getModifiedArray(length, updates);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
