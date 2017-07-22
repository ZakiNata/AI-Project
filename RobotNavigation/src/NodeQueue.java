
public class NodeQueue {

	private int row;
	private int column;
	private int price;
	private Node Node;
	
	public NodeQueue(Node node,int row,int column,int price)
	{
		this.Node = node;
		this.row = row;
		this.column = column;
		this.price = price;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Node getNode() {
		return Node;
	}
	public void setNode(Node node) {
		Node = node;
	}
	
	
}
