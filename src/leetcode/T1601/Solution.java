package leetcode.T1601;

/*
* 提示：
    1 <= n <= 20
    1 <= requests.length <= 16
    requests[i].length == 2
    0 <= fromi, toi < n
* */

public class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        return backTrack(requests, 0, delta, 0);
    }

    public boolean isValid(int[] delta) {
        for (int d : delta) {
            if (d != 0) {
                return false;
            }
        }
        return true;
    }

    public int backTrack(int[][] requests, int pos, int[] delta, int cnt) {
        if (pos == requests.length) {
            // 判断所有delta是否为0
            if (isValid(delta)) {
                return cnt;
            } else {
                return 0;
            }
        }
        // 不选
        int r1 = backTrack(requests, pos + 1, delta, cnt);

        // 选
        delta[requests[pos][0]] -= 1;
        delta[requests[pos][1]] += 1;
        int r2 = backTrack(requests, pos + 1, delta, cnt + 1);
        delta[requests[pos][1]] -= 1;
        delta[requests[pos][0]] += 1;
        return Math.max(r1, r2);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] requests = {{0, 0}, {1, 1}, {0, 0}, {2, 0}, {2, 2}, {1, 1}, {2, 1}, {0, 1}, {0, 1}};

        int n2 = 4;
        int[][] requests2 = {{0, 3}, {3, 1}, {1, 2}, {2, 0}};

        Solution solut = new Solution();
        System.out.println(solut.maximumRequests(n, requests));
    }
}
