public class Knapsack{
     public static int Knapsack(int[] weigth,int[] profit,int w,int n){
	    if(n==0||w==0){
		   return 0;
		   }
		   if(weigth[n-1]>w){
		      return Knapsack(weigth,profit,w,n-1);
			}else{
            int include=profit[n-1]+Knapsack(weigth,profit,w-weigth[n-1],n-1);
            int exclude=Knapsack(weigth,profit,w,n-1);
            return Math.max(include,exclude);
            }
		}
    public static void main(String[] args){
        int w1=4;
        int[] profit1={1,2,3};
        int[] weigth1={4,5,1};
        int n1=profit1.length;
        int result=Knapsack(weigth1,profit1,w1,n1);
        System.out.println("output for Test case:"+result);
    }
}	