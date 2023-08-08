// Package declaration for the 'fastslowpointers' package

// Node class to represent a node in a linked list
class Node {
    int data;   // Data stored in the node
    Node next;  // Reference to the next node

    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class to check if a linked list is a palindrome
class PalindromeLinkedList {

    // Method to check if a linked list is a palindrome
    public static boolean isPalindrome(Node head) {
        // Base case: If the list is empty or has only one element, it is a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Initialize two pointers, 'slow' and 'fast', to find the middle of the linked list
        Node slow = head;
        Node fast = head;

        // Traverse the list using 'fast' pointer, with 'slow' pointer moving half the speed
        // This way, 'slow' will be at the middle node when 'fast' reaches the end
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'secondHalf' points to the reversed second half of the linked list
        Node secondHalf = reverse(slow.next);

        // 'firstHalf' points to the first half of the linked list (from the head)
        Node firstHalf = head;

        // Compare each node in 'firstHalf' with the corresponding node in 'secondHalf'
        // If data does not match, the linked list is not a palindrome
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // All nodes matched, the linked list is a palindrome
        return true;
    }

    // Method to reverse a linked list and return the new head node
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        // Reverse the pointers for each node in the linked list
        while (current != null) {
            next = current.next;    // Store the next node
            current.next = prev;    // Reverse the current node's pointer
            prev = current;         // Move 'prev' to the current node
            current = next;         // Move 'current' to the next node
        }

        // 'prev' points to the new head of the reversed list
        return prev;
    }

    // Main method to demonstrate the usage of the 'isPalindrome' method
    public static void main(String[] args) {
        // Create and initialize linked lists for testing
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(2);
        list1.next.next.next.next = new Node(1);

        // Check if 'list1' is a palindrome using 'isPalindrome' method
        System.out.println("Is list1 a palindrome? " + isPalindrome(list1));

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);

        // Check if 'list2' is a palindrome using 'isPalindrome' method
        System.out.println("Is list2 a palindrome? " + isPalindrome(list2));
    }
}
