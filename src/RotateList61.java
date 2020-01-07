public class RotateList61 {
    public static void main(String[] a) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);





        ListNode i = new RotateList61().rotateRight(head,4);
        while (i != null){
            System.out.println(i.val);
            i = i.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {


        if(head==null)
            return head;

        ListNode holder = new ListNode(0);

        holder.next = head;
        int len = 0;
        ListNode lastn = head;
        len++;
        while (lastn.next != null){
            len++;
            lastn = lastn.next;
        }

        k = k%len;

        int leftIndex = len-k+1;
        ListNode befTagNode = holder;

        for(int i = 1; i < leftIndex; i++){
            befTagNode = befTagNode.next;
        }

        lastn.next = holder.next;
        holder.next = befTagNode.next;
        befTagNode.next = null;

        return holder.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
