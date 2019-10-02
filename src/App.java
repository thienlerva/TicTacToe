import java.util.Scanner;

public class App {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in); Game game = new Game('o');

        Computer com = new Computer('x', false);

        System.out.println("Tic-Tac-Toe!");
        do
        {
            System.out.println("Current board layout:");
            System.out.println(game);
            int row, col;
            do
            {

                System.out.print("Player " + game.getCurrentPlayer() + ", enter an empty row to place your mark! or 9 to quit ");
                row = scan.nextInt()-1;
                if(row==8) { System.exit(1); }
                System.out.print("Player " + game.getCurrentPlayer() + ", enter an empty col to place your mark! ");
                col = scan.nextInt()-1;
                if(row>2 || row < 0 || col>2 || col<0) {
                    throw new IllegalArgumentException("Wrong input, program terminated!");
                }

            }
            while (!game.placeMark(row, col));

            game.changePlayer();
            game.placeMarkByComputer();
            game.changePlayer();
        }
        while(!game.isWinner() && !game.isBoardFull());
        if (game.isBoardFull() && !game.isWinner())
        {
            System.out.println("The game was a tie!");
        }
        else
        {
            System.out.println("Current board layout:");
            System.out.println(game);
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayer()) + " Wins!");
        }

    }
}
