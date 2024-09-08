package part04.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2606 {
  private static int N;
  private static int M;
  private static List<Integer>[] info;
  private static boolean[] visited;
  private static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    info = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    ans = 0;

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

    dfs(1);
    System.out.println(ans);
  }

  private static void dfs(int n) {
    visited[n] = true;
    for (int i = 0; i < info[n].size(); i++) {
      int node = info[n].get(i);
      if (!visited[node]) {
        ans++;
        dfs(node);
      }
    }
  }
}