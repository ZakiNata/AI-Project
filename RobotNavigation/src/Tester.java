
public class Tester {
	
	public static void main(String args[])
	{
		SearchSpace s = new SearchSpace(5,5);
		s.generate();
		System.out.println(s.toString());
		
		boolean solved = BFS.performBFS(s, null,100);
		System.out.println(solved);
	}
}
