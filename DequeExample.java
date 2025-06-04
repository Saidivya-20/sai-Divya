import java.util.ArrayDeque;
import java.util.Deque;
public class DequeExample{
    public static void main(String[] args){
	Deque<Integer>deque=new ArrayDeque<>();
	deque.addFirst(10);
	deque.addLast(20);
	deque.offerFirst(5);
	deque.offerLast(25);
	System.out.println("Deque:"+deque);
	System.out.println("Removed Front:"+deque.pollFirst());
	System.out.println("Removed Rear:"+deque.pollLast());
	System.out.println("Front Element:"+deque.peekFirst());
	System.out.println("Rear Element:"+deque.peekLast());
	System.out.println("Final Deque:"+deque);
	}
}	