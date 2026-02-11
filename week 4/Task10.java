import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */
     public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix.get(i).get(j);
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();

            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            for (int j = left; j <= right; j++) list.add(mat[top][j]);
            for (int i = top + 1; i <= bottom - 1; i++) list.add(mat[i][right]);
            for (int j = right; j >= left; j--) list.add(mat[bottom][j]);
            for (int i = bottom - 1; i >= top + 1; i--) list.add(mat[i][left]);

            int size = list.size();
            int rot = r % size;
            int idx = rot;

            for (int j = left; j <= right; j++) mat[top][j] = list.get((idx++) % size);
            for (int i = top + 1; i <= bottom - 1; i++) mat[i][right] = list.get((idx++) % size);
            for (int j = right; j >= left; j--) mat[bottom][j] = list.get((idx++) % size);
            for (int i = bottom - 1; i >= top + 1; i--) mat[i][left] = list.get((idx++) % size);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}





public class Task10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

