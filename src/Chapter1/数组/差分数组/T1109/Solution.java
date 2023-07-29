package Chapter1.数组.差分数组.T1109;

class Difference {
    int[] Diff;
    int len;

    public Difference(int length) {
        len = length;
        Diff = new int[len];
    }

    public void increment(int start, int end, int val) {
        Diff[start] += val;
        if (end + 1 < len) {
            Diff[end + 1] -= val;
        }
    }

    public int[] getResult() {
        int[] res = new int[len];
        res[0] = Diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + Diff[i];
        }
        return res;
    }
}

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference D = new Difference(n);
        for (int[] booking : bookings) {
            D.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return D.getResult();
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;

        Solution solut = new Solution();
        int[] res = solut.corpFlightBookings(bookings, n);
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
