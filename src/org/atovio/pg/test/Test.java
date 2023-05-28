package org.atovio.pg.test;

import java.util.Random;

/**
 * @author Winter Yuan
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 打乱图片
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 1; i < arr.length; i++) {
            // 获取随机索引
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[][] data = new int[3][5];

        // 添加数据
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = arr[index];
                index++;
            }
        }
    }
}
