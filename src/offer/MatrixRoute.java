package offer;

public class MatrixRoute {
    public boolean hasPath(char [][] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols <1 || str == null) {
            return false;
        }
        boolean [][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0 ; row < rows ; row++)
            for (int col = 0; col < cols ; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        return false;
    }

    public boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char [] str, int pathLength, boolean[][] visited) {
        if (str[pathLength] == '\0')
            return true;
        boolean hasPath = false;
        if (row >=0 && row <rows && col >=0 && col < cols
                && matrix[row][col] == str[pathLength]
                && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);
            if (!hasPath)
            {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char [][] a = new char[][] {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        char[] b = new char [] {'b','f','c','e','\0'};
        MatrixRoute route = new MatrixRoute();
        System.out.println(route.hasPath(a,3,4,b));
    }
}
