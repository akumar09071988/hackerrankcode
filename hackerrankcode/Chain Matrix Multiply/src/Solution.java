
public class Solution {

	public static void main(String[] args) 
	{
		Solution obj = new Solution();
		try
		{
			int [] arr = {10, 20, 30, 40, 30};
			obj.calculateMin(arr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void calculateMin(int[] arr)
	{
		int N = arr.length;
		int [][] minMultiMatrix = new int[N][N];
		for(int i=0;i<N;i++)
		{
			minMultiMatrix[i][i] = 0;
		}
		
	
		
		for(int i=1;i<N;i++)
		{
			for(int j=1;j<N-i;j++)
			{
				if(minMultiMatrix[i+j-1][j-1]<minMultiMatrix[i+j][j])
				{
					 minMultiMatrix[i+j][j-1]= minMultiMatrix[i+j-1][j-1]+(arr[i+j-1]*arr[j-1]*arr[i+j]);	
				}
				else
				{
					minMultiMatrix[i+j][j-1]= minMultiMatrix[i+j][j]+(arr[i+j]*arr[j]*arr[i+j+1]);
				}
			  
			}
		}
		
		System.out.println(minMultiMatrix[N-1][0]);
	}
	
	
	public void dispMatrix(int[][] matrix)
	{
		int N = matrix.length;
		for(int i=0;i<N;i++)
		{
			System.out.println();
			int innerN = matrix[i].length;
			for(int k=0;k<innerN;k++)
			{
				System.out.print(matrix[N][innerN]+" ");
			}
		}
	}

}
