// Package declaration for the 'fastslowpointers' package

// Node class to represent a node in a singly linked list
class Node {
    int data;   // Data stored in the node
    Node next;  // Reference to the next node

    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to remove the nth node from the end of a linked list
public class RemoveNthNode {

    // Method to remove the nth node from the end of the linked list
    public static Node removeNthFromEnd(Node head, int n) {
        // Base case: If the list is empty or n is not positive, return the original head
        if (head == null || n <= 0) {
            return head;
        }

        // Create a dummy node to handle edge cases where the nth node is the head node
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

        // Remove the nth node from the end by updating the 'next' pointer of the (n-1)th node
        slow.next = slow.next.next;

        return dummy.next; // Return the modified list (skipping the dummy node)
    }

    // Method to print the elements of the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to demonstrate the usage of the 'removeNthFromEnd' method
    public static void main(String[] args) {
        // Create and initialize a linked list for testing
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        // Print the original list
        System.out.println("Original List:");
        printList(list1);

        int n1 = 2;
        // Remove the 2nd node from the end and print the modified list
        Node modifiedList1 = removeNthFromEnd(list1, n1);
        System.out.println("\nModified List after removing " + n1 + "th node from the end:");
        printList(modifiedList1);

        // Create and initialize another linked list for testing
        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);

        // Print the original list
        System.out.println("\nOriginal List:");
        printList(list2);

        int n2 = 1;
        // Remove the last node from the end and print the modified list
        Node modifiedList2 = removeNthFromEnd(list2, n2);
        System.out.println("\nModified List after removing the last node:");
        printList(modifiedList2);
    }
}
