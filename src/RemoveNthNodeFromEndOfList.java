
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] a) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode next = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);
        while (next != null) {
            System.out.println("number: " + next.val);
            next = next.next;
        }


    }
    //有可能简单的就是最快的， 一开始觉得遍历再遍历比较慢，但是试下来他确实最快的
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
