package player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.Card;

public class PersonalGoal 
{
	
	private int id; //id of the goal
	
	private String matrix[][]; //matrix containing the color of the cards and the position they must have in the library

	private List<String> fileContent; 
	
	private int points; //Personal goal points made by a player
	
	private int[] score = {0,1,2,4,6,9,12}; //Points a player gets by completing the goal
	
 
	public PersonalGoal (int id) throws FileNotFoundException
	{
		this.id = id;
		fileContent = new ArrayList<>();
		matrix = new String[6][5];
		createGoal();
		points = 0;
	}
	
	//Calculates the points made
	
	public void controlGoal (Library lib)
	{
		Card[][] PlayerMatrix = lib.getMatrix();	//Matrix of the library of the player
		
		int boxCompleted = 0;
		for(int j=0; j < 5; j++) {
			
			for(int i = 0; i < 6; i++) {
				
				if(matrix[i][j] != null && matrix[i][j].equals(PlayerMatrix[i][j].getColor())) {
					
					boxCompleted++;
					
				}
				
			}
			
		}
		
		points = score[boxCompleted];
		
		return;
	}
	
	//This function returns the points (To calculate the points, use the function controlGoal)
	
	public int GetPoints() {
		return this.points;
	}
	
	//This function reads the file and creates a list of string out of it
	
	public void readFile() throws FileNotFoundException {
		
		File f = new File("./resources/Personal_Goals.txt");
		
		Scanner s = new Scanner(f);
		
		while(s.hasNext()){
			
			fileContent.add(s.nextLine());
			
		}
		
		s.close();
		
		return;	
		
	}
	
	//This function ceates the goal from the file Personal_Goals.txt
	
	private void createGoal() throws FileNotFoundException {
		
		readFile();
		int strRead = 0;
		
		for(String str: fileContent) {
			
			strRead++;
			
			if(strRead == id) {
				
				String[] posCard = str.split(";"); 
				
				for(int i = 0; i<posCard.length; i++) {
					
					String[] posCol = posCard[i].split(",");
					
					int xAxis = Integer.parseInt(posCol[0])-1;
					int yAxis = Integer.parseInt(posCol[1])-1;
					String color = posCol[2];
					
					matrix[xAxis][yAxis] = color;
				}
				
			}
			
		}
		
	}
	
	/*
	//Test class PersonalGoal
	 
	public String toString() {
		
		String s = "";
		for(int x=0; x <= 5; x++) {
			
			for(int y =0; y <= 6; y++) {
				
				if(matrix[x][y] != null){
					s = s + "x: " +  x + ", y: " + y + ", color: " + matrix[x][y] + "\n";
					
				}
				
			}
			
		}
		return s;
	}
	
	*/
	
	
	//Grafic rapresentation of a goal

	public void output () 
	{
		
		System.out.println("\n\t   Columns\n\t1  2  3  4  5");
		
		for(int i=0; i < matrix.length; i++) {
			
			for(int j =0; j < matrix[i].length; j++) {
				System.out.print("\t");
				if(matrix[i][j] == null){
					
					System.out.print("\u001B[30m" + "* " + "\u001B[0m");
					
				}else {
					
					if(matrix[i][j].equals("yellow")) {
						System.out.print("\u001B[33m" + "# " + "\u001B[0m");
					}else if(matrix[i][j].equals("pink")) {
						System.out.print("\u001B[31m" + "# " + "\u001B[0m");
					}else if(matrix[i][j].equals("blue")) {
						System.out.print("\u001B[34m" + "# " + "\u001B[0m");
					}else if(matrix[i][j].equals("green")) {
						System.out.print("\u001B[32m" + "# " + "\u001B[0m");
					}else if(matrix[i][j].equals("cyan")) {
						System.out.print("\u001B[36m" + "# " + "\u001B[0m");
					}else if(matrix[i][j].equals("white")) {
						System.out.print("\u001B[37m" + "# " + "\u001B[0m");
					}
				}
				
			}
			
			System.out.print("\n");
		}
		
		
	}
	
}
