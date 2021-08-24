public class RemoveDuplicatesFromSortedListII82 {

    public static void main(String[] a) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);


        ListNode result = new RemoveDuplicatesFromSortedListII82().deleteDuplicates(head);
        ListNode index = result;

        while (index != null){
            System.out.println(index.val);
            index = index.next;

        }
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if(head==null) return head;
//        Map<Integer,Integer> couter = new HashMap<>();
//        ListNode pointer = head;
//        while (pointer != null){
//            if(couter.containsKey(pointer.val)){
//                int num = couter.get(pointer.val);
//                num++;
//                couter.put(pointer.val,num);
//            }else{
//                couter.put(pointer.val,1);
//            }
//
//            pointer = pointer.next;
//        }
//
//        ListNode hold = new ListNode(-1);
//        hold.next = head;
//        pointer = hold;
//
//        while (pointer.next != null){
//            if(couter.get(pointer.next.val) > 1){
//                ListNode rNode = pointer.next;
//                pointer.next = rNode.next;
//                rNode.next = null;
//            }else{
//                pointer = pointer.next;
//            }
//        }
//
//        return hold.next;
//    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode previous = null;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                int x = current.val;
                while (current != null && current.val == x) current = current.next;
                if (previous == null) head = current;
                else previous.next = current;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
