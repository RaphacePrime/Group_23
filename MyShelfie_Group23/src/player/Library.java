package player;

import java.util.ArrayList;
import java.util.Scanner;
import board.Card;
import board.LivingRoomTile;

public class Library {
	
	private Card matrix[][];
	//private final boolean legalTile;
	
	public Library()
	{
		//this.legalTile = legalTile;
		this.matrix = new Card[6][5];
		for(int i=0; i<6; i++)
		{
			for(int y=0; y<5;y++)
			{
				matrix[i][y]= new Card();
			}
		}
				
	}
	
	public boolean checkFullness()
	{
		for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j].getColor()==null)
                {
                	return false;
                }
            }
        }
		return true;
	}
	
	public boolean insertInLibrary(ArrayList<Card> chosen, int column)
	{	
		int num_elements=chosen.size();
		column--;
		int count=0;
		for(int i=0; i<6; i++)
		{
			if(matrix[i][column].getColor()==null)
			{
				count++;
			}
		}
		if(count<num_elements)
		{
			return false;
		}
		while(!chosen.isEmpty())
		{
			num_elements=chosen.size();
			if(num_elements==1)
			{
				for(int y=5; y>=0; y--)
				{
					if(matrix[y][column].getColor()==null || matrix[y][column].getColor().equals("N"))
					{
						matrix[y][column]=chosen.remove(0);
						break;
					}
				}
			}
			else
			{
				System.out.println("Choose which card you want to insert: ");
				int i=1;
				for(Card c:chosen)
				{
					System.out.print(i+") "+c.getColor()+" ");
					i++;
				}
				Scanner sc = new Scanner(System.in);
				int input= sc.nextInt();
				while(input<=0 && input>num_elements)
				{
					System.out.println("You have to insert a valid option!");
					input=sc.nextInt();
				}
				for(int y=5; y>=0; y--)
				{
					if(matrix[y][column].getColor()==null || matrix[y][column].getColor().equals("N"))
					{
						matrix[y][column]=chosen.remove(input-1);
						break;
					}
				}
			}
			
		}
		System.out.println("Library updated: ");
		this.output();
		return true;
	}

	public void output()
	{
		System.out.println("\n\t   Columns\n\t1  2  3  4  5");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("\t");
            for (int j = 0; j < matrix[i].length; j++) {
                String tileColor = matrix[i][j].getColor();
                if(tileColor == null) {
					System.out.print("\u001B[30m" + "*  " + "\u001B[0m");
                }else if(tileColor.equals("yellow")) {
					System.out.print("\u001B[33m" + "#  " + "\u001B[0m");
				}else if(tileColor.equals("pink")) {
					System.out.print("\u001B[31m" + "#  " + "\u001B[0m");
				}else if(tileColor.equals("blue")) {
					System.out.print("\u001B[34m" + "#  " + "\u001B[0m");
				}else if(tileColor.equals("green")) {
					System.out.print("\u001B[32m" + "#  " + "\u001B[0m");
				}else if(tileColor.equals("cyan")) {
					System.out.print("\u001B[36m" + "#  " + "\u001B[0m");
				}else if(tileColor.equals("white")) {
					System.out.print("\u001B[37m" + "#  " + "\u001B[0m");
				}
            }
            System.out.println();
        }
		System.out.println();
	}

	public Card[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Card matrix[][]) {
		this.matrix = matrix;
	}
}


