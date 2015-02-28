import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		
		 
		 try {
		
			Scanner in = new Scanner(System.in);
			int numTest = Integer.parseInt(in.nextLine());
			String [] output = new String[numTest];
			for (int i=0;i<numTest;i++)
			{
				boolean funny =true;
				String s = in.nextLine();
				byte[] bytes = s.getBytes("US-ASCII");
				int[] diff = new int[bytes.length-1];
				for(int k=0;k<bytes.length-1;k++)
				{
					diff[k] =Math.abs(bytes[k+1]-bytes[k]);
				}
				for(int k=bytes.length-1 ,j=0;k>0;k--,j++)
				{
					if(Math.abs(bytes[k]-bytes[k-1])!=diff[j])
					{
						output[i] = "Not Funny";
						funny =false;
						break;
					}
				}
				if(funny)
				{
					output[i] ="Funny";	
				}
				
			}
			for (int i=0;i<numTest;i++)
			{
				System.out.println(output[i]);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   

	}

}
