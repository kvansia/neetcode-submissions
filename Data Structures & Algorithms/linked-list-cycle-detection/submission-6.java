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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        // slow and fast traversal
        ListNode s = head, f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true; 
        }
        return false;
    }
}

// TC O(n)
// SC O(1)
