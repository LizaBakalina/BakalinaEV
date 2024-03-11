import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        System.out.print("Ввод размера квадратной матрицы: ");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Matrix matrix = new Matrix(n);
        matrix.createMatrix();
        System.out.println(matrix.ToString());
        System.out.println("Произведение диагоналей: " + matrix.calculateDiagonal());
        System.out.println("Сумма элементов матрицы выше диагонали: " + matrix.calculateUp());
        System.out.println("Разность элементов матрицы ниже диагонали: " + matrix.calculateDown());
    }
}