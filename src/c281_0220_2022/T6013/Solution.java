package c281_0220_2022.T6013;

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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        int sum = 0;
        while (cur != null) {
            if (cur.val == 0) {
                if (sum == 0){
                    pre.next = cur;
                    cur = cur.next;
                }else{
                    ListNode newNode = new ListNode(sum);
                    newNode.next = cur;
                    pre.next = newNode;
                    pre = newNode;
                    cur = cur.next;
                    sum = 0;
                }
            }else{
                sum += cur.val;
                // 把这个节点删除
                cur = cur.next;
                pre.next = cur;
            }
        }
        pre.next = cur;
        return dummy.next;
    }
}
