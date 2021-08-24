public class ReverseLinkedListII92 {

    public static void main(String[] a) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode result = new ReverseLinkedListII92().reverseBetween(head,2,4);
        while (result != null){
            System.out.println("v: "+result.val);
            result = result.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode begin = temp;
        ListNode end = temp;

        while(m > 1){
            m--;
            n--;
            begin = begin.next;
            end = end.next;
        }

        while(n > -1){
            n--;
            end = end.next;
        }

        begin.next = reverse(begin, end);
        return temp.next;
    }

    public ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = null;
        ListNode curr = begin.next;
        ListNode first, next;
        first = curr;

        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        first.next = end;
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
