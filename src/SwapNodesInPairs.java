public class SwapNodesInPairs {

    public static void main(String[] a) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode next = new SwapNodesInPairs().swapPairs(head);
        while (next != null){
            System.out.println(next.val);
            next = next.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode first = dummpy;
        while (first.next != null){
            ListNode n1 = first.next;
            if(n1.next == null){
                break;
            }
            ListNode n2 = first.next.next;
            ListNode n3 = first.next.next.next;

            first.next = n2;
            first.next.next = n1;
            first.next.next.next = n3;
            first = first.next.next;

        }
        return dummpy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
