import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Solution obj = new Solution();
        try
        {
        	
        	Scanner in1 = new Scanner(System.in);
			int noTestCases = in1.nextInt();
			int[] resultArray = new int[noTestCases];
			in1.nextLine();
			for(int i=0;i<noTestCases;i++)
			{
				String str =in1.nextLine();
				int nodes = Integer.parseInt(str.split(" ")[0]);
				int edges = Integer.parseInt(str.split(" ")[1]);
				resultArray[i]=obj.processGraph(nodes, edges);
			}
			
			for(int i=0;i<noTestCases;i++)
			{
				System.out.println(resultArray[i]);
			}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	public int processGraph(int nodes,int edges)
	{
	   int cliqueNodes = nodes;
	   boolean found =false;
	   while(cliqueNodes>2)
	   {
		   double tempEdges = turanFunction(nodes, cliqueNodes);
		      
		   if(tempEdges>=(double)edges)
		   {
			   cliqueNodes = cliqueNodes-1;
		   }
		   else
		   {
			   found= true;
			   break; 
		   }  
	   }
	   
	   if(!found)
	   {
		   if(cliqueNodes==2 && edges <1)
		   {
			   cliqueNodes =1;
		   }
		   
	   }
	   
	   return cliqueNodes;
	}
	
	public double turanFunction(int nodes,int cliqueSize)
	{
		int r =cliqueSize-1;
		
		double firstPart = 1-((double)(1/(double)r));
		
		double secPart   = (double)Math.pow(nodes, 2)/2;
		
		double edgesForClique = firstPart*secPart;
		return edgesForClique;
	}

}
