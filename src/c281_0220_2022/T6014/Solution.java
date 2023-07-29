package c281_0220_2022.T6014;

import java.util.PriorityQueue;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> c2 - c1);

        int[] cnt = new int[26];
        // 记录字符串中每个字符的个数
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!pq.contains(ch)) {
                pq.offer(ch);
            }
            cnt[ch - 'a']++;
        }

//        for (int i = 0; i < 26; i++) {
//            System.out.println((char) (i + 'a') + ", " + cnt[i]);
//        }

        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            char ch = pq.poll();

            if (cnt[ch - 'a'] > repeatLimit) {
                int n = repeatLimit;
                while (n > 0) {
                    sb.append(ch);
                    cnt[ch - 'a']--;
                    n--;
                }

                if (!pq.isEmpty()) {
                    char nextCh = pq.peek();
                    sb.append(nextCh);
                    cnt[nextCh - 'a']--;

                    if (cnt[nextCh - 'a'] <= 0) {
                        pq.poll();
                    }
                } else {
                    break;
                }

                if (!pq.contains(ch)) {
                    pq.offer(ch);
                }

            } else if (cnt[ch - 'a'] <= repeatLimit && cnt[ch - 'a'] > 0) {
                while (cnt[ch - 'a'] > 0) {
                    sb.append(ch);
                    cnt[ch - 'a']--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;

        String s2 = "aababab";
        int repeatLimit2 = 2;

        String s3 = "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt";
        int repeatLimit3 = 1;

        String s4 = "abcdefgg";
        int repeatLimit4 = 1;

        Solution solut = new Solution();
        System.out.println(solut.repeatLimitedString(s3, repeatLimit3));
    }
}
