import java.util.Scanner;


public class Solution {
	
	private static  int[] output;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);  
		int _a_size = Integer.parseInt(in.nextLine());
		Solution obj = new Solution();
		output = new int[_a_size];
		String [] input = new String[_a_size];//{"aaabbb","ab","abc","mnop","xyyx"};
		int k=0;
		while(k<_a_size)
		{
			input[k]=in.nextLine();
			//System.out.println(_a[i]);
			k++;
		}
		obj.loopString(input);
		// TODO Auto-generated method stub
		for(int i=0;i<output.length;i++)
		  {
			  System.out.println(output[i]); ;
		  }
	}
	
	
	private  void loopString(String [] inputArray)
	{
	  for(int i=0;i<inputArray.length;i++)
	  {
		  String temp = inputArray[i];
		  analyzeString(temp,i);
	  }
	}

	
	private void analyzeString(String inputString, int index)
	{
	
	  int length=inputString.length();
	  if(length%2!=0)
		  {
		      output[index] = -1;
		  }
	  else
	  {
		  String word1 = inputString.substring(0,(length/2));
		  String word2 = inputString.substring((length/2));
		  int[] charArray = new int[26];
		  
		  for(int i=0;i<word2.length();i++)
		  {
			  Character temp = word2.charAt(i);
			 charArray[temp%'a']+=1;
			  
		  }
		  
		  for(int i=0;i<word1.length();i++)
		  {
			  Character temp = word1.charAt(i);
			  if(charArray[temp%'a']!=0)
			  {
				  charArray[temp%'a']-=1; 
			  }else
			  {
				  output[index]+=1;
			  }
			  
		  }
	  }
	  
	}
}
