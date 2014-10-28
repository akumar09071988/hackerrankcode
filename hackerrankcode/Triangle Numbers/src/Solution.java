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
			if(inputArr[i]==1 ||inputArr[i]==2)
			{
				System.out.println("-1");
			}
			else
			{
				if(inputArr[i]%2!=0)
				{
					System.out.println("2");
				}
				else
				{
					if(inputArr[i]%4==0)
					{
						System.out.println("3");
					}
					else
					{
						System.out.println("4");
					}
				}
			}
			
		}
	}

}
