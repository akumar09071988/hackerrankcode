import java.util.ArrayList;


public class Solution {

	int[] countCharacter ;
	int[] wordCharCount ;
	char[] lexiPosition ;
	int[] charCount;
	String acutalString="";
	ArrayList<String> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int countLetters(String s, int[] count)
	{
		//System.out.println(s);
		int uniqueLetters=0;
		for(int i=0;i<s.length();i++)
		{
			//System.out.println(s.charAt(i)%'a'+" "+s.charAt(i));
			if(count[s.charAt(i)%'a']==0)
			{
				//System.out.println("h");
				uniqueLetters++;
			}
		   	count[s.charAt(i)%'a']++;
		}
		return uniqueLetters;
	}
	
	private boolean validPrefix(int[] count)
	{
		boolean move = true;
   		for(int k=0;k<26;k++)
   		{
   			if(((countCharacter[k]/2)-charCount[k]>count[k]))
   			{
   			   move = false;
   			   break;
   			}
   		}
   		
   		return move;
	}
	
	private void findWord(String s1)
	{
		int length = s1.length();
		int [] count = null;
		for(int i=length/2;i>=0;i--)
		{
			String word ="";
			char temp =s1.charAt(i);
			if(i==length/2)
			{
				count = new int[26];
				countLetters(s1.substring(i), count);
			}
			else
			{
				
				count[temp%'a']++;
			}
			if(!validPrefix(count))
			{
				continue;
			}
			else
			{
				String s2=s1.substring(i);
				word = word+temp;
			    charCount[temp%'a']++;
			    int k=0;
				char temp1 = lexiPosition[i];
				int lIndex = s2.indexOf(temp1); 
				while(true)
				{
					if(lIndex==-1)
					{
						i++;
						temp1 = lexiPosition[i];
						lIndex = s2.lastIndexOf(temp1);
						continue;
					}
					int count2[]= new int[26];
					countLetters(s2.substring(lIndex), count2);
					if(!validPrefix(count2))
					{
						int l = s2.substring(0,lIndex).lastIndexOf(temp1);
					}
				}
			}
			
			
		}
	}

}
