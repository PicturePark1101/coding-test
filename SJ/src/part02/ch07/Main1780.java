package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780 {

  private static int[][] board;
  private static int[] ansList = {0, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for (int i = 0 ; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0 ; j < N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    find(0, 0, N);
    for (int i = 0; i < 3; i++) {
      System.out.println(ansList[i]);
    }
  }


  private static void find(int r, int c, int n) {
    if (!isValid(r, c, n)) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          find(r + (n / 3 * i), c + (n / 3 * j), n / 3);
        }
      }
    } else {
      ansList[board[r][c] + 1]++;
    }
  }
  private static boolean isValid(int r, int c, int n) {
    int start = board[r][c];
    for (int i = r; i < r + n; i++) {
      for (int j = c; j < c + n; j++) {
        if (start != board[i][j]) return false;
      }
    }
    return true;
  }
}
