import java.util.Arrays;
import java.util.Scanner;


public class Solution1NoGraph {
	
	class Ladder implements Comparable<Ladder>
	{
		int strtPoint=0;
		int endPoint =0;
		@Override
		public int compareTo(Ladder arg0) {
			if(strtPoint<arg0.strtPoint)
			{
				return -1;
			}
			else if(strtPoint>arg0.strtPoint)
			{
				return 1;
			}
			return 0;
		}
	}
	
	class snakes implements Comparable<snakes>
	{
		int strtPoint=0;
		int endPoint =0;
		@Override
		public int compareTo(snakes o) {
			if(strtPoint<o.strtPoint)
			{
				return -1;
			}
			else if(strtPoint>o.strtPoint)
			{
				return 1;
			}
			return 0;
		}
	}
	
	int position =0;
	static int MIN_POS = 0;
	static int MAX_POS = 100;
	static int DICE_MAX = 6;
	Ladder [] ladderSrtSortedArray ;
	snakes [] snakesSrtSortedArray ;
	
	public void sortLadderStrtPoint(Ladder[] inputArr)
	{
		Arrays.sort(inputArr);
	}
	
	public void sortSnakesStrtPoint(snakes[] snakesSrtSortedArray2)
	{
		Arrays.sort(snakesSrtSortedArray2);
	}
	
	public int computeFinalPosition(int min,int max)
	{
		int maxEndPoint =this.computeLadderInRange(min, max);
		if(maxEndPoint!=-1)
		{
			return maxEndPoint;
		}
		else
		{
			maxEndPoint = computeSnakesInRange(min, max);
			if(maxEndPoint ==-1)
			{
				maxEndPoint = computeSmallestSnake(min, max);
				if(maxEndPoint==-1)
				{
					maxEndPoint = max;
				}
			}
			//compute further for if all snakes are there
		}
		
		return maxEndPoint;
	}
	
	public int computeSnakesInRange(int low,int max)
	{
		for(int i=max;i>=low;i--)
		{
			if(isSnake(i)==-1)
			{
				return i;
			}
		}
		return -1;
	}
    
	public int computeSmallestSnake(int low ,int high)
	{
		int lowPoint = snakeIndex(low,this.snakesSrtSortedArray);
		int highPoint = snakeIndex(high,this.snakesSrtSortedArray);
		if(lowPoint== highPoint )
	    {
	    	return -1;
	    }
	    else if (lowPoint ==-1)
	    {
	    	lowPoint +=1;
	    }
	    
	    int minEndPoint =-1;
	    for(int i=lowPoint;i<= highPoint;i++)
	    {
	    	if(minEndPoint ==-1)
	    	{
	    		minEndPoint = this.ladderSrtSortedArray[lowPoint].endPoint;
	    		
	    	}
	    	else
	    	{
	    		if(minEndPoint>this.ladderSrtSortedArray[i].endPoint)
	    		{
	    			minEndPoint = this.ladderSrtSortedArray[i].endPoint;
	    			
	    		}
	    	}
	    	
	    }
	    return minEndPoint;
	}
	
