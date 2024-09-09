package part04.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Board {
  private int r;
  private int c;

  public Board(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}

public class Main2573 {
  private static int N;
  private static int M;
  private static int[][] board;
  private static int[] dx = {-1, 0, 0, 1};
  private static int[] dy = {0, 1, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    int ans = 0;
    while ((count = countSeparate()) < 2){ // 2보다 적으면 계속 녹인다.
      if (count == 0) {
        ans = 0;
        break;
      }
      ans++; // ans 증가
      melting();
    }

    System.out.println(ans);
    br.close();
  }

  // 개수 구해
  private static int countSeparate() {
    int count = 0;
    boolean[][] visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] > 0 && !visited[i][j]) {
          dfs(i, j, visited); // 방문
          count++;
        }
      }
    }
    return count;
  }

  private static void melting() {
    Queue<Board> queue = new LinkedList<>();
    boolean[][] validIceberg = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] > 0) {
          queue.offer(new Board(i, j));
          validIceberg[i][j] = true;
        }
      }
    }

    while (!queue.isEmpty()) {
      Board b = queue.poll();
      int count = 0;
      for (int i = 0; i < 4; i++) {
        int newR = b.getR() + dx[i];
        int newC = b.getC() + dy[i];

        if (!isValid(newR, newC)) { // 유효한 값인지 검사하기
          continue;
        }
        if (!validIceberg[newR][newC] && board[newR][newC] == 0) { // 0이면 증가시킴
          count++;
        }
      }
      if (board[b.getR()][b.getC()] - count < 0) {
        board[b.getR()][b.getC()] = 0;
      } else {
        board[b.getR()][b.getC()] -= count;
      }
    }
  }

  private static void dfs(int r, int c, boolean[][] visited) {
    visited[r][c] = true;
    for (int i = 0; i < 4; i++) {
      int newR = r + dx[i];
      int newC = c + dy[i];

      if (!isValid(newR, newC)) {
        continue;
      }
      if (!visited[newR][newC] && board[newR][newC] > 0) { // 유효한 길이고, 0이 아니면 방문한다.
        dfs(newR, newC, visited);
      }
    }
  }

  private static boolean isValid(int r, int c) {
    return r >= 0 && r < N  && c >= 0 && c < M;
  }
}

