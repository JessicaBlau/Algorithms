package CalcCarsLinkedList;

public class Node {
	private char data;
	Node prev, next;
	
	public Node(char data, Node prev, Node next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public void setData(char data) {this.data = data;}
	public char getData() {return this.data;}
	public Node getNext() {return this.next;}
	public void setNext(Node next) {this.next = next;}
	public Node getPrev() {return this.prev;}
	public String toString() {return ""+this.data;}
}
