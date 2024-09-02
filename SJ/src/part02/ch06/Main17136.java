package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136 {
  private static int[][] board;
  private static int[] paperNums = {0, 5, 5, 5, 5, 5};
  private static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    board = new int[10][10];
    min = Integer.MAX_VALUE;

    for (int i = 0; i < 10; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 10; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, 0);
    if (min == Integer.MAX_VALUE) min = -1;
    System.out.println(min);
    br.close();
  }

  private static void dfs(int r, int c, int count) {

    // 탐색 종료조건
    if (r == 9 && c == 10) {
      min = Math.min(min, count);
      return;
    }

    if (count >= min) return;
    if (c >= 10) {
      dfs(r + 1, 0, count);
      return;
    }

    if (board[r][c] == 1) {
      for (int j = 5; j >= 1; j--) {
        if (isValid(r, c, j) && paperNums[j] > 0) {
          paperNums[j]--;
          attach(r, c, j);
          dfs(r, c + 1, count + 1);
          paperNums[j]++;
          detach(r, c, j);
        }
      }
    } else {
      dfs(r, c + 1, count);
    }
  }

  private static void attach(int r, int c, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[r + i][c + j] = N;
      }
    }
  }

  private static void detach(int r, int c, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[r + i][c + j] = 1;
      }
    }
  }

  private static boolean isValid(int r, int c, int N) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (r + i >= 10 || c + j >= 10) return false;
        if (board[r + i][c + j] != 1) {
          return false;
        }
      }
    }
    return true;
  }
}