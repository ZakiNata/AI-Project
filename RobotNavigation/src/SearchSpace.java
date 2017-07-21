
public class SearchSpace {
	
	private Node[][] space;
	private int spaceSize;
	private int rows;
	private int columns;

	public SearchSpace(int rows,int columns)
	{
		space = new Node[rows][columns];
		spaceSize = rows*columns;
		this.rows = rows ;
		this.columns = columns;
		
		for(int i=0; i < rows; i++)
			for(int j=0; j < columns; j++)
				 space[i][j] = new Node(NodeStatus.Allowed);
	
	}
	public Node[][] getSpace() {
		return space;
	}
	
	public void generate(SearchSpace space)
	{
		int row,column;
		

		do{
			row = (int)Math.random()*(space.getRows()-1);
			column = (int)Math.random()*(space.getColumns()-1);
		}while(!space.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
		
		space.setNodestatus(space, row, column, NodeStatus.Start);
		
		do{
			row = (int)Math.random()*(space.getRows()-1);
			column = (int)Math.random()*(space.getColumns()-1);
		}while(!space.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
		
		space.setNodestatus(space, row, column, NodeStatus.Goal);
		
		int restrictedNumber = (int)(space.getspaceSize()*0.3) ; 
		while(restrictedNumber != 0)
		{
			do{
				row = (int)Math.random()*(space.getRows()-1);
				column = (int)Math.random()*(space.getColumns()-1);
			}while(!space.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
			
			space.setNodestatus(space, row, column, NodeStatus.Restricted);
			
			restrictedNumber--;
		}
	}

	public void setNodestatus(SearchSpace space,int row,int column, NodeStatus status)
	{
		space.getSpace()[row][column].setStatus(status);
	}
	
	public int getspaceSize() {
		return spaceSize;
	}

	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	
	
}
