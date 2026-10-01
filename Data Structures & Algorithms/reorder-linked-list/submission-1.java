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
    public void reorderList(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        // reverse the second half
        ListNode sec = s.next;
        s.next = null;
        ListNode prev = null;
        while(sec != null){
            ListNode nxt = sec.next;
            sec.next = prev;
            prev = sec;
            sec = nxt;
        }

        ListNode rord = head;
        while(prev != null){
            ListNode nxt = rord.next;
            ListNode nxtP = prev.next;
            
            rord.next = prev;
            prev.next = nxt;
            
            rord = nxt;
            prev = nxtP;
        }
    }
}

// TC O(n)
// SC O(1)