/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if (l == r) {
            return head;
        }
        ListNode ans = new ListNode(0,head);
        ListNode pre = ans;
        for(int i=1;i<l;i++) {
            pre = pre.next;
        }
        ListNode rev = pre.next;
        ListNode cur = rev.next;
        for(int i=0;i<r-l;i++) {
            rev.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = rev.next;
        }
        return ans.next;
    }
}