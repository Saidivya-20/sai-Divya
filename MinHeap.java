import java.util.*;
public class MinHeap{
public static void main(String[] args){
   PriorityQueue<Integer>minHeap=new PriorityQueue<>();
   minHeap.add(10);
   minHeap.add(5);
   minHeap.add(20);
   minHeap.add(3);
   while(!minHeap.isEmpty()){
   System.out.print(minHeap.poll()+" ");
   }
 }
}