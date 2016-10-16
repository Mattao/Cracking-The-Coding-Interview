package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/16/16.
 *
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 *
 * 若M*N居正中某个元素是0，则将其所在行和列清零
 */
public class Q7 {

    public void setZero(int[][] matrix) {

        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void testSetZero() {
        /**
         * [1, 0]   => [0, 0]
         * [1, 1]      [1, 0]
         */
        int[][] matrix1 = {{1, 0}, {1, 1}};
        int[][] after1 = {{0, 0}, {1, 0}};
        setZero(matrix1);
        Assert.assertArrayEquals(after1, matrix1);

        /**
         * [1, 0, 1]   => [0, 0, 0]
         * [0, 1, 2]      [0, 0, 0]
         */
        int[][] matrix2 = {{1, 0, 1}, {0, 1, 2}};
        int[][] after2 = {{0, 0, 0}, {0, 0, 0}};
        setZero(matrix2);
        Assert.assertArrayEquals(after2, matrix2);
    }
}
