
import java.util.Scanner;
import java.util.Random; 

public class singlePlayerRun
{
    public static void main(String[] args)
    {
        start();
    }  
    
    
    
    public static void play(String first, String second, String human)
    {
        
        Scanner scan = new Scanner(System.in);// scanner 
        singlePlayerEngine game = new singlePlayerEngine(first, second, human); // calls the class TicTacToe 
        singlePlayerAI a1 = new singlePlayerAI(first,second,human); // call the AI class 


        int row = 0; 
        int col = 0; 
        
        while(!game.checkWin())
        {
            System.out.println();
            if(game.getName().equals(human))
            {
                System.out.println("Hello " + game.getName() + ", please enter a row!"); 
                row = scan.nextInt(); 
                System.out.println("Hello " + game.getName() + ", please enter a column!");
                col = scan.nextInt();
                System.out.println(game.getName() +  " entered: \nRow: " + row + "\nCol: " + col);
                
            }
            
            // inputs from the AI 
            if(game.getName().equals("AI-19"))
            {
               
                if(first.equals("AI-19")) // offense
                {
                    int coordinates[] = a1.offense(game.getTurn()); 
                    row = coordinates[0]; 
                    col = coordinates[1]; 
                    System.out.println("AI-19 entered: \nRow: " + row + "\nCol: " + col);
                    
                }
                if(second.equals("AI-19")) // defense 
                {
                    int coordinates[] = a1.defense(game.getTurn()); 
                    row = coordinates[0]; 
                    col = coordinates[1]; 
                    System.out.println("AI-19 entered: \nRow: " + row + "\nCol: " + col);
                }
            }
            System.out.println();
            
            
            if(game.pickLocation(row,col))
            {

                game.takeTurn(row,col);
                game.printBoard();
            }
            else
            {
                game.checkForMistakes(row,col);
            }
            
            
            
            // this checks for a winner
            if(!game.getFinalTie())
            {
                if(game.checkWin())
                {
                    if(game.getName().equals(second))
                    {
                        System.out.println("Congratulations " + first + " you WON!"); 
                        break;
                    }
                    else
                    {  
                        System.out.println("Congratulations " + second + " you WON!"); 
                        break;
                    }
                }
            }
            else
            {
                System.out.println("The game is a tie!");
                break;
            }
        }       
    }
    
    
   
    
    
        
    public static void start() // this is done 
    {
        Scanner scan = new Scanner(System.in); // scanner 
        Random random = new Random(); // random 
        
        System.out.println("Welcome to Single PLayer Tic-Tac-Toe! \nYou will face AI-19, the most sophisticated AI.");  // welcome 
       
        System.out.println();
        
        System.out.println("Hello Human! Enter your name: "); //player 1
        String p1 = scan.nextLine();
       
        String p2 = "AI-19"; 
        System.out.println();
        
        String first = ""; //first player 
        String second = "";  // second player 
        
        int rand = random.nextInt(2);   // decides who goes first and who goes second 

        if(rand == 1)
        {
            first = p1; //this sets player 1 as the first player 
            second = p2; // this sets player 1 as the second player 
        }
        else 
        {
            first = p2; // this sets player 2 as the first player 
            second = p1; // this sets player 1 as the second player 
        }
            
        System.out.println("Congratulations " + first + ", you will go first and be the X!");
        System.out.println("Sorry " + second + ", you will go second and be the O!");
        
        String human; 
        
        if(first.equals("AI-19"))
        {
            human = second; 
        }
        else
        {
            human = first; 
        }
        play(first, second, human); 
    }
}
      