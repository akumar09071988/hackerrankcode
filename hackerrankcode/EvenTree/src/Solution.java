import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Solution {

	/**
	 * @param args
	 */
    boolean[] checkedVertex ;
	
	class Graph
	{
		private final int V;
	    private int E;
	    private ArrayList<ArrayList<Integer>> adj;
	    
	    public Graph(Scanner in) 
	    {
	        this(in.nextInt());
	        int E = in.nextInt();
	        //System.out.println("E "+E);
	        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
	        for (int i = 0; i <= E; i++) {
	        	String nxtLine = in.nextLine();
	        	//System.out.println(nxtLine+" "+i);
	        	//System.out.println(nxtLine.split(" ").length);
	        	if(!nxtLine.equalsIgnoreCase(" ") && !nxtLine.equalsIgnoreCase(null) && !nxtLine.isEmpty())
	        	{
	        		//System.out.println("nxtLine "+nxtLine);
	        		int v = Integer.parseInt(nxtLine.split(" ")[0].trim());
	 	            int w = Integer.parseInt(nxtLine.split(" ")[1]);;
	 	            addEdge(v-1, w-1);
	        	}
	            
	        }
	    }
	    
	    public Graph(Graph G) {
	        this(G.V());
	        this.E = G.E();
	        System.out.println("contructor "+E);
	        for (int v = 0; v < G.V(); v++) {
	            // reverse so that adjacency list is in same order as original
	            ArrayList<Integer> reverse = new ArrayList<Integer>();
	            for (int w : G.adj.get(v)) {
	                reverse.add(w);
	            }
	            for (int w : reverse) {
	                adj.get(v).add(w);
	            }
	        }
	    }
	    
	    public int V() {
	        return V;
	    }
	    
	    public int E() {
	        return E;
	    }
	    
	    public ArrayList<Integer> adj(int v) {
	        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
	        return adj.get(v);
	    }
	    
	    public void addEdge(int v, int w) {
	    	//System.out.println(v +" "+w);
	        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
	        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
	        adj.get(v).add(w);
	        adj.get(w).add(v);
	    }
	    
	    public void removeEdge(int v , int w)
	    {
	    	if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
	        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
	        adj.get(v).remove((Integer)w);
	        adj.get(w).remove((Integer)v);
	    }
	    
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        String NEWLINE = System.getProperty("line.separator");
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj.get(v)) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	    
	    public Graph(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        //System.out.println("V "+V);
	        adj = new ArrayList<ArrayList<Integer>>();
	        for (int v = 0; v < V; v++) {
	            adj.add(new ArrayList<Integer>());
	        }
	        
	    
	    }
	    
	   public ArrayList<ArrayList<Integer>> getAdj()
	   {
		   return adj;
	   }
	 }
	
	class CC
    {
    	    private boolean[] marked;   
    	    private int[] id;           
    	    private int[] size;         
    	    private int count;          
            
    	    public CC(Graph G) {
    	        marked = new boolean[G.V()];
    	        id = new int[G.V()];
    	        size = new int[G.V()];
    	        for (int v = 0; v < G.V(); v++) {
    	            if (!marked[v]) {
    	                dfs(G, v);
    	                count++;
    	            }
    	        }
    	    }
    	    
    	    private void dfs(Graph G, int v) {
    	        marked[v] = true;
    	        id[v] = count;
    	        size[count]++;
    	        for (int w : G.adj(v)) {
    	            if (!marked[w]) {
    	                dfs(G, w);
    	            }
    	        }
    	    }
    	    
    	    public int id(int v) {
    	        return id[v];
    	    }
    	    
    	    public int size(int v) {
    	        return size[id[v]];
    	    }
    	    
    	    public int count() {
    	        return count;
    	    }
    }
    
	
	Graph mainGraph = null;
	int noRemoveEdges=0;
	public static void main(String[] args) {
		Solution obj = new Solution();
		try
		{
			Scanner in1 = new Scanner(System.in);
	        obj.mainGraph = obj.new Graph(in1);
	        obj.checkedVertex = new boolean[obj.mainGraph.V()];
	        TreeMap<Integer,Integer> sortedMap = obj.sortNoOfEdges(obj.mainGraph.getAdj());
	        //System.out.println(sortedMap);
	        for(Map.Entry e:sortedMap.entrySet())
	        {
	        	//System.out.println(e.getKey()+"  "+e.getValue());
	        	if((Integer)e.getValue()<2)
	        	{
	        		obj.checkedVertex[(Integer)e.getKey()] =true;
	        		
	        	}
	        	else
	        	{//System.out.println("in else");
	        		int lastSlot=0;
	        		ArrayList<Integer> list1 = obj.mainGraph.getAdj().get((Integer)e.getKey());
	        		for(int i =0;i<list1.size()-lastSlot;i++)
	        		{//System.out.println("in for"+list1.size());
	        			int index = list1.get(i);//System.out.println(index);
	        			if(obj.mainGraph.getAdj().get(index).size()<2)
	        			{//System.out.println("in less 2");
	        				obj.checkedVertex[index]=true;
	        			}
	        			if(obj.checkedVertex[index])
	        			{//System.out.println("in continue");
	        				continue;
	        			}
	        			else
	        			{//System.out.println("rocess");
	        				
	        				obj.mainGraph.removeEdge(index, (Integer)e.getKey());
	        				
	        				i=i-1;
	        				//System.out.println(obj.mainGraph.toString());
	        				CC cc = obj . new CC(obj.mainGraph);
	        				if(obj.countNodeComponenets(cc.count, cc.size))
	        				{
	        					
	        					obj.noRemoveEdges++;
	        				}
	        				else
	        				{
	        					lastSlot++;
	        					obj.mainGraph.addEdge(index, (Integer)e.getKey());
	        				}
	        				//System.out.println(" i ki value "+i);
	        				//System.out.println(obj.mainGraph.toString());
	        			}
	        			
	        		}
	        		obj.checkedVertex[(Integer)e.getKey()] =true;
	        		//break;
	        	}
	        	//break;
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(obj.noRemoveEdges);
	}
	
	public boolean  countNodeComponenets(int count,int[] sizeArray)
	{
		for(int i=0;i<= count;i++)
		{//System.out.println(sizeArray[i]%2);
			if(sizeArray[i]%2!=0)
			{
				return false;
			}
		}
		return true;
	}
	
	public TreeMap<Integer,Integer> sortNoOfEdges(ArrayList<ArrayList<Integer>> list )
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
        for(int i=0;i<this.mainGraph.V();i++)
        {
        	//System.out.println(list.get(i).size());
        	map.put(i, list.get(i).size());
        	//System.out.println("- "+map.get(i));
        }
        //System.out.println(map);
        ValueComparator bvc =  this. new ValueComparator(map);
        TreeMap<Integer,Integer> sorted_map = new TreeMap<Integer,Integer>(bvc);
		
        sorted_map.putAll(map);
        //System.out.println(sorted_map);
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
}
