import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Scanner;


public class testEncryp {
	
	public void testEncryp(String input)
    {
         int length =input.length();
		System.out.println(length);
		double sqrtLengh= Math.sqrt(length);
		int heightMax = (int)Math.ceil(sqrtLengh);
		int widthMax =   (int)Math.floor(sqrtLengh);
		System.out.println(heightMax+" -- "+widthMax);
		int k=0;
		for(int i=0;i<length;i++)
		{
			String tempString="";
			if(i<length)
			{
				setTempString(input,i,heightMax);
				k++;
				if(k>=heightMax)
				{
					break;
				}
			}
		}
    
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input=""; 
		Scanner userInputScanner = new Scanner(System.in);
			input= input+userInputScanner.nextLine();
		
		// TODO Auto-generated method stub
		//String input=args[0];//"ifmanwasmeanttostayonthegroundgodwouldhavegivenusrootstostayhere";
         
		int length =input.length();
		//System.out.println(length);
		double sqrtLengh= Math.sqrt(length);
		int heightMax = (int)Math.ceil(sqrtLengh);
		int widthMax =   (int)Math.floor(sqrtLengh);
		//System.out.println(heightMax+" -- "+widthMax);
		int k=0;
		for(int i=0;i<length;i++)
		{
			String tempString="";
			if(i<length)
			{
				setTempString(input,i,heightMax);
				k++;
				if(k>=heightMax)
				{
					break;
				}
			}
		}
	}
	
	public static  String setTempString(String input,int starting,int heightMax)
	{
		String tempString="";
		for(int i=starting;i<input.length();i+=heightMax)
		{
			
			if(i<input.length())
			{
				tempString = tempString+Character.toString(input.charAt(i));
			}
		}
		System.out.print(tempString+" ");
	return tempString;
	}
	



}
