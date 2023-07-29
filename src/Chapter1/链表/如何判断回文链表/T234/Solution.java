package Chapter1.链表.如何判断回文链表.T234;

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
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        // left从头结点开始
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if (right == null) {
            // 如果当前节点为空，也返回true
            return true;
        }
        boolean res = traverse(right.next);
        // 更新res
        res = res && (left.val == right.val);
        // left向后移动
        left = left.next;
        return res;
    }

    // 优化空间复杂度
    // 双指针（快慢指针）
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        // 先找到中点
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果链表节点个数为奇数个，slow还要往后移动一个
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        ListNode q = right;
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        ListNode p = left;
        // 恢复原先的链表结构
        p.next = reverse(q);

        return true;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt;
        while (cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
