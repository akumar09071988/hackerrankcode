import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

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
	    
	    public int[] getId() {
			return id;
		}

		public void setId(int[] id) {
			this.id = id;
		}

	}
    
	Graph mainGraph = null;
	
	public static void main(String[] args) {
		
		int totalWays =0;
		Solution obj = new Solution();
		try
		{
			Scanner in1 = new Scanner(System.in);
			StringBuffer st = new StringBuffer(in1.nextLine());
			int N = Integer.parseInt(st.toString().split(" ")[0]);
			int E = Integer.parseInt(st.toString().split(" ")[1]);
			obj.mainGraph = obj . new Graph(N);
			for(int i=0;i<E;i++)
			{
				st = new StringBuffer(in1.nextLine());
				int N1 = Integer.parseInt(st.toString().split(" ")[0]);
				int N2 = Integer.parseInt(st.toString().split(" ")[1]);
				//System.out.println(N1+"  "+N2);
				obj.mainGraph.addEdge(N1, N2);
			}
			
			CC cc = obj .new CC(obj.mainGraph);
		    //System.out.println(cc.count());
		    int negPart =0;
		    for(int i=0;i<cc.count();i++)
		    {
		    	int prefex = cc.size[i];;
		    	
		    	
		    	totalWays = totalWays+prefex *(obj.mainGraph.V-cc.size[i]-negPart);
		    	negPart=negPart+cc.size[i];
		    }
		    System.out.println(totalWays);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
