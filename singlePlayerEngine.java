
import java.util.Scanner;
public class singlePlayerEngine
{
    protected String first; 
    protected String second; 
    protected String human; 
    public singlePlayerEngine(String first, String second, String human)
    {
        this.first = first; 
        this.second = second; 
        this.human = human; 
    }
    
  
        
    static String[][] board = {
        {" ","0", "1", "2"}, 
        {"0","-", "-", "-"},
        {"1","-", "-", "-"}, 
        {"2","-", "-", "-"}};
        
     
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   private int turn = 0;
   
   public String getBoard(int row, int col)
    {
        return board[row+1][col+1]; 
    }
    
   
   
   public void checkForMistakes(int row, int col) 
    {
      
        Scanner scan = new Scanner(System.in); //scanner
        do 
        {
            System.out.println("You may have typed in an incorrect row or column. Please Try again.");
            System.out.println("Hello " + getName() + ", please enter a row!"); 
            row = scan.nextInt(); 
            System.out.println("Hello " + getName() + ", please enter a column!");
            col = scan.nextInt();
        } while(!pickLocation(row,col));
    }
    

   //this method returns the current turn
   public int getTurn()
   {
       return turn; 
   }
   public String getName()
    {
        
        {
            int t = getTurn();
            if(t % 2 == 0)
            {
            return first;  
            }
            return second; 
        }
        
        
        
    }
    
    public boolean getFinalTie()
    {
        if((getTie()) && !checkWin())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean getTie()
    {
        int counter = 0; 
        for(int x = 1; x <= 3; x++)
        {
            for(int y = 1; y <=3; y++)
            {
                if(board[x][y].equals("O") ||  (board[x][y].equals("X")))
                {
                    counter++;
                }
            }
        }
        if(counter == 9)
        {
            return true;
        }
        return false; 
    }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       for(int row = 0; row < board.length; row++)
       {
           for(int col = 0; col < board[0].length; col++)
           {
               System.out.print(board[row][col]);
                if(row != 0 && col!= 3) 
                {
                    System.out.print(" ");
                }
            
                if((row == 0 && col == 0) || (row == 0 && col == 1) || (row == 0 && col == 2) || (row == 1 && col == 3) || (row == 2 && col == 3) || (row == 3 && col == 3))
                {
                    System.out.print(" ");
                }
           
           }
           System.out.println("");
           
           
       }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if((row>3) || (col>3) || (col < 0) || (row<0))
       {
           return false;
       }
       if((board[row+1][col+1].equals("O")) || (board[row+1][col+1].equals("X")))
       {
           return false;
       }
       return true;
   }

   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
       if(turn % 2 == 0) // if you go first you will be an X 
       {
           board[row +1][col +1] = "X";
           
       }
       if(turn % 2 == 1) // if you go second you will be a O 
       {
             board[row +1][col +1] = "O";
       }
       turn++; 
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {
       for(int row = 1; row < 4; row++)
       {
            if( (board[row][1].equals("X")) && (board[row][2].equals("X")) && (board[row][3].equals("X")))
            {
                return true; 
            }
            if( (board[row][1].equals("O")) && (board[row][2].equals("O")) && (board[row][3].equals("O")))
            {
               return true; 
            }
            
       }
       return false; 
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
       for(int col = 1; col < 4; col++)
       {
            if( (board[1][col].equals("X")) && (board[2][col].equals("X")) && (board[3][col].equals("X")))
            {
                return true; 
            }
            if( (board[1][col].equals("O")) && (board[2][col].equals("O")) && (board[3][col].equals("O")))
            {
                return true; 
            }
            
       }
       return false; 
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       if((board[1][1].equals("X")) && (board[2][2].equals("X")) && (board[3][3].equals("X")))
       {
           return true;
       }
       if((board[1][1].equals("O")) && (board[2][2].equals("O")) && (board[3][3].equals("O")))
       {
           return true;
       }
       if((board[3][1].equals("X")) && (board[2][2].equals("X")) && (board[1][3].equals("X")))
       {
           return true;
       }
       if((board[3][1].equals("O")) && (board[2][2].equals("O")) && (board[1][3].equals("O")))
       {
           return true;
       }
       return false; 
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       if(checkDiag() || checkCol() || checkRow())
       {
           return true;
       }
       return false; 
   }
}