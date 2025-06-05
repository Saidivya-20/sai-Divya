class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;

    
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

  
    public void delete(int key) {
        Node current = head;
        Node prev = null;

        
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

    
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        
        if (current == null) {
            System.out.println("Key not found.");
            return;
        }

        
        prev.next = current.next;
    }

    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Original List:");
        list.display();

        list.delete(20);
        System.out.println("After deleting 20:");
        list.display();

        list.delete(100);  
    }
}
