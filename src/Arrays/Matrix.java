package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
        int dir = 0;

        List<Integer> ans = new ArrayList<>();

        while(left <= right && top <= down) {
            if(dir == 0) {
                for(int i= left; i<=right;i++) ans.add(matrix[top][i]);
                top++;
            }
            else if(dir == 1) {
                for(int i = top; i <= down; i++) ans.add(matrix[i][right]);
                right--;
            }
            else if(dir == 2) {
                for(int i = right; i >= left; i--)
                    ans.add(matrix[down][i]);
                down--;
            }
            else if(dir == 3) {
                for(int i = down; i >= top; i--) ans.add(matrix[i][left]);
                left++;
            }

            dir = (dir +1)%4;
        }
        return ans;
    }

    public static int[][] insertSpiral(int n) {
        int top = 0, down = n-1, left = 0, right = n-1;
        int dir = 0;
        int[][] matrix = new int[n][n];
        int num = 1;
        while(left <= right && top <= down) {
            if(dir == 0) {
                for(int i= left; i<=right;i++) matrix[top][i] = num++;
                top++;
            }
            else if(dir == 1) {
                for(int i = top; i <= down; i++) matrix[i][right] = num++;
                right--;
            }
            else if(dir == 2) {
                for(int i = right; i >= left; i--)
                    matrix[down][i] = num++;
                down--;
            }
            else if(dir == 3) {
                for(int i = down; i >= top; i--) matrix[i][left] = num++;
                left++;
            }

            dir = (dir +1)%4;
        }
        return matrix;
    }

    public static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
       int[][] mat2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

//        System.out.println(spiralOrder(mat));
//        System.out.println(spiralOrder(mat2));

        int[][] m = insertSpiral(3);
        printMatrix(m);
    }
}
