import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper");
        System.out.println("Enter dimensions to play");

        System.out.print("Number of lines: ");
        int row = scan.nextInt();

        System.out.print("Number of columns: ");
        int column = scan.nextInt();

        // GUI sınıfını başlatıyoruz
        new MinesweeperGUI(row, column);
    }
}