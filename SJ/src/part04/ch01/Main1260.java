package part04.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

  private static int N;
  private static int M;
  private static int V;
  private static List<Integer>[] info;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    info = new ArrayList[N + 1];
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

    for (int i = 1; i <= N; i++) {
      info[i].sort(null);
    }

    visited = new boolean[N + 1];
    dfs(0, V);

    System.out.println();

    visited = new boolean[N + 1];
    bfs();

    br.close();
  }

  private static void dfs(int depth, int n) {
    if (depth == N) {
      return;
    }

    visited[n] = true;
    System.out.print(n + " ");

    for (int i = 0; i < info[n].size(); i++) {
      int node = info[n].get(i);
      if (!visited[node]) {
        dfs(depth + 1, node);
      }
    }
  }

  private static void bfs() {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(V);
    visited[V] = true;
    while (!queue.isEmpty()) {
      int poll = queue.poll();
      System.out.print(poll + " ");
      for (int i = 0; i < info[poll].size(); i++) {
        int node = info[poll].get(i);
        if (!visited[node]) {
          queue.add(node);
          visited[node] = true;
        }
      }
    }
  }
}