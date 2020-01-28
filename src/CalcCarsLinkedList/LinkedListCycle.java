package CalcCarsLinkedList;


public class LinkedListCycle {
	private Node head, tail;
	
	public LinkedListCycle() {
		head = tail = null;
	}
	
	public void add(char car) {
		if(head == null) {
			head = new Node(car, null,null);
			tail = head;
			head.next = head.prev = tail;
		}
		else {
			Node n = new Node(car, tail, head);
			tail.next = n;
			tail = n;
			head.prev = tail;
		}
	}
	
	public Node getHead() {return head;}
	public Node getNext(Node n) {return n.next;}
	public String toString() {
		String str = "[";
		if(head != null) {
			str = str + head.toString() + ", ";
			for (Node n = head.next; n != head; n=n.next){
				str = str + n.next.toString() + ", ";
			}
			str = str.substring(0, str.length()-2);
		}
		return str + "]";
	}
}
