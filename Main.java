import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввод размера квадратной матрицы: ");
        int n = in.nextInt();
        System.out.printf(n + "x" + n + "\n");
        in.close();

        int[][] matrix = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        int diag1 = 1;
        int diag2 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
                    diag1 = diag1*matrix[i][j];
                }if (i + j == n-1) {
                    diag2 = diag2 * matrix[i][j];
                }

            }

        }
        System.out.println("Произведение диагоналей: " + diag1*diag2);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n-1){
                    sum = sum+matrix[i][j];
                }

            }

        }
        System.out.println("Сумма элементов матрицы выше диагонали: " + sum);

        int raz = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j > n-1){
                    raz = raz + (-1)*matrix[i][j];
                }

            }

        }
        System.out.println("Разность элементов матрицы ниже диагонали: " + raz);
    }

}
