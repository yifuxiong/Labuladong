// 判断链表是否包含环
// 解决办法：快慢指针

package Chapter1.链表.单链表6大题解套路.T141_142;

class ListNode{
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    // T141
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    // T142
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            // 相遇时退出
            if (fast == slow){
                break;
            }
        }

        if (fast == null || fast.next == null){
            // fast遇到空节点，说明没有环
            return null;
        }

        // slow重新指向head
        slow = head;
        // slow走k-m步，fast走k-m步，两者会在环入口处相遇
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
