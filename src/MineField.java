import java.util.Random;

public class MineField {
    int rowNumber, colNumber, size;
    int[][] map;
    int[][] board;
    Random rand = new Random();

    public MineField(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
    }

    public void prepareGame() {
        int randRow, randCol, count = 0;
        while (count != (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    // Bu fonksiyon artık sadece mayın sayısını dönecek, puanı GUI'de takip edeceğiz
    public int checkMine(int r, int c) {
        int mineCount = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && j >= 0 && i < rowNumber && j < colNumber) {
                    if (map[i][j] == -1)
                        mineCount++;
                }
            }
        }
        return mineCount;
    }
}