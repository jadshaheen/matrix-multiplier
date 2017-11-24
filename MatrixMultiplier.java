import java.io.IOException;
import java.util.Scanner;

public class MatrixMultiplier {

    public static void main(String[] args) throws IOException{
        Scanner inp = new Scanner(System.in);
        System.out.print("Number of rows in A: ");
        int numRows = inp.nextInt();
        System.out.print("Number of columns in A: ");
        int numCols = inp.nextInt();
        System.out.println();
        System.out.println("Enter matrix A, entry by entry, starting with top left and ending with bottom right. Separate each entry by a space.");
        int[][] A = new int[numRows][numCols];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = inp.nextInt();
            }
        }
        System.out.print("Number of rows in B: ");
        int numBRows = inp.nextInt();
        System.out.print("Number of columns in B: ");
        int numBCols = inp.nextInt();
        System.out.println();
        System.out.println("Enter matrix B, entry by entry, starting with top left and ending with bottom right. Separate each entry by a space.");
        int[][] B = new int[numBRows][numBCols];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                B[i][j] = inp.nextInt();
            }
        }
        System.out.println();
        System.out.println("The resultant matrix:");
        System.out.println();
        for (int[] arr : multiplier(A, B)) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] multiplier(int[][] a, int[][] b) throws IOException {

        if (a.length != b[0].length) {
            throw new IOException("A and B cannot be multiplied; confirm that their dimensions allow for this operation.");
        }

        int commonSize = a.length;
        int numColumns = a[0].length;
        int numRows = b.length;
        int[][] solution = new int[numRows][];
        for (int i = 0; i < solution.length; i++) {
            solution[i] = new int[numColumns];
        }

        for (int colNum = 0; colNum < numColumns; colNum++) {
            for (int rowNum = 0; rowNum < numRows; rowNum++) {
                int currEntry = 0;
                for (int common = 0; common < commonSize; common++) {
                    currEntry += a[common][colNum] * b[rowNum][common];
                }
                solution[rowNum][colNum] = currEntry;
            }
        }
        return solution;
    }

}
