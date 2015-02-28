import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Scanner in = new Scanner(System.in);
			int num = Integer.parseInt(in.nextLine());
			int[] arr = new int[num];
			int[] left = new int[num];
			int [] right = new int[num];
			int currLeftMax = 0;
			for(int i=0;i<num;i++)
			{
				arr[i] = in.nextInt();

			}
			for(int i=0;i<num;i++)
			{
				if(i==0)
				{
					left[i] =0;
					right[i] = Solution.findRIght(i, arr);
				}
				else if(i== num-1)
				{
					right[i]=0;
					left[i] = Solution.findLeft(i, arr);
				}
				else
				{
					right[i] = Solution.findRIght(i, arr);
					left[i] = Solution.findLeft(i, arr);
				}
				//System.out.println(left[i]);
			}
		
			int max =0;
			for(int i=0;i<num;i++)
			{
				//System.out.print(left[i]+" "+right[i]+" - ");
				int prod = left[i]*right[i];
				if(prod>max)
				{
					max = prod;
				}
			}
			System.out.println(max);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static int findLeft(int index,int[] arr)
	{
		int leftIndex =0;
		for(int i=index-1;i>-1;i-=1)
		{
			if(arr[i]>arr[index])
				{
				 leftIndex =i; return leftIndex+1;
				}
		}
		return leftIndex;
	}
	
	public static int findRIght(int index,int[] arr)
	{
		int rightIndex =0;
		for(int i=index+1;i<arr.length;i++)
		{
			if(arr[i]>arr[index])
				{
				  rightIndex =i;return rightIndex+1;
				}
		}
		return rightIndex;
	}

}