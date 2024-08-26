package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {

  static int[][] nums;
  static boolean[] visited;
  static int N;
  static int cost;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    visited = new boolean[N];
    nums = new int[N][N];
    cost = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        nums[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      dfs(i, i, 0, 0);
    }

    System.out.println(cost);
  }

  private static void dfs(int start, int now, int depth, int sum) {

    if (depth == N - 1) {
      if (nums[now][start] != 0) {
        cost = Math.min(sum + nums[now][start], cost);
      }
      return;
    }

    for (int j = 0 ; j < N; j++) {
      if (!visited[j] && nums[now][j] != 0) {
        visited[j] = true;
        dfs(start, j, depth + 1, sum + nums[now][j]);
        visited[j] = false;
      }
    }
  }
}