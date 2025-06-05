public class HanoiSolving{
  public static void SolveHanoi(int n, char source,char auxilary,char destination){
   if(n==1){
    System.out.println("Move disc 1 from"+source+"to"+destination);
	return;
	}
	SolveHanoi(n-1,source,destination,auxilary);
    System.out.println("Move disc"+n+"from"+source+"to"+destination);
	SolveHanoi(n-1,auxilary,source,destination);
	}
	public static void main(String[] args){
	 int numDiscs=4;
	 System.out.println("Towers of Hanoi solution for"+numDiscs+"discs:");
	 SolveHanoi(numDiscs,'A','B','C');
	 }
	 }
	