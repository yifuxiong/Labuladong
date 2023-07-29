package sensetime;

import java.util.*;
// import java.util.Scanner;

class AcmMode {
    class Point {
        int x, k, index;

        Point(int x, int k, int index) {
            this.x = x;
            this.k = k;
            this.index = index;
        }
    }

    public AcmMode() {
        Scanner cin = new Scanner(System.in);
        int K = cin.nextInt();
        int N = cin.nextInt();
        PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing(x -> x.x));
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                int x = cin.nextInt();
                q.add(new Point(x, i, j));
            }
        }

        int[] inqCount = new int[K];
        Queue<Point> qq = new LinkedList<>();
        //单调队列
        int nonzeroCount = 0;
        int ans = Integer.MAX_VALUE;
        int beg = 0, end = 0;
        boolean startCheck = false;

        //是否开始覆盖
        while (!q.isEmpty()) {
            Point now = q.poll();
            qq.add(now);
            inqCount[now.k]++;
            if (inqCount[now.k] == 1) {
                nonzeroCount++;
                if (nonzeroCount == K) {
                    startCheck = true;
                }
            }

            //弹出无用元素
            while (!qq.isEmpty() && inqCount[qq.peek().k] > 1) {
                inqCount[qq.peek().k]--;
                qq.poll();
            }
            if (startCheck) {
                int minValue = qq.peek().x;
                int nowAns = now.x - minValue;
                if (nowAns < ans) {
                    ans = nowAns;
                    beg = minValue;
                    end = now.x;
                }
            }
        }

        System.out.println(beg + " " + end);
    }

    public static void main(String[] args) {
        new AcmMode();
    }
}
