import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	
	int noOfColors =0;
	int [] heightCandles;
	int [] colorsCandles;
	ArrayList<Pile> processingList ;
	
	class Pile
	{
		int size                    = 0;
		int max                     = 0;
		int noOfColorsNotCov        = Solution.this.noOfColors;
		ArrayList<Integer> elements = new ArrayList<Integer>();
		int [] colors               = new int[Solution.this.noOfColors];
	}

	public static void main(String[] args) 
	{
		Solution obj = new Solution();
        try
        {
        	Scanner in = new Scanner(System.in);
        	String firstLine  =  in.nextLine();
        	int N = Integer.parseInt(firstLine.split(" ")[0]);
        	obj.noOfColors = Integer.parseInt(firstLine.split(" ")[1]);
        	//System.out.println(N+" "+obj.noOfColors);
        	obj.heightCandles  = new int[N];
        	obj.colorsCandles  = new int[N];
        	obj.processingList = new ArrayList<Pile>(N);
        	for(int i=0;i<N;i++)
        	{
        		String line = in.nextLine();
        		obj.heightCandles[i] = Integer.parseInt(line.split(" ")[0]);
        		obj.colorsCandles[i] = Integer.parseInt(line.split(" ")[1]);
        		//System.out.println(obj.heightCandles[i]+" "+obj.colorsCandles[i]);
        		Pile pileObj = obj. new Pile();
        		obj.processingList.add(pileObj);
        		System.out.println(obj.processingList.get(i).noOfColorsNotCov);
        	}
        	
        	obj.executeIncreasingSubsequnce(N);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	public void executeIncreasingSubsequnce(int N)
	{
		for(int i=0;i<N;i++)
		{
			Pile outerPile = this.processingList.get(i);
			outerPile.max = this.heightCandles[i];
			outerPile.colors[this.colorsCandles[i]] = 1;
			outerPile.noOfColorsNotCov-=1;
			outerPile.size++;
			outerPile.elements.add(this.heightCandles[i]);
			for(int j=i+1;j<N;j++)
			{
				if(outerPile.max<this.heightCandles[j])
				{
					
				}
			}
		}
	}

}
