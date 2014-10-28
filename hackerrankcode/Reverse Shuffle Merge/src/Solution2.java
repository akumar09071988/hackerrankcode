import java.util.ArrayList;


public class Solution2 {

	/**
	 * @param args
	 */
	int[] countCharacter ;
	int[] wordCharCount ;
	char[] lexiPosition ;
	int[] charCount;
	String acutalString="";
	ArrayList<String> list;
	public static void main(String[] args) {

		Solution2 obj = new Solution2();
		obj.countCharacter = new int[26];
		//obj.positionCharacter = new int[26];
		obj.list = new ArrayList<>();
		obj.acutalString="agaege";
		String s1 = obj.acutalString;
        int size = obj.countLetters(s1, obj.countCharacter);
        //System.out.println(size);
        obj.lexiPosition = new char[size];
        obj.sortCharacters(obj.lexiPosition, obj.countCharacter);
        obj.charCount=  new int[26];
        obj.wordCharCount = new int[26];
        obj.findWord(s1, "");
		for(int i=0;i<obj.list.size();i++)
		{
			System.out.println(obj.list.get(i));
		}
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
	
	private void sortCharacters(char[] lexPos,int[] count)
	{
		int index=0;
		for(int i=0;i<26;i++)
		{
			if(count[i]!=0)
			{
				lexPos[index]=(char)('a'+i);
				index++;
			}
		}
	}
	
	private void findWord(String s1, String word)
	{
		int i=0;
		char tempPrefix = lexiPosition[i];
	   	int lastIndex = s1.lastIndexOf(tempPrefix);
		while(true)
		{
			   System.out.println(i+"  "+lexiPosition.length);
				tempPrefix = lexiPosition[i];
				lastIndex = s1.lastIndexOf(tempPrefix);
				if(lastIndex==-1 || (wordCharCount[tempPrefix%'a']==(countCharacter[tempPrefix%'a']/2)))
			   	{
			   		i++;
			   		continue;
			   	}
				
			
		   	
		   	
		   		int[] count1 = new int[26];
		   		boolean increment=false;
		   		while(true)
		   		{
		   			countLetters(s1.substring(lastIndex), count1);
		   			boolean move = true;
			   		for(int k=0;k<26;k++)
			   		{
			   			if(((countCharacter[k]/2)-charCount[k]>count1[k]))
			   			{
			   			   move = false;
			   			   break;
			   			}
			   		}
			   		if(!move)
			   		{
			   			lastIndex = s1.substring(0, lastIndex).lastIndexOf(tempPrefix);
			   			count1 = new int[26];
			   			if(lastIndex==-1 || (wordCharCount[tempPrefix%'a']==(countCharacter[tempPrefix%'a']/2)))
			   			{
			   				i++;
			   				increment=true;
			   				break;
			   			}
			   			
			   			continue;
			   		}
			   		else
			   		{
			   		 
			   		  if(word.length()<acutalString.length()/2)
			   		  {
			   			 charCount[tempPrefix%'a']++;
			   			 wordCharCount[tempPrefix%'a']++;
			   			 System.out.println("---------------"+tempPrefix+"  "+lastIndex+" "+wordCharCount[tempPrefix%'a']+" "+word);
			   			 if((wordCharCount[tempPrefix%'a']<(countCharacter[tempPrefix%'a']/2)))
			   			 {
			   				word=word+tempPrefix; 
			   			 }
				   		  
				   		if(word.length()==acutalString.length()/2)
				   		  {
				   			wordCharCount = new int[26];
				   			  list.add(word);
				   			  break;
				   		  }
				   		System.out.println("----"+s1.substring(lastIndex+1));
				   		findWord(s1.substring(lastIndex+1), word);
			   		  }
			   		  if(word.length()==acutalString.length()/2)
			   		  {
			   			  list.add(word);
			   			  break;
			   		  }
			   		  
			   		}
			   		
		   		}
		   		
		   		if(word.length()==acutalString.length()/2)
		   		  {
		   			  break;
		   		  }
		}
		
	}

}
