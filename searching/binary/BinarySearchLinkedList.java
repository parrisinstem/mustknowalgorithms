package searching.binary;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortedLinkedList {
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

    int binarySearch(int target) {
        int low = 0;
        int high = getSize() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = getElementAt(mid);

            if (midElement == target) {
                return mid;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    int getElementAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}

public class BinarySearchLinkedList {
    public static void main(String[] args) {
        SortedLinkedList myList = new SortedLinkedList();
        myList.append(10);
        myList.append(20);
        myList.append(30);
        myList.append(40);
        myList.append(50);

        int targetElement = 30;
        int result = myList.binarySearch(targetElement);
        if (result != -1) {
            System.out.println("Element " + targetElement + " found at index " + result + ".");
        } else {
            System.out.println("Element not found.");
        }
    }
}
