class RecursionDemo2{
  static int sum(int n){
  if(n==1){
    return 1;
	}else{
	return n+factorial(n-1);
	}
  }
  public static void main(String[] args){
  int number = 10;
  int result=sum(number);
  System.out.println("sum of first"+number+"Natural Number is"+result);
  }
}  