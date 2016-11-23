package COSC310_Duck_Duck_Goose;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		CircularLinkedList list = new CircularLinkedList();

		try {
			ReadText.readIn(list);
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found.");;
		}
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int size = list.getSize();
		
		int ranNum = ran.nextInt(size);
		//list.showList();
		
		System.out.print(size + " kids want to play duck, duck, goose. " + list.getPos(ranNum) + " is it. \n");
		//System.out.println(list. "");
		
		System.out.println("Would you like to continue?" + " Type 'yes' to continue");
		String answer = scan.nextLine();
		
		//int out = 0;
		
		do{
		//int currentPos = ranNum;
		//String it = "";
		int runChance = ran.nextInt(2);
		int leaveChance = ran.nextInt(2);
		
		
			int ranNum2 = ran.nextInt(size);
			
			if(ranNum != ranNum2){
				System.out.printf("Duck, Duck, Duck, Duck, Goose! %s chases %s \n", list.getPos(ranNum2), list.getPos(ranNum));
				
				if(runChance == 1){
					System.out.printf("%s makes it back to his/her spot, %s is still it. \n", list.getPos(ranNum), list.getPos(ranNum2));
					ranNum = ran.nextInt(size);
				}
				else{
					System.out.printf("%s is out!", list.getPos(ranNum));
					list.delete(ranNum);
					
					//out++;
				}
				
				if(leaveChance == 1){
					int ranNum3 = ran.nextInt(size);
					if(ranNum3 == ranNum2){
						ranNum2 = ran.nextInt(size);
						list.delete(ranNum3);
					}
					
					if(ranNum3 == ranNum){
						ranNum = ran.nextInt(size);
						list.delete(ranNum3);
					}
					//out++;
					leaveChance = ran.nextInt(2);
				}
			}
			else{
				continue;
			}
		
			answer = scan.nextLine();	
		}
		while(answer.equalsIgnoreCase("yes")|| list.size < 4);
		
	}

}
