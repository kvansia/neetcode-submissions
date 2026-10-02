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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int surplus = 0;
        ListNode d1 = l1, d2 = l2, a = new ListNode(), ans = a;
        while(d1 != null && d2 != null){
            int sum = d1.val + d2.val;
            sum += surplus;
            surplus = sum / 10;
            sum = sum % 10;
            a.next = new ListNode(sum);
            a = a.next;
            d1 = d1.next;
            d2 = d2.next;
        }
        
        while(d1 != null){
            int sum = d1.val + surplus;
            surplus = sum / 10;
            sum = sum % 10;
            a.next = new ListNode(sum);
            a = a.next;
            d1 = d1.next;
        }

        while(d2 != null){
            int sum = d2.val + surplus;
            surplus = sum / 10;
            sum = sum % 10;
            a.next = new ListNode(sum);
            a = a.next;
            d2 = d2.next;
        }

        if(surplus != 0){
            a.next = new ListNode(surplus);
        }

        return ans.next;        
    }
}

// TC O(n)
// SC O(n)