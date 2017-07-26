
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
	
	public void generate()
	{	
		int row,column;
		

		do{
			row = (int)(Math.random()*(this.getRows()-1));
			column = (int)(Math.random()*(this.getColumns()-1));
		}while(!this.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
		
		this.setNodestatus(this, row, column, NodeStatus.Start);
		
		do{
			row = (int)(Math.random()*(this.getRows()-1));
			column = (int)(Math.random()*(this.getColumns()-1));
		}while(!this.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
		
		this.setNodestatus(this, row, column, NodeStatus.Goal);
		
		int restrictedNumber = (int)(this.getspaceSize()*0.3) ; 
		while(restrictedNumber != 0)
		{
			do{
				row = (int)(Math.random()*(this.getRows()-1));
				column = (int)(Math.random()*(this.getColumns()-1));
			}while(!this.getSpace()[row][column].getStatus().equals(NodeStatus.Allowed));
			
			this.setNodestatus(this, row, column, NodeStatus.Restricted);
			
			restrictedNumber--;
		}
		
		/**
		this.setNodestatus(this, 0, 0, NodeStatus.Restricted);
		this.setNodestatus(this, 0, 1, NodeStatus.Restricted);
		this.setNodestatus(this, 0, 2, NodeStatus.Restricted);
		this.setNodestatus(this, 0, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 0, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 0, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 0, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 0, 7, NodeStatus.Restricted);
		this.setNodestatus(this, 0, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 0, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 1, 0, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 1, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 5, NodeStatus.Restricted);
		this.setNodestatus(this, 1, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 7, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 1, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 2, 0, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 1, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 2, 3, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 2, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 2, 6, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 7, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 8, NodeStatus.Restricted);
		this.setNodestatus(this, 2, 9, NodeStatus.Allowed);
	
		this.setNodestatus(this, 3, 0, NodeStatus.Restricted);
		this.setNodestatus(this, 3, 1, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 7, NodeStatus.Allowed);
		this.setNodestatus(this, 3, 8, NodeStatus.Start);
		this.setNodestatus(this, 3, 9, NodeStatus.Allowed);
	
		this.setNodestatus(this, 4, 0, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 1, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 4, NodeStatus.Restricted);
		this.setNodestatus(this, 4, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 7, NodeStatus.Restricted);
		this.setNodestatus(this, 4, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 4, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 5, 0, NodeStatus.Restricted);
		this.setNodestatus(this, 5, 1, NodeStatus.Restricted);
		this.setNodestatus(this, 5, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 5, NodeStatus.Restricted);
		this.setNodestatus(this, 5, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 7, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 5, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 6, 0, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 1, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 2, NodeStatus.Restricted);
		this.setNodestatus(this, 6, 3, NodeStatus.Restricted);
		this.setNodestatus(this, 6, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 7, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 6, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 7, 0, NodeStatus.Allowed);
		this.setNodestatus(this, 7, 1, NodeStatus.Restricted);
		this.setNodestatus(this, 7, 2, NodeStatus.Restricted);
		this.setNodestatus(this, 7, 3, NodeStatus.Restricted);
		this.setNodestatus(this, 7, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 7, 5, NodeStatus.Restricted);
		this.setNodestatus(this, 7, 6, NodeStatus.Goal);
		this.setNodestatus(this, 7, 7, NodeStatus.Restricted);
		this.setNodestatus(this, 7, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 7, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 8, 0, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 1, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 8, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 8, 4, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 5, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 8, 7, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 8, NodeStatus.Restricted);
		this.setNodestatus(this, 8, 9, NodeStatus.Allowed);
		
		this.setNodestatus(this, 9, 0, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 1, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 2, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 3, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 4, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 5, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 6, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 7, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 8, NodeStatus.Allowed);
		this.setNodestatus(this, 9, 9, NodeStatus.Allowed);
		**/
		
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

	public String toString()
	{
		String s = "";
		
		for(int i=0; i < rows; i++)
		{
			for(int j=0; j < columns; j++)
			{
				 s = s + this.getSpace()[i][j].getStatus().toString() + "\t\t";
			}
			s = s + "\n";
		}
		
		return s;
	}
	
	
}
