import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class detecthtml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		int _a_size = Integer.parseInt(in.nextLine());
		String[] _a = new String[_a_size];
		int i=0;
		while(i<_a_size)
		{
			_a[i]=in.next();
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
		while(itr.hasNext())
		{
			System.out.print(itr.next()+";");
			//set.iterator().next();
		}

	}
	
	private static void returnHtmlelements(String s,Set<String> set1)
	{
		String[] splittedStrings= s.split("<");
		for(int k=1;k<splittedStrings.length;k++)
		{
			System.out.println(splittedStrings[k]);
			if(!splittedStrings[k].equalsIgnoreCase(""))
			{
				String s1=splittedStrings[k].trim();
				System.out.println(s.substring(0,s.indexOf("/")==-1?s.indexOf(" "):s.indexOf("/")));
				if(!(splittedStrings[k].trim().substring(0,1)).equalsIgnoreCase("/"))
				{
				System.out.println(set1.add(s.substring(0,s.indexOf("/")==-1?s.indexOf(" "):s.indexOf("/"))));
				}
			}
			
		}
	}

}
