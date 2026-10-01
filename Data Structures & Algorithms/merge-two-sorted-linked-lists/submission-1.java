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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // return a particular list
        // if one list is empty
        // if both lists are empty
        // remaining list part

        // 2 dummy node one for joining and second for return
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode cur = dummy;

        // run while
        while(list1 != null && list2 != null){
            int v1 = list1.val;
            int v2 = list2.val;

            if(v1 <= v2){
                list1 = list1.next;
                cur = cur.next;
            } else{ 
                ListNode nxt = cur.next;
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                cur.next = nxt;                
            }
        }

        // if 1 is not empty
        if(list1 != null){
            cur.next = list1;
        }

        // if 2 is not empty
        if(list2 != null){
            cur.next = list2;
        }

        // return dummy.next
        return dummy.next;
    }
}

// TC O(m + n) len of list1 and list 2 
// SC O(1)