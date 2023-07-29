// 合并K个有序链表
// 解法：堆、优先队列
package Chapter1.链表.单链表6大题解套路.T23;

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // int initialCapacity, Comparator<? super E> comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        // lists中是K个链表的头结点
        for (ListNode head : lists) {
            if (head != null) {
                // 这里这把头结点加进去了
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            // 这里要注意：前面只把每个链表头结点add到pq中了，
            // 接下来要把每个链表头结点所连的后面的节点也依次加入到pq中
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
