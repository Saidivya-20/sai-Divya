// Node class for linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class using linked list
class Queue {
    private Node front, rear;

    // Enqueue: Add element to the rear
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(data + " enqueued to queue");
    }

    // Dequeue: Remove element from the front
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null; // Queue became empty
        }

        return value;
    }

    // Peek: View front element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Main class to test the queue
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front element is: " + queue.peek());

        System.out.println(queue.dequeue() + " dequeued from queue");

        queue.display();
    }
}
