package CalcCarsLinkedList;

import java.util.LinkedList;

public class CalcCarsLinkedList {
	LinkedListCycle cars;// a cycle linked list 
	LinkedList<Node> carsList;// a regular linked list 
	final int nLetters = 23, size = (int) (Math.random()*nLetters), sizeList = (int) (Math.random()*nLetters);
	final char v = 'v', w = 'w';
	/**
	 * constructor to create the linkedlist's and add cars to them.
	 */
	public CalcCarsLinkedList() {
		carsList = new LinkedList<>();
		cars = new LinkedListCycle();
		for(int i = 0; i < size; i++) {
			char c = (char) ('a' + Math.random()*nLetters);
			cars.add(c);
		}
		char c = (char) ('a'+ Math.random()*nLetters);
		Node head = new Node(c,null,null);
		carsList.addFirst(head);
		for (int i = 0; i < sizeList; i++) {
			char ch = (char) ('a'+ Math.random()*nLetters);
			Node temp = new Node(ch, head, null);
			head = temp;
			carsList.add(temp);
		}
		System.out.println(cars.toString() + carsList.toString());
	}
	/**
	 * Calculates the amount of cars in this linked list.
	 * @return counter - the amount of cars.
	 */
	public int calCars() {
		cars.getHead().setData(v);
		Node t = cars.getHead().getNext();
		boolean flag = true;
		int counter = 1;

		while(flag) {
			if(t.getData() == v) {
				t.setData(w);
				int i = counter;
				while(i > 0) {
					t = t.getPrev();
					i--;
				}
				if(t.getData() == w) {flag = false;}
				else{
					counter = 1;
					t = cars.getHead().getNext();
				}
			}
			else {
				t = t.getNext();
				counter++;
			}
		}
		return counter;
	}
	/**
	 * checks if there is an arm connected to this cycle
	 * @return ans - length of the arm
	 */
	public int ArmLength() {
		int ans = -1;// length of arm
		boolean flag = true;
		boolean ToRun = true;

		Node tertel = cars.getHead();
		Node rabit = cars.getHead();
		
		while(flag) {
			if(tertel.getNext() == null || rabit.getNext() == null || 
					rabit.getNext().getNext() == null) {
				System.out.println("There is no cycle in the linkedlist cars");
				flag = false;
				ToRun = false;
			}
			else {
				tertel = tertel.getNext();
				rabit = rabit.getNext().getNext();
				if(tertel.getData() == rabit.getData()) {
					flag = false;
					ToRun = true;
				}
			}
		}
		
		rabit = cars.getHead();
		while(ToRun) {
			ans++;
			if(tertel.getData() == rabit.getData()) {ToRun = false;}
			else {
				tertel = tertel.getNext();
				rabit = rabit.getNext();
			}
		}
		return ans;
	}
	/**
	 * checks if this linkedlist is a cycle, meaning a regular linkedlist
	 * or a bidirectional linkedlist.
	 */
	public void ifCycle() {
		boolean flag = true;

		Node tertel = cars.getHead();// checks the linkedlistcycle
		Node rabit = cars.getHead();
		
		Node tertel1 = carsList.getFirst();// checks the linkedlist that is not a cycle
		Node rabit1 = carsList.getFirst();
		
		// checks cars if there is a cycle 
		while(flag) {
			if(tertel.getNext() == null || rabit.getNext() == null || 
					rabit.getNext().getNext() == null) {
				System.out.println("There is no cycle in the linkedlist cars");
				flag = false;
			}
			else {
				tertel = tertel.getNext();
				rabit = rabit.getNext().getNext();
				if(tertel.getData() == rabit.getData()) {
					System.out.println("There is a cycle in the linkedlist cars!");
					flag = false;
				}
			}
		}
		// checks carlist if there is a cycle 
		flag = true;
		while(flag) {
			if(tertel1.getNext() == null || rabit1.getNext() == null || 
					rabit1.getNext().getNext() == null) {
				System.out.println("There is no cycle in linkedlist carlist");
				flag = false;
			}
			else {
				tertel1 = tertel1.getNext();
				rabit1 = rabit1.getNext().getNext();
				if(tertel1.getData() == rabit1.getData()) {
					System.out.println("It is a cycle in linkedlist carlist!");
					flag = false;
				}
			}
		}
		
	}
	public static void main (String [] args) {
		CalcCarsLinkedList listCars = new CalcCarsLinkedList();
		System.out.println(listCars.calCars());
		listCars.ifCycle();
		System.out.println(listCars.ArmLength());
	}
}
