
public class Tester {
	
	public static void main(String args[])
	{
		SearchSpace s = new SearchSpace(100,100);
		s.generate();
		System.out.println(s.toString());
		
		int solved = BFS.performBFS(s, null,1000000);
		if(solved == -1)
			System.out.println("Not solved");
		else
			System.out.println("Solved in "+solved+" iterations");
	}
}
