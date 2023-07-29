package niuke_meituan_2021_10.T3;

import java.util.*;

// 堆，优先队列
// 超时？
public class Main {
    Scanner scan = new Scanner(System.in);

    public Main() {
        int T = Integer.parseInt(scan.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scan.nextLine());
            String row1 = scan.nextLine();

            int M = Integer.parseInt(scan.nextLine());
            String row2 = scan.nextLine();

            PriorityQueue<Integer> queue0 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
//            PriorityQueue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1 - o2;
//                }
//            });

            for (int i = N - 1; i >= 0; i--) {
                char table = row1.charAt(i);
                if (table == '0') {
                    queue0.offer(i + 1);
                } else if (table == '1') {
                    queue1.offer(i + 1);
                } else if (table == '2') {
                    // queue2.offer(i + 1);
                }
            }

            int[] ans = new int[M];
            int k = 0;
            for (int j = 0; j < M; j++) {
                char person = row2.charAt(j);
                if (person == 'M') {
                    if (!queue1.isEmpty()) {
                        int index = queue1.poll();
                        ans[k++] = index;
                        // queue2.offer(index);
                    } else if (!queue0.isEmpty()) {
                        int index = queue0.poll();
                        ans[k++] = index;
                        queue1.offer(index);
                    }
                } else {
                    if (!queue0.isEmpty()) {
                        int index = queue0.poll();
                        ans[k++] = index;
                        queue1.offer(index);
                    } else if (!queue1.isEmpty()) {
                        int index = queue1.poll();
                        ans[k++] = index;
                        // queue2.offer(index);
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                System.out.println(ans[i]);
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
