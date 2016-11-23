package COSC310_Duck_Duck_Goose;
/**
 * Class for Circular Linked List
 * @author aarondavis
 *
 */
public class CircularLinkedList {
	
	/**
	 * Embedded Node class
	 * @author aarondavis
	 *
	 */
	class Node{
		
		protected String data;
		protected Node head;
		//protected Node next;
		
		/*
		 * Constructor to create Node
		 */
		public Node(){
			head = null;
			data = "";
		}
		
		/*
		 * Second constructor to specify data for Node
		 */
		public Node(String data, Node head){
			this.data = data;
			this.head = head;
		}
		/*
		 * Makes "next" node head
		 */
		public void nextNode(Node next){
			head = next;
		}
				
		/*
		 * Sets data of String
		 */
		public void setData(String s){
			data = s;
		}
		
		/*
		 * Returns the head
		 */
		public Node getHead(){
			return head;
		}
		
		/*
		 * Returns data 
		 */
		public String getData(){
			return data;
		}
	}
	
	//Separate from Node class
	protected Node beginning;
	protected Node ending;
	public int size;
	
	/*
	 * Constructor for Linked List
	 */
	public CircularLinkedList(){
		beginning = null;
		ending = null;
		size = 0;
	}
	
	/*
	 * Returns the size of the List
	 */
	public int getSize(){
		return size;
	}
	
	/*
	 * Inserts Nodes in the "beginning" or head in this case
	 * With string data
	 */
	public void add(String str){
		Node newNode = new Node(str, null);
		newNode.nextNode(beginning);
		
		if(beginning == null){
			beginning = newNode;
			newNode.nextNode(beginning);
			ending = beginning;
		}
		
		else{
			ending.nextNode(newNode);
			beginning = newNode;
		}
		size++;
	}
	
	/*
	 * Method to add a node to any position
	 * Needed for duck-duck-goose game
	 */
	public void addPos(String str, int pos){
		
		//pos - 1 for correct index purposes
		Node newNode = new Node(str, null);
		Node start = beginning;
		pos = pos - 1;
		
		//Loops through until desired position is found
		for(int i = 1; i < size - 1; i++){
			if(i == pos){
				
				Node temp = start.getHead();
				start.nextNode(newNode);;
				newNode.nextNode(temp);
				break;
			}
			start = start.getHead();
		}
		size++;
	}
	
	/*
	 * Returns the element at the position
	 */
	public String getPos(int pos){
		
		Node temp = beginning;
		int currentPos = 0;
		
		while(temp != null){
			if(currentPos == pos){
				return temp.data;
			}
			
			currentPos++;
			temp = temp.getHead();
		}
		
		return "Not in list.";
	}
	
	/*
	 * Method to delete a node at any given position
	 * Built upon LinkedList done in 241
	 */
	public void delete(int pos){
		if(size == 1 && pos == 1){
			
			beginning = null;
			ending = null;
			size = 0;
			return;
		}
		
		if(pos == 1){
			
			beginning = beginning.getHead();
			ending.nextNode(beginning);
			size--;
			return;
		}
		
		if(pos == size){
			
			Node temp = beginning;
			Node temp_2 = beginning;
			while(temp != ending){
				temp_2 = temp;
				temp = temp.getHead();
			}
			
			ending = temp_2;
			ending.nextNode(beginning);
			size--;
			return;
		}
		
		Node temp = beginning;
		pos = pos - 1;
		
		for(int i = 1; i < size - 1; i++){
			if(i == pos){
				
				Node ptr = temp.getHead();
				ptr = ptr.getHead();
				temp.nextNode(ptr);
				break;
			}
			temp = temp.getHead();
		}
		size--;
	}
	
	/*
	 * Code used from stackoverflow. Check to see if list actually works as expected
	 */
	/*public void showList(){
		System.out.println("Circularly Linked List");
		
		Node temp = beginning;
		if(size == 0){
			System.out.print("The list is empty.");
			return;
		}
		
		if(beginning.getHead() == beginning){
			System.out.print(beginning.getData() + " -- " + temp.getData());
			return;
		}
		
		System.out.print(beginning.getData()+ "--");
		temp = beginning.getHead();
		while(temp.getHead() != beginning){
			
			System.out.print(temp.getData() + "--");
			temp = temp.getHead();
		}
		
		System.out.print(temp.getData() + "--");
		temp = temp.getHead();
		System.out.print(temp.getData());
	}*/
}
