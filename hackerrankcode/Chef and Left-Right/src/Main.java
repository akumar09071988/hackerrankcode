import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		try
		{
			java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
			int N = Integer.parseInt(r.readLine());
			//System.out.println(N);
			String arr[] = new String[N];
			for(int i=0;i<arr.length ;i++)
			{
				arr[i] = r.readLine();
				//System.out.println(in.next());
			}
	       
			Main obj = new Main();
			obj.processArray(arr);
		}
		catch(Exception e0)
		{
			e0.printStackTrace();
		}
	}
	
	public void processArray(String[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			processAndResult(arr[i]);
		}
	}
	
	
	public void processAndResult(String s)
	{
		int seed =0;
		if(s.charAt(0)=='l')
		{
			seed =2;
		}
		else
		{
			seed =4;
		}
		
		for(int i=1;i<s.length();i++)
		{
			if(seed%2 ==0)
			{
				if(s.charAt(i)=='l')
				{
					seed = (seed *2)-1; 
				}
				else
				{
					seed = (seed *2)+1;
				}
			}
			else
			{
				if(s.charAt(i)=='l')
				{
					seed = (seed *2); 
				}
				else
				{
					seed = (seed *2)+2;
				}
			}
			seed =(int) (seed%(7+Math.pow(10, 9)));
		}
		//seed =(int) (seed%(7+Math.pow(10, 9)));
		System.out.println(seed);
	}
	
	

}
