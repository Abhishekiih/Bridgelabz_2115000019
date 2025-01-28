import java.util.Random;

public class MatrixManipulation {

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
             - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
             + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        double[][] result = new double[2][2];
        result[0][0] = matrix[1][1] / (double) det;
        result[0][1] = -matrix[0][1] / (double) det;
        result[1][0] = -matrix[1][0] / (double) det;
        result[1][1] = matrix[0][0] / (double) det;
        return result;
    }

    public static double[][] inverse3x3(int[][] matrix) {
        int det = determinant3x3(matrix);
        double[][] result = new double[3][3];
        result[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) / (double) det;
        result[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2]) / (double) det;
        result[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1]) / (double) det;
        result[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2]) / (double) det;
        result[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0]) / (double) det;
        result[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2]) / (double) det;
        result[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]) / (double) det;
        result[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1]) / (double) det;
        result[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) / (double) det;
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = createRandomMatrix(2, 2);
        int[][] matrix2 = createRandomMatrix(2, 2);
        int[][] matrix3 = createRandomMatrix(3, 3);

        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        System.out.println("Matrix 1 + Matrix 2:");
        displayMatrix(addMatrices(matrix1, matrix2));

        System.out.println("Matrix 1 - Matrix 2:");
        displayMatrix(subtractMatrices(matrix1, matrix2));

        System.out.println("Matrix 1 Transpose:");
        displayMatrix(transposeMatrix(matrix1));

        System.out.println("Determinant of Matrix 1:");
        System.out.println(determinant2x2(matrix1));

        System.out.println("Inverse of Matrix 1:");
        displayMatrix(inverse2x2(matrix1));

        System.out.println("Matrix 3:");
        displayMatrix(matrix3);

        System.out.println("Determinant of Matrix 3:");
        System.out.println(determinant3x3(matrix3));

        System.out.println("Inverse of Matrix 3:");
        displayMatrix(inverse3x3(matrix3));
    }
}
