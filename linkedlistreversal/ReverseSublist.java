package linkedlistreversal;

public class ReverseSublist {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the start position
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        ListNode next;

        // Reverse the sublist from m to n
        for (int i = m; i < n; i++) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseSublist reverser = new ReverseSublist();
        int m = 2, n = 4;
        ListNode reversedHead = reverser.reverseBetween(head, m, n);

        // Print the reversed sublist: 1 -> 4 -> 3 -> 2 -> 5 -> null
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " -> ");
            reversedHead = reversedHead.next;
        }
        System.out.print("null");
    }
}
