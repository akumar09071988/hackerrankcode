import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Set<String> set = new TreeSet<String>();
		int _a_size = Integer.parseInt(in.nextLine());
		String[] _a = new String[_a_size];
		int i=0;
		while(i<_a_size)
		{
			_a[i]=in.nextLine();
			//System.out.println(_a[i]);
			i++;
		}
		
		i=0;
		while(i<_a_size)
		{
			returnHtmlelements(_a[i],set);
			i++;
		}
		Iterator itr =set.iterator(); 
		String finalResult="";
		while(itr.hasNext())
		{
			finalResult=finalResult+itr.next()+";";
			//set.iterator().next();
		}
		System.out.println(finalResult.substring(0,finalResult.length()-1));


	}
	
	private static void returnHtmlelements(String s,Set<String> set1)
	{
		String[] splittedStrings= s.split("<");
		for(int k=1;k<splittedStrings.length;k++)
		{
			String s1=splittedStrings[k].trim();
			//System.out.println(s1.substring(0,1));
			if(!(s1.equalsIgnoreCase(" ") || s1.substring(0,1).equalsIgnoreCase("/"))) 
			{
				//System.out.println(s1.indexOf("/")+"  "+s1.indexOf(">"));
				int lastIndex = s1.indexOf(" ")!=-1? s1.indexOf(" "):(s1.indexOf("/")!=-1?((s1.indexOf(">")!=-1 && (s1.indexOf("/")<s1.indexOf(">")))?s1.indexOf("/"):s1.indexOf(">")):s1.indexOf(">"));
                //System.out.println(lastIndex);
				if(lastIndex!=0)
                {
                	String tag = s1.substring(0,lastIndex);
    				set1.add(tag);	
                }
				
			}
			
		}
	}

}
