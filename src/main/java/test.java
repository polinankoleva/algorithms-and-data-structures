
public class test {
	
	public static void main(String[] args){
		int[] a = plusOne(new int[]{0, 3, 7, 6, 4, 0, 5, 5, 5});
		for(int i = 0; i <a.length; i++){
			System.out.println(a[i]);
		}
		System.out.println(a);
	}
	    public static int[] plusOne(int[] A) {
	        for(int i = A.length - 1; i>=0; i--){
	            if(A[i] == 9){
	                A[i] = 0;
	                if(i == 0){
	                    A = new int[A.length + 1];
	                    A[0] = 1;
	                }
	            } else {
	                A[i] = A[i]+1;
	               break;
	            }
	        }
	        return A;
	    }

}
