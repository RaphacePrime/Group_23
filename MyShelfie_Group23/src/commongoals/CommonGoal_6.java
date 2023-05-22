package commongoals;

import board.Card;
import player.Player;

/**
 * Common Goal 6: Checks if there are at least two columns composed of six cards of the same color.
 */
public class CommonGoal_6 extends CommonGoal {

    /**
     * Constructs a CommonGoal_6 object with the specified ID.
     *
     * @param id The ID of the common goal.
     */
    public CommonGoal_6(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Checks if the common goal is met by the player.
     *
     * @param player The player to check the common goal for.
     * @return True if there are at least two columns composed of six cards of the same color, false otherwise.
     */
    @Override
    public boolean checkGoal(Player player) 
    {
        Card[][] matrix = player.getLibrary().getMatrix();
        matrix=this.setNullToString(matrix);
        int count = 0;
        for (int col = 0; col < 5; col++) 
        {
        	boolean null_element=false;
            String[] colors = new String[6]; // Variable for line count, when the column is swapped, it resets
            System.out.print("Column " + col + ": ");
            for (int lin = 0; lin < 6; lin++) 
            {
                //System.out.print(matrix[lin][col].getColor());
            	if(matrix[lin][col].getColor().equals("N"))
            	{
            		null_element=true;
            	}
            	else
            	{
            		colors[lin] = matrix[lin][col].getColor();
            	}
                
            }
            //System.out.println();
            if (this.arrayCheck(colors) && null_element==false) 
            {
                count++;
            }
        }
        //System.out.print("COUNT: " + count);
        return count >= 2;
    }

    /**
     * Checks if all elements in the array are unique.
     *
     * @param array The array to check.
     * @return True if all elements in the array are unique, false otherwise.
     */
    public boolean arrayCheck(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private Card[][] setNullToString(Card[][] matrix) 
	{
		for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getColor() == null) {
                    matrix[i][j].setColor("N");
                }
            }
        }

        // Print the updated matrix
        for (Card[] row : matrix) {
            for (Card element : row) {
                System.out.print(element.getColor() + " ");
            }
            System.out.println();
        }
		return matrix;
	}

    /**
     * Prints the description of the common goal.
     */
    @Override
    public void output() {
        System.out.println("Two columns made by six cards of the same color");
    }
}
