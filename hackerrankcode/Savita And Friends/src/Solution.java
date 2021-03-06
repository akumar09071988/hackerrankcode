import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution {

	class Edge implements Comparable<Edge>
	{
		 private final int v;
		 private final int w;
		 private final double weight;
		 
		 public Edge(int v, int w, double weight) {
		        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
		        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
		        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		        this.v = v;
		        this.w = w;
		        this.weight = weight;
		    }
		 public double weight() {
		        return weight;
		    }
		 public int either() {
		        return v;
		    }
		 public int other(int vertex) {
		        if      (vertex == v) return w;
		        else if (vertex == w) return v;
		        else throw new IllegalArgumentException("Illegal endpoint");
		    }
		 public int compareTo(Edge that) {
		        if      (this.weight() < that.weight()) return -1;
		        else if (this.weight() > that.weight()) return +1;
		        else                                    return  0;
		    }
		 public String toString() {
		        return String.format("%d-%d %.5f", v, w, weight);
		    }

	}
	
    class EdgeWeightedGraph
    {
    	private  int V;
        private int E;
        private ArrayList<ArrayList<Edge>> adj;
        
        public EdgeWeightedGraph(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
            this.V = V;
            this.E = 0;
            adj = new ArrayList<ArrayList<Edge>>();
            for(int i=0;i<=V;i++)
			{
				adj.add(new ArrayList<Edge>());
				
			}
            System.out.println("adj.size() "+adj.size());
        }
       
        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public void addEdge(Edge e) {
            int v = e.either();
            int w = e.other(v);
            if (v < 0 || v > V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
            if (w < 0 || w > V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1));
            adj.get(v).add(e);
            adj.get(w).add(e);
            E++;
        }
        
        public Iterable<Edge> edges() {
        	ArrayList<Edge> list = new ArrayList<Edge>();
            for (int v = 0; v < V; v++) {
                int selfLoops = 0;
                for (Edge e : adj.get(v)) {
                    if (e.other(v) > v) {
                        list.add(e);
                    }
                    // only add one copy of each self loop (self loops will be consecutive)
                    else if (e.other(v) == v) {
                        if (selfLoops % 2 == 0) list.add(e);
                        selfLoops++;
                    }
                }
            }
            return list;
        } 

    }
    
    class KruskalMST
    {
    	 ArrayList<Edge> mst = new ArrayList<Edge>();
    	 boolean [] marked ;
    	 
    	 
    	 public KruskalMST(EdgeWeightedGraph G) {
    	        // more efficient to build heap by passing array of edges
    		    marked = new boolean[G.V+1];
    	        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    	        for (Edge e : G.edges()) {
    	            pq.add(e);
    	        }

    	        // run greedy algorithm
    	        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
    	            Edge e = pq.remove();
    	            int v = e.either();
    	            int w = e.other(v);
    	            if(marked[v] && marked[w]) continue;
    	            marked[w]=true;
    	            marked[v]=true;
    	            mst.add(e);  // add edge e to mst
    	        }

    	    }

    }
    
	public static void main(String[] args) {
		Solution obj = new Solution();
		try
		{
			Scanner in1 = new Scanner(System.in);
			int noTestCases = in1.nextInt();
			int[] resultArray = new int[noTestCases];
			in1.nextLine();
			for(int i=0;i<noTestCases;i++)
			{
				String s1 = in1.nextLine();
				System.out.println(s1);
				int N = Integer.parseInt(s1.split(" ")[0]);
				int M = Integer.parseInt(s1.split(" ")[1]);
				int K = Integer.parseInt(s1.split(" ")[2]);
				EdgeWeightedGraph g= obj.new EdgeWeightedGraph(N);
				for(int k=0;k<M;k++)
				{
					String s2 = in1.nextLine();
					System.out.println(s2);
					int v =Integer.parseInt(s2.split(" ")[0]);
					int w = Integer.parseInt(s2.split(" ")[1]);
					double weight = Float.parseFloat(s2.split(" ")[2]);
					Edge e= obj.new Edge(v, w, weight);
					g.addEdge(e);
				}
				KruskalMST kruskalMST  = obj.new KruskalMST(g);
				for(int l=0;l<kruskalMST.mst.size();l++)
				{
					Edge edge = kruskalMST.mst.get(l);
					System.out.println("--    "+edge);
				}
				System.out.println("--------------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
