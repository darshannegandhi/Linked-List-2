// Time Complexity : O(3N) ~ O(N) as we will be linearly traversing through the LL 3 times
                //where 3 is constant. So the time complexity 
// Space Complexity : O(1) as we are just using two nodes as pointers.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        int lengthA = 0, lengthB = 0;
        
        ListNode tempA = headA;
        while(tempA != null) {
            lengthA++;
            tempA = tempA.next;
        }
        
        ListNode tempB = headB;
        while(tempB != null) {
            lengthB++;
            tempB = tempB.next;
        }
        
        tempA = headA;
        tempB = headB;
        
        while(tempA != null && tempB != null) {
            if(lengthA > lengthB) {
                lengthA--;
                tempA = tempA.next;
            } else if(lengthA < lengthB) {
                lengthB--;
                tempB = tempB.next;
            } else {
                if(tempA == tempB) {
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        
        return null;
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
