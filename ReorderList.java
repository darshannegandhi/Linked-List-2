// Time Complexity : O(N) as we will traverse through each element maximum twice.
// Space Complexity : O(1) as we are just using two nodes as pointers.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really

class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = head;
        
        while(slow != null && fast != null) {
            slow = slow.next;
            
            if(fast.next == null) {
                fast = fast.next;
            } else {
                fast = fast.next.next;
            }
        }
        
        ListNode otherHead = slow.next;
        slow.next = null;

        otherHead = reverseLinkedList(otherHead);
        
        while(head != null && otherHead != null) {
            ListNode temp = otherHead.next;
            otherHead.next = head.next;
            head.next = otherHead;
            head = head.next.next;
            otherHead = temp;
        }
    }
    
    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode previous = head;
        ListNode auxillary = head.next;
        
        while(auxillary != null) {
            ListNode temp = auxillary.next;
            previous.next = temp;
            auxillary.next = head;
            head = auxillary;
            
            auxillary = temp;
        }
        
        return head;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}