import java.util.Random;

public class Matrix {
    int n;
    int[][] matrix;

    public Matrix(int n) {
        this.n = n;
    }

    public int[][] createMatrix() {
        matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        return matrix;
    }
    public StringBuilder ToString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    public int calculateDiagonal() {
        int diag = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i == j) {
                    diag = diag * matrix[i][j];
                }
            }
        }

        return diag;
    }

    public int calculateUp() {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i + j < n - 1) {
                    sum = sum + matrix[i][j];
                }
            }
        }

        return sum;
    }

    public int calculateDown() {
        int raz = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i + j > n - 1) {
                    raz = raz + (-1) * matrix[i][j];
                }
            }
        }

        return raz;
    }

}