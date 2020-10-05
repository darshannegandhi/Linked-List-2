// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : Not really.

public class DeleteNodeWIthoutHead {
    void deleteNode(Node node)
    {
         if(node == null) {
             return;
         }
         
         if(node.next == null) {
             node = null;
         } else {
             node.data = node.next.data;
             node.next = node.next.next;
         }
    }

    class Node {
	    int data ;
	    Node next;
	    Node(int d)
	    {
		    data = d;
		    next = null;
	    }
    }
}
