
public class AStar {

	private static NodeQueue[] queue;
	private static NodeQueue[] fringe;
	
	public static int performAStar(SearchSpace space,int[][] path,int iterations)
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
//			
//			//debug
//			if(fringe[i].getRow()==6 && fringe[i].getColumn()==3)
//			{
//				System.out.print("");
//			}
			
			if(fringe[i].getNode().getStatus().equals(NodeStatus.Goal))
			{
				//System.out.println(fringe[i].getRow()+" "+fringe[i].getColumn());
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
		double horizontalPrice = 1+fringe.getPrice();
		double diagonalPrice = 1.4+fringe.getPrice();
		
		if((row-1)>=0 && (column-1)>=0)
		{
			Node temp = space.getSpace()[row-1][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column-1,diagonalPrice))
			{
				QueueAdd(temp,row-1,column-1,fringe,diagonalPrice);
			}
		}
		
		if((row-1)>=0)
		{
			Node temp = space.getSpace()[row-1][column];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column,horizontalPrice))
			{
				QueueAdd(temp,row-1,column,fringe,horizontalPrice);
			}
		}
		
		if((row-1)>=0 && (column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row-1][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row-1,column+1,diagonalPrice))
			{
				QueueAdd(temp,row-1,column+1,fringe,diagonalPrice);
			}
		}
		
		if((column-1)>=0)
		{
			Node temp = space.getSpace()[row][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row,column-1,horizontalPrice))
			{
				QueueAdd(temp,row,column-1,fringe,horizontalPrice);
			}
		}
		
		if((column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row,column+1,horizontalPrice))
			{
				QueueAdd(temp,row,column+1,fringe,horizontalPrice);
			}
		}
		
		if((row+1)<(space.getRows()) && (column-1)>=0)
		{
			Node temp = space.getSpace()[row+1][column-1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column-1,diagonalPrice))
			{
				QueueAdd(temp,row+1,column-1,fringe,diagonalPrice);
			}
		}
		
		if((row+1)<(space.getRows()))
		{
			Node temp = space.getSpace()[row+1][column];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column,horizontalPrice))
			{
				QueueAdd(temp,row+1,column,fringe,horizontalPrice);
			}
		}
		
		if((row+1)<(space.getRows()) && (column+1)<(space.getColumns()))
		{
			Node temp = space.getSpace()[row+1][column+1];
			if(!temp.getStatus().equals(NodeStatus.Restricted) && !FringeContains(row+1,column+1,diagonalPrice))
			{
				QueueAdd(temp,row+1,column+1,fringe,diagonalPrice);
			}
		}
	}

	private static void QueueAdd(Node temp, int row, int column,NodeQueue parent,double price) {
		
		if(!foundinQueue(row,column))
		{
			for(int i=0; i<queue.length;i++)
			{
				if(queue[i]==null) 
				{
					queue[i]= new NodeQueue(temp,row,column,price,parent);
					return;
				}
				else if(queue[i].getPrice()>price)
				{
					for(int j=queue.length-1;j>i;j--)
						queue[j]=queue[j-1];
					queue[i]= new NodeQueue(temp,row,column,price,parent);
					return;
				}
			}
		}
		int place;
		if((place=foundinQueuewHigherPrice(row,column,price)) != -1)
		{
			for(int j=queue.length-1;j>=place;j--)
				queue[j]=queue[j-1];
			QueueAdd(temp,row,column,parent,price);
		}
	}

	private static int foundinQueuewHigherPrice(int row, int column, double price) {
		for(int i=0; i<queue.length;i++)
		{
			if(queue[i]==null) 
				return -1;
			else if(queue[i].getRow()==row && queue[i].getColumn() == column && queue[i].getPrice() > (price+0.001))
				return i;
		}
		return -1;
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

	private static boolean FringeContains(int i, int j, double price) {
	
		for(int z=0; z<fringe.length;z++)
			if(fringe[z]!=null && fringe[z].getRow()==i && fringe[z].getColumn()==j)// && fringe[z].getPrice() > price)
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
