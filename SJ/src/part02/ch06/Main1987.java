package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1987 {

  private static char[][] board;
  private static int R;
  private static int C;
  private static int dx[] = {0, 0, 1, -1};
  private static int dy[] = {-1, 1, 0, 0};
  private static boolean[] visited = new boolean[26];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];

    for (int i = 0; i < R; i++) {
      board[i] = br.readLine().toCharArray();
    }

    visited[board[0][0] - 'A'] = true;
    System.out.println(dfs(0, 0, 1));
  }

  private static int dfs(int r, int c, int length) {
    int maxLength = length;

    for (int i = 0; i < 4; i++) {
      int nR = r + dx[i];
      int nC = c + dy[i];

      if (isValidPath(nR, nC)) {
        if (!visited[board[nR][nC] - 'A'])  {
          visited[board[nR][nC] - 'A'] = true;
          maxLength = Math.max(maxLength, dfs(nR, nC, length + 1));
          visited[board[nR][nC] - 'A'] = false;
        }
      }
    }
    return maxLength;
  }

  private static boolean isValidPath(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }
}