
public class Tester {
	
	public static void main(String args[])
	{
		SearchSpace s = new SearchSpace(5,5);
		s.generate();
		System.out.println(s.toString());
	}
}
