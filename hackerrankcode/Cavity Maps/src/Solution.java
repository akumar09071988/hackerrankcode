import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		System.out.println(N);
        int [][] array = new int[N][N];
        for(int i=0;i<N;i++)
        {
        	//System.out.println("1st loop start");
        	String s = in.next();
        	for(int k=0;k<N;k++)
        	{   
        		//System.out.println("2nd loop start");
        		array[i][k] = (int)(s.charAt(k))-48;;;
        		//System.out.println(array[i][k]);
        	}
        
        }
        
        Solution obj = new Solution();
        obj.process(array);
        obj.print(array);
        
	}
	
	public void process(int [][] mainArray )
	{
		for(int i=1;i<mainArray.length-1;i++)
		{
			for(int k=1;k<mainArray.length-1;k++)
			{
				if(compare(mainArray, i, k))
				{
					mainArray[i][k]= -1;
					k=k+1;
				}
			}
		}
	}
	
	public boolean compare(int[][] array,int i,int j)
	{
		if(array[i+1][j]==-1 || array[i-1][j]==-1 || array[i][j+1]==-1 || array[i][j-1]==-1)
		{
			return false;
		}
		
		if(array[i][j]<=array[i+1][j] )
		{
			return false;
		}
		else if(array[i][j]<=array[i-1][j])
		{
			return false;
		}
		else if(array[i][j]<=array[i][j+1])
		{
			return false;
		}
		else if(array[i][j]<=array[i][j-1])
		{
			return false;
		}
		return true;
	}
	
	public void print(int[][] array)
	{
		for(int i=0;i<array.length;i++)
		{
			for(int k=0;k<array.length;k++)
			{
				if(array[i][k]==-1)
				{
					System.out.print("X");
				}
				else
				{
					System.out.print(array[i][k]);	
				}
				
			}	
			
			System.out.println("");
		}
	}

}
