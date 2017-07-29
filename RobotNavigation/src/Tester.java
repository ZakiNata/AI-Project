
public class Tester {
	
	public static void main(String args[])
	{
		
		
//		SearchSpace s = new SearchSpace(10,10);
//		s.generate();
//		System.out.println(s.toString());
//		
//		int rows = s.getspaceSize();
//		int[][] path = new int[rows][2];
//		for(int i=0;i<path.length;i++)
//			for(int j=0;j<path[0].length;j++)
//				path[i][j] = -1;
//		
//		System.out.println("========== BFS ===========");
//		int solved = BFS.performBFS(s, path,1000000);
//		if(solved == -1)
//			System.out.println("Not solved");
//		else
//			System.out.println("Solved in "+solved+" iterations");
//		
//		System.out.println("Path:");
//		for(int i=path.length-1;i>=0;i--)
//		{
//			if(path[i][0]==-1)
//				continue;
//			else
//				System.out.println("("+path[i][0]+","+path[i][1]+")");
//		}
//		
//		System.out.println("\n\n========== DFS ===========");
//		for(int i=0;i<path.length;i++)
//			for(int j=0;j<path[0].length;j++)
//				path[i][j] = -1;
//		
//		solved = DFS.performDFS(s, path,1000000);
//		if(solved == -1)
//			System.out.println("Not solved");
//		else
//			System.out.println("Solved in "+solved+" iterations");
//		
//		System.out.println("Path:");
//		for(int i=path.length-1;i>=0;i--)
//		{
//			if(path[i][0]==-1)
//				continue;
//			else
//				System.out.println("("+path[i][0]+","+path[i][1]+")");
//		}
//		
//		System.out.println("\n\n========== A* ===========");
//		for(int i=0;i<path.length;i++)
//			for(int j=0;j<path[0].length;j++)
//				path[i][j] = -1;
//		
//		solved = AStar.performAStar(s, path,1000000);
//		if(solved == -1)
//			System.out.println("Not solved");
//		else
//			System.out.println("Solved in "+solved+" iterations");
//		
//		System.out.println("Path:");
//		for(int i=path.length-1;i>=0;i--)
//		{
//			if(path[i][0]==-1)
//				continue;
//			else
//				System.out.println("("+path[i][0]+","+path[i][1]+")");
//		}
//		
//		System.out.println("\n\n========== Heuristic ===========");
//		for(int i=0;i<path.length;i++)
//			for(int j=0;j<path[0].length;j++)
//				path[i][j] = -1;
//		
//		solved = HeursticDistanceToGoal.performHeursticDistanceToGoal(s, path,1000000);
//		if(solved == -1)
//			System.out.println("Not solved");
//		else
//			System.out.println("Solved in "+solved+" iterations");
//		
//		System.out.println("Path:");
//		for(int i=path.length-1;i>=0;i--)
//		{
//			if(path[i][0]==-1)
//				continue;
//			else
//				System.out.println("("+path[i][0]+","+path[i][1]+")");
//		}
		
		
		//SearchSpace s = new SearchSpace(10,10);
		//s.generate();
		//System.out.println(s.toString());
		int rows = 10000;
		int[][] pathB = new int[rows][2];
		int[][] pathD = new int[rows][2];
		int[][] pathA = new int[rows][2];
		int[][] pathH = new int[rows][2];
		
		for(int i=0;i<pathB.length;i++)
			for(int j=0;j<pathB[0].length;j++)
			{
				pathB[i][j] = -1;
				pathD[i][j] = -1;
				pathA[i][j] = -1;
				pathH[i][j] = -1;
			}
		
		int solvedBFS = 0;
		int solvedDFS = 0;
		int solvedAstar = 0;
		int solvedHs = 0;
		int iterations = 1000;
		int countB=0;
		int countD=0;
		int countA=0;
		int countH=0;
		
		int countpB=0;
		int countpD=0;
		int countpA=0;
		int countpH=0;
		
		for(int i=0;i<100;i++)
		{
			SearchSpace s = new SearchSpace(30,10);
			s.generate();
			solvedBFS = BFS.performBFS(s, pathB, iterations);
			solvedDFS = DFS.performDFS(s, pathD, iterations);
			solvedAstar = AStar.performAStar(s, pathA, iterations);
			solvedHs = HeursticDistanceToGoal.performHeursticDistanceToGoal(s, pathH,iterations);
			
			if(solvedBFS!=-1)
			{
				countB++;
				countpB += countPath(pathB);
			}
			if(solvedDFS!=-1)
			{
				countD++;
				countpD += countPath(pathD);
			}
			if(solvedAstar!=-1)
			{
				countA++;
				countpA += countPath(pathA);
			}
			if(solvedHs!=-1)
			{
				countH++;
				countpH += countPath(pathH);
			}
			
			
			//System.out.println("i:"+i);
		}
		
		System.out.println("BFS Sovled: "+countB+" Avg. steps : "+(countpB/100));
		System.out.println("DFS Sovled: "+countD+" Avg. steps : "+(countpD/100));
		System.out.println("A*  Sovled: "+countA+" Avg. steps : "+(countpA/100));
		System.out.println("Hs  Sovled: "+countH+" Avg. steps : "+(countpH/100));
	}

	private static int countPath(int[][] path) {
		int count = 0;
		for(int i=path.length-1;i>=0;i--)
		{
			if(path[i][0]==-1)
				continue;
			else
				count++;
		}
		return count;
	}
}
