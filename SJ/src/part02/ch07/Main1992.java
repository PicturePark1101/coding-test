package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {

  private static String[][] board;
  private static String ansStr = "";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    board = new String[N][N];
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().split("");
    }

    System.out.println(find(N, 0, 0));
  }

  private static String find(int N, int r, int c) {
    if (N == 1) {
      return board[r][c];
    }

    String str = "";

    str += "("+find(N / 2, r , c);
    str += find(N / 2, r , c + N / 2);
    str += find(N / 2, r + N / 2 , c);
    str += find(N / 2, r + N / 2 , c + N / 2);

    if (str.contains("0") && str.contains("1")) {
      return ansStr+str+")";
    } else if (str.contains("0")){
      return ansStr+"0";
    } else {
      return ansStr+"1";
    }
  }
}
