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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode node: lists){
            if(node != null)
                pq.add(node);
        }

        ListNode d = new ListNode();
        ListNode tail = d;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return d.next;
    }
}

// TC O(NlogK) N Lists.length && K average num of nodes in each list
// SC O(N) Lists.length
