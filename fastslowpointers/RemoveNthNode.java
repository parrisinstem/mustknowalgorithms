package fastslowpointers;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveNthNode {
    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        // Move the fast pointer n+1 steps ahead of the slow pointer
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                // If n is greater than the list's length, n+1 steps will go beyond the end
                return head;
            }
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the modified list (skipping the dummy node)
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(list1);

        int n1 = 2;
        Node modifiedList1 = removeNthFromEnd(list1, n1);
        System.out.println("\nModified List after removing " + n1 + "th node from the end:");
        printList(modifiedList1);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);

        System.out.println("\nOriginal List:");
        printList(list2);

        int n2 = 1;
        Node modifiedList2 = removeNthFromEnd(list2, n2);
        System.out.println("\nModified List after removing the last node:");
        printList(modifiedList2);
    }
}
