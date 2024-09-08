package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
  private static int N;
  private static int[] board;
  private static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new int[N];
    queen(0);
    System.out.println(ans);
  }

  private static void queen(int depth) {
    if (depth == N) {
      ans++;
      return;
    }

    for (int i = 0; i < N; i++) { // 1개 놓을 때 마다
      board[depth] = i;
      if (isValidPath(depth)) {
        queen(depth + 1);
      }
    }
  }

    private static boolean isValidPath(int col) { // 열
      for (int i = 0; i < col; i++) {
        if (board[i] == board[col]) return false;
        if (Math.abs(board[col] - board[i]) ==  Math.abs(col - i)) {
          return false;
        }
      }
      return true;
    }
}
