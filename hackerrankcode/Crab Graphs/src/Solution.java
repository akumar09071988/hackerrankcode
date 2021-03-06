import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Solution {

//graph implementation start--------------------------------------------------------------------------
	public class Graph
	{
		int V;
		int E;
		ArrayList<ArrayList<Integer>> adj ;
		
		

		public  Graph(int V)
		{
			this.V =V;
			adj = new ArrayList<ArrayList<Integer>>();
			this.E = 0;
			for(int i=0;i<=V;i++)
			{
				adj.add(new ArrayList<Integer>());
				
			}
			
		}
		
		public void addEdge(int v,int w)
		{
			adj.get(v).add(w);
			adj.get(w).add(v);
			this.E++;
		}

		public int V() {
			return V;
		}

		public int E() {
			return E;
		}

		public void setAdj(ArrayList<ArrayList<Integer>> adj) {
			this.adj = adj;
		}
		
		public String toString() {
	        StringBuilder s = new StringBuilder();
	        String NEWLINE = System.getProperty("line.separator");
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v <= V; v++) {
	            s.append(v + ": ");
	            for (int w : adj.get(v)) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }

		
		
	}
	//graph implementation start end----------------------------------------------------------------------
	
	//instance variables start here ----------------------------------------------------------------------
	
	Graph graph ;
	int [] componentMapping;
	int [] noOfComponents;
	int totalNoNodesCovered=0;
	
	//instance variables end here ----------------------------------------------------------------------
	public static void main(String[] args) 
	{
	    	
		try
		{
			Scanner in1 = new Scanner(System.in);
			int noTestCases = in1.nextInt();
			in1.nextLine();
			for(int i=0;i<noTestCases;i++)
			{
				Solution obj = new Solution();
				StringBuffer st = new StringBuffer();
				st.append(in1.nextLine());
				//obj.sop("next line ", st.toString());
				int noNodes = Integer.parseInt(st.toString().split(" ")[0]);
				//obj.sop("node", noNodes+"");
				int maxFeetCrab = Integer.parseInt(st.toString().split(" ")[1]);
				//obj.sop("feet", maxFeetCrab+"");
				int noEdges = Integer.parseInt(st.toString().split(" ")[2]);
				//obj.sop("edges", noEdges+"");
				obj. graph = obj . new Graph(noNodes);
				obj.totalNoNodesCovered = 0;
				for(int k=0;k<noEdges;k++)
				{
					st = new StringBuffer();
					st.append(in1.nextLine());
					int node1 = Integer.parseInt(st.toString().split(" ")[0]);
					int node2 = Integer.parseInt(st.toString().split(" ")[1]);
					//obj.sop("node 1 2", node1 +" "+node2);
					obj.graph.addEdge(node1, node2);
				}
				
				System.out.println(obj.graph);
				
				TreeMap<Integer,Integer> sortedMap = obj.sortNoOfEdges(obj.graph.adj);
				obj.findCrabs(sortedMap,maxFeetCrab);
				//System.out.println("over "+obj.totalNoNodesCovered);
				
			}
			
		}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	
	
	public void findCrabs(TreeMap<Integer,Integer> sortedMap,int maxFeet)
	{
		//this.sop("in findCrabs","");
		this.componentMapping = new int[this.graph.V+1];
		this.noOfComponents   = new int[this.graph.V+1];
		for(Map.Entry e:sortedMap.entrySet())
		{
			int tempVertex = (Integer)e.getKey();
			this.findCrabFeet(tempVertex);
			this.totalNoNodesCovered = this.totalNoNodesCovered+this.noOfComponents[tempVertex];
			this.sop("node covered ", this.noOfComponents[tempVertex]+" "+tempVertex);
			if(this.totalNoNodesCovered>this.graph.V)
			{
				break;
			}
			//this.sop("node covered ", this.noOfComponents[tempVertex]+"");
		}
		
		processCrabResult(maxFeet);
	}
	
	public void processCrabResult(int maxFeet)
	{
		int maxNoComp = maxFeet+1;
		int compCount=0;
		for(int i=0;i<this.noOfComponents.length;i++)
		{
			//this.sop("" , this.noOfComponents[i]+"");
			if(this.noOfComponents[i]>maxNoComp)
			{
				compCount= compCount+maxNoComp;
			}
			else
			{
				compCount= compCount+this.noOfComponents[i];
			}
		}
		
		System.out.println(compCount);
	}
	
	public void findCrabFeet(int vertex)
	{
		//this.sop("vertex", vertex+"");
		ArrayList<Integer> temp = this.graph.adj.get(vertex);
		int tempComp =0;
		for(int i=0;i<temp.size();i++)
		{
			int tempInt = temp.get(i);
			if(this.componentMapping[tempInt]!=0)
			{
			/*	int tempNo = this.componentMapping[tempInt];
				this.noOfComponents[tempNo] -=1;
				this.componentMapping[tempInt] = vertex;
				this.totalNoNodesCovered-=1;*/
			}
			else
			{
				this.componentMapping[tempInt] = vertex;	
				this.noOfComponents[vertex] +=1;
				//this.sop("node count ", this.noOfComponents[vertex]+" "+tempInt);
				tempComp++;
			}
			
		}
		if(tempComp!=0)
		{
			if(this.componentMapping[vertex]!=0)
			{
				int tempInt = this.componentMapping[vertex];
				this.noOfComponents[tempInt]-=1;
				this.componentMapping[vertex] = vertex;
				this.totalNoNodesCovered-=1;
			}
			else
			{
				this.componentMapping[vertex] = vertex;
				
			}
			this.noOfComponents[vertex] = this.noOfComponents[vertex]+1;			
		}
	}
	
	public TreeMap<Integer,Integer> sortNoOfEdges(ArrayList<ArrayList<Integer>> list )
	{
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
        for(int i=0;i<this.graph.V();i++)
        {
        	map.put(i, list.get(i).size());
        }
        ValueComparator bvc =  this. new ValueComparator(map);
        TreeMap<Integer,Integer> sorted_map = new TreeMap<Integer,Integer>(bvc);
		
        sorted_map.putAll(map);
		return sorted_map;
	}
	
	 class ValueComparator implements Comparator<Integer> {

	    Map<Integer, Integer> base;
	    public ValueComparator(Map<Integer, Integer> base) {
	        this.base = base;
	    }
		@Override
		public int compare(Integer o1, Integer o2) {
			if (base.get(o1) >= base.get(o2)) {
	            return -1;
	        } else {
	            return 1;
	        } 
		}
	}
	
	public void sop(String comments,String val)
	{
		System.out.println(comments+" -------- "+val);
	}

}
