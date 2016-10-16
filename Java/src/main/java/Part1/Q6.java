package Part1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/16/16.
 *
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * 给定一副NxN矩阵表示的图像，其中每个像素的大小为4字节，
 * 编写一个方法，将图像旋转90度，不占用额外内存空间。
 */
public class Q6 {

    // 逐层交换
    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int top = matrix[layer][i];     // 存储上边元素
                matrix[layer][i] = matrix[n-1-i][layer];            // 左边存储至上边
                matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];    // 下边存储值左边
                matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];    // 右边存储至下边
                matrix[i][n-1-layer] = top;                         // 上边存储至右边
            }
        }
    }

    @Test
    public void testRotate() {
        /**
         * [1, 2]  => [4, 1]
         * [4, 3]     [3, 2]
         */
        int[][] matrix1Before = {{1, 2}, {4, 3}};
        int[][] matrix1After = {{4, 1}, {3, 2}};
        rotate(matrix1Before, 2);
        Assert.assertArrayEquals(matrix1After, matrix1Before);

        /**
         * [1, 2, 3]  => [7, 8, 1]
         * [8, 9, 4]     [6, 9, 2]
         * [7, 6, 5]     [5, 4, 3]
         */
        int[][] matrix2Before = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] matrix2After = {{7, 8, 1}, {6, 9, 2}, {5, 4, 3}};
        rotate(matrix2Before, 3);
        Assert.assertArrayEquals(matrix2After, matrix2Before);
    }
}
