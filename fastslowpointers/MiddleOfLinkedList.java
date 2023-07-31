package fastslowpointers;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MiddleOfLinkedList {
    public static Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps
        }

        return slow;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        Node middle1 = findMiddle(list1);
        System.out.println("Middle of list1: " + middle1.data);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);
        list2.next.next.next.next.next = new Node(6);

        Node middle2 = findMiddle(list2);
        System.out.println("Middle of list2: " + middle2.data);
    }
}
