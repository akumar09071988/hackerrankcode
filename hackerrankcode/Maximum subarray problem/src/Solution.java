import java.util.Scanner;


public class Solution {
	
	int[][] outPutArray;

	public static void main(String[] args) 
	{
	   Solution obj = new Solution();
	   try
	   {
		   Scanner in = new Scanner(System.in);
		   int testcase =in.nextInt();
		   obj.outPutArray = new int[testcase][2];
		   in.nextLine();
		   for(int i=0;i<testcase;i++)
		   {
			   int noElements = in.nextInt();
			   in.nextLine();
			   int [] inputArr = new int[noElements];
			   for(int j=0;j<noElements;j++)
			   {
				   inputArr[j]=in.nextInt();
			   }
			   obj.calculateMaxSum(i, inputArr);
		   }
		   //in.nextLine();
		   for(int l=0;l<testcase;l++)
		   {
			   System.out.println(obj.outPutArray[l][0]+" "+obj.outPutArray[l][1]);
		   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }

	}
	
	public void calculateMaxSum(int i,int [] inputArr)
	{
		int maxCotiguous =0;
		int maxContiguousEndingHere=0;
		int maxNonContiguous =0;
		int N = inputArr.length;
		for(int k=0;k<N;k++)
		{
		
			if(inputArr[k] < maxContiguousEndingHere +inputArr[k])
			{
				maxContiguousEndingHere = maxContiguousEndingHere+inputArr[k];
			}
			else
			{
				maxContiguousEndingHere = inputArr[k];
			}
			
			
			if(maxCotiguous<maxContiguousEndingHere)
			{
				maxCotiguous=maxContiguousEndingHere;
			}
			if(maxNonContiguous+inputArr[k]>maxNonContiguous)
			{
				maxNonContiguous = maxNonContiguous+inputArr[k];
			}
		}
		this.outPutArray[i][0] = maxCotiguous;
		this.outPutArray[i][1]=maxNonContiguous;
	}

}