	public int snakeIndex(int key ,snakes[] a)
	{
		int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid].endPoint) hi = mid - 1;
            else if (key > a[mid].endPoint) lo = mid + 1;
            else return mid;
        }
        return hi;
	}
	
	public int isSnake(int key)
	{
		snakes [] a = this.snakesSrtSortedArray;
		int lo = 0;
        int hi =a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid].strtPoint) hi = mid - 1;
            else if (key > a[mid].strtPoint) lo = mid + 1;
            else return mid;
        }
        return -1;
	}
	
	public int computeLadderInRange(int min,int high)
	{
		int lowPoint = ladderIndex(min,this.ladderSrtSortedArray);
		int highPoint = ladderIndex(high,this.ladderSrtSortedArray);
	    if(lowPoint== highPoint )
	    {
	    	
	    	return -1;
	    }
	    else if (lowPoint ==-1)
	    {
	    	lowPoint +=1;
	    }
	    
	    int maxEndPoint =-1;
	    for(int i=lowPoint;i<= highPoint;i++)
	    {
	    	if(maxEndPoint ==-1)
	    	{
	    		maxEndPoint = this.ladderSrtSortedArray[lowPoint].endPoint;
	    		
	    	}
	    	else
	    	{
	    		if(maxEndPoint<this.ladderSrtSortedArray[i].endPoint)
	    		{
	    			maxEndPoint = this.ladderSrtSortedArray[i].endPoint;
	    			
	    		}
	    	}
	    	
	    }
	    return maxEndPoint;
	}
	
	
	
	public int ladderIndex(int key ,Ladder[] a)
	{
		int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid].strtPoint) hi = mid - 1;
            else if (key > a[mid].strtPoint) lo = mid + 1;
            else return mid;
        }
        return hi;
	}
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Solution1NoGraph obj = new Solution1NoGraph();
		obj.position = Solution1NoGraph.MIN_POS;
		int [] finalResult ;
		try
		{
			Scanner in1 = new Scanner(System.in);
			int noTestCases = in1.nextInt();
			finalResult = new int[noTestCases];
			for(int i=0;i<noTestCases;i++)
			{
				obj.position = Solution1NoGraph.MIN_POS;
				StringBuffer st = new StringBuffer();
				st.append(in1.next());
				int noOfLadders = Integer.parseInt(st.substring(0, st.toString().indexOf(",")));
				int noOfSnakes = Integer.parseInt(st.substring(st.toString().indexOf(",")+1, st.toString().length()));
				obj.ladderSrtSortedArray = new Ladder[noOfLadders];
				obj.snakesSrtSortedArray = new snakes[noOfSnakes];
				in1.nextLine();
				st = new StringBuffer();
				st.append(in1.nextLine());
				for(int k=0;k<st.toString().split(" ").length;k++)
				{
					Ladder lddr= obj . new Ladder();
					String str = st.toString().split(" ")[k];
					int  strt =Integer.parseInt(str.split(",")[0]);
					int  end = Integer.parseInt(str.split(",")[1]);
				
					if(strt<=end)
					{
						lddr.strtPoint = strt;
						lddr.endPoint  = end;
					}
					else
					{
						lddr.strtPoint = end;
						lddr.endPoint  = strt;
					}
					
					obj.ladderSrtSortedArray[k] = lddr;
				}
				
				st = new StringBuffer();
				st.append(in1.nextLine());
				for(int k=0;k<st.toString().split(" ").length;k++)
				{
					snakes snks= obj . new snakes();
					String str = st.toString().split(" ")[k];
					int  strt =Integer.parseInt(str.split(",")[0]);
					int  end = Integer.parseInt(str.split(",")[1]);
					
					if(strt>=end)
					{
						snks.strtPoint = strt;
						snks.endPoint  = end;
					}
					else
					{
						snks.strtPoint = end;
						snks.endPoint  = strt;
					}
					
					obj.snakesSrtSortedArray[k] = snks;
				}
				
				obj.sortLadderStrtPoint(obj.ladderSrtSortedArray);
				obj.sortSnakesStrtPoint(obj.snakesSrtSortedArray);
				int noOfSteps =0;
				boolean reached =true;
				while(reached)
				{
					int min = obj.position+1;
					int max=  obj.position +6;
					obj.position =obj.computeFinalPosition(min, max);
					System.out.println("--------------  "+obj.position);
					if(obj.position>=Solution1NoGraph.MAX_POS)
					{
						noOfSteps++;
						reached = false;
						break;
					}
					noOfSteps++;
					
					
					
				}
				finalResult[i] = noOfSteps;
			}
			for(int i=0;i<finalResult.length;i++)
			{
				System.out.println(finalResult[i]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
