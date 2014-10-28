import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[] testCases = new int[size];
		for(int i=0;i<size;i++)
		{
			int k = in.nextInt();
			testCases[i]=k;
		}
		
		showResult(testCases, size);

	}
	
	private  static void showResult(int[] inputArr,int size)
	{
		for(int i=0;i<size;i++)
		{
			int k =2;
			int n = inputArr[i];
			for(int l=0;l<n;l++)
			{
				k = k*2;
				k=k%100000;
			}
			System.out.println(k);
		}
	}

}
