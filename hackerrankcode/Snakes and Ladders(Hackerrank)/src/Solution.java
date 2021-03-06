import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class Solution {
	
	static int MIN_POS = 1;
	static int MAX_POS = 100;
	static int MAX_DICE=6;
	static int MIN_DICE=1;
	int position =0;
	
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
			this.E++;
		}
		
	
		
		
	}
	
	public class BFS
	{
		boolean[]  marked;
		int []     edgeTo;
		int S;
		
		public  BFS(Graph graph,int s)
		{
			marked = new boolean[graph.V+1];
			edgeTo = new int[graph.V+1];
			this.S=s;
			bfs(graph,s);
		}
		
		private void bfs(Graph G, int s)
		{
	    Queue<Integer> queue = new LinkedList<>();;
		marked[s] = true; // Mark the source
		queue.add(s); // and put it on the queue.
		while (!queue.isEmpty())
		{
		int v = queue.remove(); // Remove next vertex from the queue.
		for (int w : G.adj.get(v))
		if (!marked[w]) // For every unmarked adjacent vertex,
		{
		edgeTo[w] = v; // save last edge on a shortest path,
		marked[w] = true; // mark it because path is known,
		queue.add(w); // and add it to the queue.
		if(w==Solution.MAX_POS)
		{
			break;
		}
		}
		}
		}
	}
	
	public void makeBoardNoLddrSnk(Graph g)
	{
		int upperLimit = Solution.MAX_POS;
		for(int i=Solution.MIN_POS;i<upperLimit;i++)
		{
			for(int k=Solution.MIN_DICE;k<=Solution.MAX_DICE && (i+k)<=Solution.MAX_POS;k++)
			{
				
				g.addEdge(i, i+k);
			}
			
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Solution obj = new Solution();
		obj.position = Solution.MIN_POS;
		try
		{
			Scanner in1 = new Scanner(System.in);
			int noTestCases = in1.nextInt();
			for(int i=0;i<noTestCases;i++)
			{
				Graph graph = obj. new Graph(Solution.MAX_POS);
				StringBuffer st = new StringBuffer();
				st.append(in1.next());
				int noOfLadders = Integer.parseInt(st.substring(0, st.toString().indexOf(",")));
				int noOfSnakes = Integer.parseInt(st.substring(st.toString().indexOf(",")+1, st.toString().length()));
				in1.nextLine();
				st = new StringBuffer();
				st.append(in1.nextLine());
				for(int k=0;k<st.toString().split(" ").length;k++)
				{
					String str = st.toString().split(" ")[k];
					int  strt =Integer.parseInt(str.split(",")[0]);
					int  end = Integer.parseInt(str.split(",")[1]);
					if(strt<=end)
					{
					    graph.addEdge(strt, end);
					}
					else
					{
						graph.addEdge(end,strt);
					}
				}
				
				st = new StringBuffer();
				st.append(in1.nextLine());
				for(int k=0;k<st.toString().split(" ").length;k++)
				{
					String str = st.toString().split(" ")[k];
					int  strt =Integer.parseInt(str.split(",")[0]);
					int  end = Integer.parseInt(str.split(",")[1]);
					
					if(strt>=end)
					{
						graph.addEdge(strt, end);
					}
					else
					{
						graph.addEdge( end,strt);
					}
					
				}
				obj.makeBoardNoLddrSnk(graph);  // make borad without snakes and ladders
				BFS bfs = obj.new BFS(graph, Solution.MIN_POS);
				int noOfSteps =0;
				int target=Solution.MAX_POS;
				while(target>Solution.MIN_POS)
				{
					if(target-bfs.edgeTo[target]<=6)
					{
						noOfSteps++;
					}
					 target = bfs.edgeTo[target];
				}
				System.out.println(noOfSteps);
				
				
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	}

}
