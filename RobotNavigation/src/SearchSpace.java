
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
