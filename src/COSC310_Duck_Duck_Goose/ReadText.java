package COSC310_Duck_Duck_Goose;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for reading in file line by line
 * @author aarondavis
 *
 */
public class ReadText{
	
	static File file = new File("txtFile2.txt");
	//static CircularLinkedList list = new CircularLinkedList();
	 
	/*
	 * Reads in txt file line by line into Linked List
	 * Param: List
	 */
	public static void readIn(CircularLinkedList list) throws FileNotFoundException{
		
		Scanner scan = new Scanner(file);
		//List<String> tempList = new ArrayList<String>();
		//String[] tempArray = new String[3];
		
		//int n = 0;
		while(scan.hasNextLine()){
			String tempStr = scan.nextLine();
			list.add(tempStr);
			//tempList.add(tempStr);
			//n = n + 1;
			//System.out.println(n + ": " + tempStr);	
		}
		scan.close();
		//System.out.println();
		//System.out.println(tempList.get(0));
	}
}
