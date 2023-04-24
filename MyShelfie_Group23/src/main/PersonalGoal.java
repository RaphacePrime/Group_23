package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonalGoal 
{
	
	private int id;
	
	private String matrix[][];

	private List<String> fileContent; 
	
	private int points; //puteggio ottenuto per questo personalGoal
	
	private int[] score = {0,1,2,4,6,9,12}; //punteggio che si può ottenere in base a quante caselle sono state 
	
	
	public PersonalGoal (int id) throws FileNotFoundException
	{
		this.id = id;
		fileContent = new ArrayList<>();
		matrix = new String[6][7];
		createGoal();
		points = 0;
	}
	
	public void controlGoal (Library lib)
	{
		int boxCompleted = 0;
		for(int x=0; x < 6; x++) {
			
			for(int y = 0; y < 7; y++) {
				
				if(matrix[x][y] != null && matrix[x][y].equals("pink" /* lib.matrix[x][y].getColor() */)) {
					
					boxCompleted++;
					
				}
				
			}
			
		}
		
		points = score[boxCompleted];
		
		return;
	}
	
	public int GetPoints() {
		return this.points;
	}
	
	public void readFile() throws FileNotFoundException {
		
		File f = new File("./resources/Personal_Goals.txt");
		
		Scanner s = new Scanner(f);
		
		while(s.hasNext()){
			
			fileContent.add(s.nextLine());
			
		}
		
		s.close();
		
		return;	
		
	}
	
	private void createGoal() throws FileNotFoundException {
		
		readFile();
		int strRead = 0; // indica la stringa che sto leggendo del file in quel momento
		
		for(String str: fileContent) {
			
			strRead++;
			
			if(strRead == id) {
				
				String[] posCard = str.split(";"); //Contains every single 
				
				for(int i = 0; i<posCard.length; i++) {
					
					String[] posCol = posCard[i].split(","); //Contains the position and the color of a single card
					
					int xAxis = Integer.parseInt(posCol[0]);
					int yAxis = Integer.parseInt(posCol[1]);
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

	public void output () 
	{
		
	}
	

	public void controlScoreTaken () 
	{
			
	}
	
}
