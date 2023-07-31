package linkedlistreversal;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = newHead;
            newHead = newNode;
            head = head.next;
        }

        return newHead; // newHead points to the new head of the reversed linked list
    }

    

    public static void main(String[] args) {
        // Sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverser = new ReverseLinkedList();
        ListNode reversedHead = reverser.reverse(head);

        // Print the reversed linked list: 5 -> 4 -> 3 -> 2 -> 1 -> null
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " -> ");
            reversedHead = reversedHead.next;
        }
        System.out.print("null");
    }
}
