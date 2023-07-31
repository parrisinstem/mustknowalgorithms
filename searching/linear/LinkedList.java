package searching.linear;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListA {
    Node head;

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    int linearSearch(int target) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == target) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        LinkedListA myList = new LinkedListA();
        myList.append(10);
        myList.append(30);
        myList.append(50);
        myList.append(20);
        myList.append(40);

        int targetElement = 20;
        int result = myList.linearSearch(targetElement);
        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else {
            System.out.println("Element not found.");
        }
    }
}
