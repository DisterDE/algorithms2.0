package lesson2.task1;

public class Task1 {
    private static final int MATRIX_SIZE = 7;
    private static int currentNum = 1;
    private static Direction currentDirection = Direction.RIGHT;
    private static int currentY;
    private static int currentX;

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(MATRIX_SIZE);
        paintHelix(matrix);
        printMatrix(matrix);
    }

    private static void paintHelix(int[][] matrix) {
        while (isNotFull(matrix)) {
            checkLine(matrix, currentDirection.getZy(), currentDirection.getZx());
            currentDirection = Direction.nextDirection(currentDirection);
            currentY += currentDirection.getZy();
            currentX += currentDirection.getZx();
        }
    }

    private static void checkLine(int[][] matrix, int zy, int zx) {
        while (true) {
            matrix[currentY][currentX] = currentNum++;
            if (currentY + zy == MATRIX_SIZE || currentX + zx == MATRIX_SIZE ||
                    currentY + zy < 0 || currentX + zx < 0 ||
                    matrix[currentY + zy][currentX + zx] != 0) {
                break;
            }
            currentY += zy;
            currentX += zx;
        }
    }

    private static boolean isNotFull(int[][] matrix) {
        for (int[] line : matrix) {
            for (int position : line) {
                if (position == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] subArr : matrix) {
            for (int i : subArr) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int size) {
        return new int[size][size];
    }
}
