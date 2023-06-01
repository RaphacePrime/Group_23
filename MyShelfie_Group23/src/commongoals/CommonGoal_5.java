package commongoals;

import board.Card;
import player.Player;

/**
 * Common Goal 5: Checks if there are at least four groups of four cards of the same type.
 */
public class CommonGoal_5 extends CommonGoal {

    /**
     * Constructs a CommonGoal_5 object with the specified ID.
     *
     * @param id The ID of the common goal.
     */
    public CommonGoal_5(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Prints the description of the common goal.
     */
    @Override
    public void output() {
        System.out.println("Four groups made by four cards of the same type, on the same column or row");
    }

    /**
     * Checks if the common goal is met by the player.
     *
     * @param player The player to check the common goal for.
     * @return True if there are at least four groups of four cards of the same type, false otherwise.
     */
    @Override
    public boolean checkGoal(Player player) {
        Card[][] matrix2 = player.getLibrary().getMatrix();
        String[][] matrix= new String[6][5];
        for(int i=0; i<6; i++)
        {
        	for(int y=0; y<5; y++)
        	{
        		if(matrix2[i][y].getColor()==null)
        		{
        			matrix[i][y]="null";
        		}
        		else
        		{
        			matrix[i][y]=matrix2[i][y].getColor();
        		}
        		
        	}
        }
        int count = 0; // Counter for the found groups
        
        // Scan the rows
        for (int i = 0; i < matrix.length; i++) {
            // Scan the columns
            for (int j = 0; j < matrix[i].length; j++) {
                String current = matrix[i][j];
                /*try {
                	System.out.println("Row: "+current+matrix[i][j + 1]+matrix[i][j + 2]+matrix[i][j + 3]);
                }catch(Exception e) {
                	System.out.println(e);
                }*/
                
                // Check if there are four equal strings in the same row
                if (j + 3 < matrix[i].length && current!="null" && current.equals(matrix[i][j + 1]) && current.equals(matrix[i][j + 2]) && current.equals(matrix[i][j + 3])) {
                    count++;
                    // Set the strings in the group to null
                    matrix[i][j]="null";
                    matrix[i][j + 1]="null";
                    matrix[i][j + 2]="null";
                    matrix[i][j + 3]="null";
                }

                // Check if there are four equal strings in the same column
                if (i + 3 < matrix.length && current!="null" && current.equals(matrix[i + 1][j]) && current.equals(matrix[i + 2][j]) && current.equals(matrix[i + 3][j])) {
                    count++;
                    // Set the strings in the group to null
                    matrix[i][j]="null";
                    matrix[i + 1][j]="null";
                    matrix[i + 2][j]="null";
                    matrix[i + 3][j]="null";
                }
            }
        }
        //System.out.println("Number of groups: " + count);
        if(count>=4)
        {
        	return true;
        }
        return false;
    }
}
