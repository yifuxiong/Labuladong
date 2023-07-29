package Chapter3.数学运算技巧.如何在无限序列中抽取元素.T382;

// 蓄水池抽样法（随机抽一次）

import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    Random r;
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
        r = new Random();
    }

    public int getRandom(ListNode head) {
        int i = 0;
        ListNode p = head;
        int res = head.val;

        while (p != null) {
            i++;
            if (r.nextInt(i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);

        Solution solut = new Solution(head);
        System.out.println(solut.r.nextInt(2));
    }
}
