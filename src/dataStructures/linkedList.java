package dataStructures;

public class linkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add a node at the end of the list
    public void add(int data) {
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

    // Add a node at a specific position
    public void addAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node previous = null;
        Node current = head;
        int index = 0;

        while (current != null && index < position) {
            previous = current;
            current = current.next;
            index++;
        }

        newNode.next = current;
        if (previous != null) {
            previous.next = newNode;
        }
    }

    // Remove a node by data value
    public boolean remove(int data) {
        if (head == null) return false;

        if (head.data == data) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Find a node and return its position
    public int find(int data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;  // return -1 if the data is not found
    }

    // Print the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void demoLinkedList() {
        linkedList list = new linkedList();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding elements:");
        list.display();

        // Adding element at position
        list.addAtPosition(15, 1);
        System.out.println("After adding 15 at position 1:");
        list.display();

        // Removing element
        list.remove(20);
        System.out.println("After removing element 20:");
        list.display();

        // Finding element
        int index = list.find(15);
        System.out.println("Element 15 found at position: " + index);

        // Final state of the list
        System.out.println("Final state of the list:");
        list.display();
    }

}