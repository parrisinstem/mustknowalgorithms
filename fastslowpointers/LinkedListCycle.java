package fastslowpointers;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps

            if (slow == fast) {
                return true;  // If fast and slow pointers meet, there's a cycle
            }
        }

        return false; // No cycle found
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);
        list1.next.next.next.next.next = list1.next; // Creates a cycle, Node 5 points back to Node 2

        System.out.println("List1 has cycle: " + hasCycle(list1));

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);

        System.out.println("List2 has cycle: " + hasCycle(list2));
    }
}
