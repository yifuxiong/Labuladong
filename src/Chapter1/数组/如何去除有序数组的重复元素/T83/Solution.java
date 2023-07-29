package Chapter1.数组.如何去除有序数组的重复元素.T83;

// 链表删除【多余】的重复元素（和链表删除重复元素这题还不同）

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null){
            if (pre.val == cur.val){
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = cur;
        return dummy.next;
    }
}
