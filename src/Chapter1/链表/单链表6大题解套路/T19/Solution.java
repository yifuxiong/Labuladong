// 单链表的倒数第 k 个节点
// 解决办法：两个指针

package Chapter1.链表.单链表6大题解套路.T19;

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
    public ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        while (n != 0) {
            p1 = p1.next;
            n--;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这里生成一个虚拟节点，连接在head之前
        // 防止把头结点删除了
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p2 = findFromEnd(dummy, n + 1);
        // 删除p2后面的节点
        p2.next = p2.next.next;

        return dummy.next;
    }
}
