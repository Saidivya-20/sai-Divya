import java.util.Scanner;

public class Antmoves {
    
    public static int countReturnsToStart(int[] moves) {
        int position = 0;
        int count = 0;
        
        for (int move : moves) {
            position += move;
            if (position == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  
        int[] moves = new int[N];
        
        for (int i = 0; i < N; i++) {
            moves[i] = sc.nextInt();  
        }
        
        int result = countReturnsToStart(moves);
        System.out.println(result);
        
        sc.close();
    }
}
