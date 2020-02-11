
public class PartitionList86 {
    public static void main(String[] a) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);


        ListNode result = new PartitionList86().partition(head,3);
        ListNode index = result;

        while (index != null){
            System.out.println(index.val);
            index = index.next;

        }
    }

    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode littleHold = new ListNode(-1);
        ListNode lcurrent = littleHold;

        ListNode baeHold = new ListNode(-1);
        ListNode baeCurrent = baeHold;

        ListNode current = head;

        while (current != null){
            if(current.val < x){
               lcurrent.next = current;
               lcurrent = current;

            }else{
                baeCurrent.next = current;
                baeCurrent = current;
            }
            current = current.next;



        }

        baeCurrent.next = null;

        if(littleHold.next == null){
            return baeHold.next;
        }else{
            lcurrent.next = baeHold.next;
            return littleHold.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
