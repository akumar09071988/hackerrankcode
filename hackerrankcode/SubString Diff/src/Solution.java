import java.util.ArrayList;
import java.util.Scanner;
//3 abcdef baacef

public class Solution {

	
	 int totalDiffArray[][];
	/**
	 * @param args
	 */
	  class testObj
	 {
		 int diff;
		 String s1,s2;
	 }
	 
	public static void main(String[] args) {
   
		Scanner in = new Scanner(System.in);
		int size= Integer.parseInt(in.nextLine());;
		Solution obj = new Solution();
		ArrayList<testObj> list = new ArrayList<>();
		for(int i=0;i<size;i++)
		{
			testObj tstObj = obj.new testObj();
			String test=in.nextLine();
			//System.out.println(test+test.split(" ")[0]+" "+i);
			tstObj.diff=Integer.parseInt(test.split(" ")[0]);
			tstObj.s1 = test.split(" ")[1];
			tstObj.s2 = test.split(" ")[2];
			list.add(tstObj);
		}
		for(int i=0;i<size;i++)
		{
			testObj tstObj = list.get(i);
			String s1=tstObj.s1;
			String s2=tstObj.s2;
			int diff=tstObj.diff;
			obj.totalDiffArray = new int[s1.length()][s2.length()];
			obj.totalStringDiff(s1, s2, obj.totalDiffArray);
			obj.calculateStringLength(s1, s2, obj.totalDiffArray, diff);			
		}
		
		
		
		
	}
	
	private  void totalStringDiff(String s1,String s2,int[][] diffArray)
	{
		for(int i = 0;i<s1.length();i++)
		{
			for(int k=0;k<s2.length();k++)
			{
				if(s1.charAt(i)!=s2.charAt(k))
				{
					diffArray[i][k]=1;
				}
				else
				{
					diffArray[i][k]=0;
				}
				//System.out.print(diffArray[i][k]);
			}
			//System.out.println("  ");
		}
		
		
	}
	
	private void calculateStringLength(String s1,String s2,int[][] diffArray,int maxDiff)
	{
		int maxLength=0;
		for(int i = 0;i<diffArray.length;i++)
		{
			int curDiff=0,curLength=0,secStrt=0;
			
		}
		
	}
	
	/*private void calculateStringLength(String s1,String s2,int[][] diffArray,int maxDiff)
	{
		//System.out.println("------------"+diffArray.length);
		int maxLength=0,diff=0,strt1=0,end1=0,strt2=0,end2=0;
		for(int i = 0;i<diffArray.length;i++)
		{
           int curDiff=0,curLength=0,secStrt=0;	
           while(secStrt+curLength<=(s2.length()-1)&&(i+curLength<=s2.length()-1))
           {
        	   
        	  // System.out.println(i+"  "+"  "+curLength+"  "+secStrt+" "+curDiff);
        	   if(diffArray[i+curLength][secStrt+curLength]==1)
        	   {
        		   curDiff++;   
        	   }
        	   curLength++;
        	   
        	   if(curDiff>maxDiff)
        	   {
        		   if(diffArray[i][secStrt]==1)
        		   {
        			   curDiff-=1;
        		   }
        		   
        		   curLength-=1;
        		   secStrt++;
        		   continue;
        	   }
        	   else
        	   {
        		   if(curLength>maxLength)
            	   {
            		   maxLength=curLength;
            		   strt1=i;strt2=secStrt;end1=i+curLength-1;end2=secStrt+curLength-1;
            	   }   
        	   }
        	   
        	   
           }
		}
		//System.out.println(strt1+" "+end1+"  "+strt2+" "+end2);
		System.out.println(maxLength);
	}*/
	
	
	

}
