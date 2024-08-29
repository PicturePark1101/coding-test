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
  private static List<Character> visitedChar;
  private static boolean[][] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    visited = new boolean[R][C];
    visitedChar = new ArrayList<>();

    for (int i = 0; i < R; i++) {
      board[i] = br.readLine().toCharArray();
    }

    visited[0][0] = true;
    visitedChar.add(board[0][0]);
    System.out.println(dfs(0, 0, 1));
  }

  private static int dfs(int r, int c, int length) {
    int maxLength = length;

    for (int i = 0; i < 4; i++) {
      int nR = r + dx[i];
      int nC = c + dy[i];

      if (isValidPath(nR, nC)) {
        if (!visited[nR][nC] && !isVisitedChar(board[nR][nC]))  {
          visited[nR][nC] = true;
          visitedChar.add(board[nR][nC]);
          maxLength = Math.max(maxLength, dfs(nR, nC, length + 1));
          visited[nR][nC] = false;
          visitedChar.remove((Character)board[nR][nC]);
        }
      }
    }
    return maxLength;
  }

  private static boolean isValidPath(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C ) return false;
    return true;
  }

  private static boolean isVisitedChar(char ch) {
    return visitedChar.contains(ch);
  }
}