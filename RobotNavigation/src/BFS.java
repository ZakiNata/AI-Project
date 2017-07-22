
public class BFS {

	private static NodeQueue[] queue;
	//private Node[] fringe;
	
	public static boolean performBFS(SearchSpace space,Node[] path)
	{
		insertStartNode(space);
		return true;
	}
	
	private static Node[] calculateNext(SearchSpace space)
	{
		Node[] next = null;
		
		return next;
	}
	
	private static void insertStartNode(SearchSpace space)
	{
		for(int i=0; i < space.getRows(); i++)
			for(int j=0; j < space.getColumns(); j++)
				 if(space.getSpace()[i][j].getStatus().equals(NodeStatus.Start))
				 {
					 NodeQueue node = new NodeQueue(space.getSpace()[i][j],i,j,0);
					 queue = new NodeQueue[space.getspaceSize()];
					 queue[0] = node;
					 return;
				 }
	}
}
