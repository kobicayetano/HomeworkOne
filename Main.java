import java.util.Scanner;
import java.util.Random;
public class Main{

	public String[][] resetArray(){
		//ask user for size of new array
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String entries = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+?/.><[]";
		String generatedString="";

		int x,y;
		System.out.println("Array size: ");
		System.out.print("x: ");
		x = sc.nextInt();
		System.out.print("y: ");
		y = sc.nextInt();
		System.out.format("User Input: %dx%d\n", x,y);		

		String[][] arr = new String[x][y];
		//populate array
		for(int i=0; i<x; i++){	
			for(int j=0; j<y; j++){
				for(int k=0; k<3; k++){
					generatedString+= entries.charAt(r.nextInt(entries.length()));
				}
				arr[i][j] = generatedString;
				generatedString="";
			}
		}//end for loop	

		printArray(arr);

		System.out.println("----------------------------");
		return(arr);
	}//end resetArray
	
	public void editString(String arr[][]){
		//edit string in array index x,y
		Scanner sc = new Scanner(System.in);
		String newVal;
		int x,y;

		System.out.println("Array index: ");
		System.out.print("x: ");
		x = sc.nextInt();
		System.out.print("y: ");
		y = sc.nextInt();

		System.out.format("User Input: %dx%d\n", x,y);
		System.out.print("New Value: ");
		newVal= sc.next();

		arr[x][y] = newVal;

		printArray(arr);
		System.out.println("----------------------------");
	}//end editString

	public void searchArray(String arr[][]){
		//search a string in the array
		Scanner sc = new Scanner(System.in);
		String subString="";
		int row = arr.length;
  		int col = arr[0].length;
		System.out.print("Search: ");
		subString = sc.next();
		int occurance;
		int fromIndex;

		//for loop for the searching
		for(int i=0; i<row; i++){
			//drives outer loop for arr
			for(int j=0; j<col; j++){
				//drives inner loop for arr
				String searchFrom= arr[i][j];
				occurance=0;
				fromIndex =0;
				//return -1 if value cannot  be found (Loop stop mechanism)
				while ((fromIndex = searchFrom.indexOf(subString, fromIndex)) != -1 ){
            		occurance++;
            		fromIndex++;
				if(occurance>0){
					System.out.format("Output: [%d,%d] - %d Occurance\n",i,j,occurance);
				}
			}
		}//end  for loop
		}
	}//end searchArray	

	public void printArray(String arr[][]){

		for(String[] x : arr){
            for(String y : x){
                System.out.print(y+"  "); 
            }
            System.out.print("\n"); 
        }
		System.out.println("----------------------------");
	}//end printArray

	public void endSession(){
		System.exit(0);
	}//end endSession

	public static void main(String  args[]){
		Scanner sc = new Scanner(System.in);
		Main main =  new Main();
		String sArray[][];

		//initialize  array here
		sArray = main.resetArray();

		//while loop for the main menu
		while(true){
			System.out.println("\n\n");
			System.out.println("a.) New Array");
			System.out.println("b.) Edit Array");
			System.out.println("c.) Search Array");
			System.out.println("d.) Print Array");
			System.out.println("e.) Exit\n");
			System.out.print("Input: ");
			String choice = sc.next();

			switch (choice){
			case ("a"):
				sArray  = main.resetArray();
				break;
			case ("b"):
				main.editString(sArray);
				break;
			case ("c"):
				main.searchArray(sArray);
				break;
			case ("d"):
				main.printArray(sArray);
				break;
			case ("e"):
				main.endSession();
				break;
			}
		}//end while
	}//end main
	
}//end Main

