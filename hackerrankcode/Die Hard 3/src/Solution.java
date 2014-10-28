import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(in.nextLine());
		String [] testcases = new String[size];
		for(int i =0;i<size;i++)
		{
			
			  String temp=in.nextLine();
			 // System.out.println("---- "+temp);
			  testcases[i] =temp;
		}
		showResult(testcases, size);
		
	}
	
	private static void showResult(String[] testCases,int size)
	{
		for(int i =0;i<size;i++)
		{
			String temp=testCases[i] ;
			//System.out.println(temp.split(" ")[0]);
			processTestCases(Integer.parseInt(temp.split(" ")[0]),Integer.parseInt(temp.split(" ")[1]),Integer.parseInt(temp.split(" ")[2]));
		}
	}
	
	private static void processTestCases(int a,int b,int c)
	{
		if(a>b)
		{
			int tmp= a;
			a=b;
			b=tmp;
		}
		if(c>b && c >a)
		{
			System.out.println("NO");
		}
		if(c==b || c==a)
		{
			System.out.println("YES");
		}
		else
		{
			double x = Math.pow(b, 2)-Math.pow(a, 2);
			if(x== Math.pow(c, 2))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}

}
