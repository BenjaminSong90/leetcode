public class ReverseList206 {

    public static void main(String[] args) {
        ListNode holder = new ListNode(1);
        holder.next = new ListNode(2);
        holder.next.next = new ListNode(3);
        holder.next.next.next = new ListNode(4);

        ListNode result = new ReverseList206().reverseList(holder);
        while (result != null){
            System.out.println("v: "+result.val);
            result = result.next;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode holder = new ListNode(-1);
        holder.next = head;
        ListNode result = new ListNode(-1);
        while (holder.next != null){
            ListNode next = holder.next;
            holder.next = next.next;
            next.next = result.next;
            result.next = next;
        }

        return result.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
