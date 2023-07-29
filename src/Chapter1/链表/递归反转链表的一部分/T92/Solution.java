// 1.反转链表前 N 个节点
// 2.反转链表的一部分
// 解决办法：递归

package Chapter1.链表.递归反转链表的一部分.T92;

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
    // 反转链表前 N 个节点
    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        // 反转前1个节点，即不用反转
        if (n == 1) {
            successor = head.next;
            return head;
        }

        // 从head的下一个节点开始，还需要反转n-1个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 注意这里，head.next不再是null了，因为head不一定是最后一个节点
        head.next = successor;
        return last;
    }

    // T92，反转链表的一部分
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // T92，非递归
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode nxt;
        for (int i = 0; i < right - left; i++) {
            nxt = cur.next;  // 只有nxt在动
            cur.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
        }
        return dummy.next;
    }
}
