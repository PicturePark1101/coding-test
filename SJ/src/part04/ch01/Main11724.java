package part04.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11724 {
  private static int N;
  private static int M;
  private static ArrayList<Integer>[] info;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    info = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++) {
      info[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      info[a].add(b);
      info[b].add(a);
    }

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        ans++;
        dfs(i);
      }
    }
    System.out.println(ans);
  }

  private static void dfs(int node) {
    for (int i = 0; i < info[node].size(); i++) {
      int n = info[node].get(i);
      if (!visited[n]) {
        visited[n] = true;
        dfs(n);
      }
    }
  }
}