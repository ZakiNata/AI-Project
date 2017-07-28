
public class BFS {

	private static NodeQueue[] queue;
	private static NodeQueue[] fringe;
	
	public static int performBFS(SearchSpace space,int[][] path,int iterations)
	{
		insertStartNode(space);
		fringe = new NodeQueue[space.getspaceSize()];
		
		//review this later
		if(iterations > space.getspaceSize())
			iterations = space.getspaceSize();
		
		for(int i=0;i<iterations;i++)
		{
			fringe[i] = getNodeFromQueue(queue);
			if(fringe[i]==null)
				return -1;
			if(fringe[i].getNode().getStatus().equals(NodeStatus.Goal))
			{
				System.out.println(fringe[i].getRow()+" "+fringe[i].getColumn());
				//fill path
				calculatePath(path);
				return (i+1);
			}
			CalculateNext(space,fringe[i]);
		}
		return -1;
	}
	
	private static void calculatePath(int[][] path) {
		// TODO Auto-generated method stub

		int pathRow = 0;
		for(int i=fringe.length-1;i>=0;i--)
		{
			if(fringe[i]==null)
				continue;
			else
			{
				path[pathRow][0] = fringe[i].getRow();
				path[pathRow][1] = fringe[i].getColumn();
				
				NodeQueue temp = fringe[i].getParentNode();
				int place = findNodeQueuePlace(temp);
				i = place+1;		
				pathRow++;
			}
		}
		
	}

	private static int findNodeQueuePlace(NodeQueue temp) {
		if(temp == null)
			return -1;
		for(int i=0;i<fringe.length;i++)
		{
			if(fringe[i].getRow() == temp.getRow() && fringe[i].getColumn() == temp.getColumn())
				return i;
		}
		return -1;
	}

	private static void CalculateNext(SearchSpace space, NodeQueue fringe) {
		
		int row = fringe.getRow();
		int column = fringe.getColumn();
		
		if((row-1)>=0 && (column-1)>=0)
		{
			Node temp = space.getSpace()[row-1][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column-1))
			{
				QueueAdd(temp,row-1,column-1,fringe);
			}
		}
		
		if((row-1)>=0)
		{
			Node temp = space.getSpace()[row-1][column];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column))
			{
				QueueAdd(temp,row-1,column,fringe);
			}
		}
		
		if((row-1)>=0 && (column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row-1][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column+1))
			{
				QueueAdd(temp,row-1,column+1,fringe);
			}
		}
		
		if((column-1)>=0)
		{
			Node temp = space.getSpace()[row][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row,column-1))
			{
				QueueAdd(temp,row,column-1,fringe);
			}
		}
		
		if((column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row,column+1))
			{
				QueueAdd(temp,row,column+1,fringe);
			}
		}
		
		if((row+1)<(space.getRows()) && (column-1)>=0)
		{
			Node temp = space.getSpace()[row+1][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column-1))
			{
				QueueAdd(temp,row+1,column-1,fringe);
			}
		}
		
		if((row+1)<(space.getRows()))
		{
			Node temp = space.getSpace()[row+1][column];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column))
			{
				QueueAdd(temp,row+1,column,fringe);
			}
		}
		
		if((row+1)<(space.getRows()) && (column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row+1][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column+1))
			{
				QueueAdd(temp,row+1,column+1,fringe);
			}
		}
	}

	private static void QueueAdd(Node temp, int row, int column,NodeQueue parent) {
		
		if(!foundinQueue(row,column))
		{
			for(int i=0; i<queue.length;i++)
				if(queue[i]==null) 
				{
					queue[i]= new NodeQueue(temp,row,column,0,parent);
					return;
				}
		}
	}

	private static boolean foundinQueue(int row, int column) {
		for(int i=0; i<queue.length;i++)
		{
			if(queue[i]==null) 
				return false;
			else if(queue[i].getRow()==row && queue[i].getColumn() == column)
				return true;
		}
		return false;
	}

	private static boolean FringeContains(int i, int j) {
	
		for(int z=0; z<fringe.length;z++)
			if(fringe[z]!=null && fringe[z].getRow()==i && fringe[z].getColumn()==j)
				return true;
		return false;
	}


	private static NodeQueue getNodeFromQueue(NodeQueue[] queue) {
		
		if(queue[0]==null)
			return null;
		
		NodeQueue temp = queue[0];
		
		for(int j=0;j<queue.length-1;j++)
			queue[j]=queue[j+1];
		
		queue[queue.length-1]=null;
		
		return  temp;
	}

	private static void insertStartNode(SearchSpace space)
	{
		for(int i=0; i < space.getRows(); i++)
			for(int j=0; j < space.getColumns(); j++)
				 if(space.getSpace()[i][j].getStatus().equals(NodeStatus.Start))
				 {
					 NodeQueue node = new NodeQueue(space.getSpace()[i][j],i,j,0,null);
					 queue = new NodeQueue[space.getspaceSize()];
					 queue[0] = node;
					 return;
				 }
	}
}
