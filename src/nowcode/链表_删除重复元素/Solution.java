package nowcode.链表_删除重复元素;

// pre, cur, nxt 三指针遍历

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode deleteM(ListNode root) {
        ListNode dummy = new ListNode(-101);
        dummy.next = root;

        ListNode pre = dummy;
        ListNode cur = pre.next;
        if (cur == null) {
            // 空节点
            return null;
        }
        ListNode nxt = cur.next;
        if (nxt == null) {
            // 只有一个节点
            return root;
        }
        while (nxt != null) {
            if (cur.val != nxt.val) {
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
            } else {
                while (nxt != null && cur.val == nxt.val) {
                    nxt = nxt.next;
                }
                cur = nxt;
                pre.next = cur;

                if (nxt != null){  // 草！这里好关键，debug半天
                    nxt = nxt.next;
                }
            }
        }
        return dummy.next;
    }

    public ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(-101);
        ListNode p = dummy;
        for (int num : nums) {
            ListNode newNode = new ListNode(num);
            p.next = newNode;
            p = newNode;
        }
        return dummy.next;
    }

    public void traverse(ListNode root) {
        ListNode p = root;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 4, 5};
        int[] nums2 = {};
        int[] nums3 = {1, 1, 1};

        Solution solut = new Solution();
        ListNode root = solut.createList(nums);
        // solut.traverse(root);
        ListNode newRoot = solut.deleteM(root);
        solut.traverse(newRoot);
    }
}
