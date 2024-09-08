package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    search((int) Math.pow(2, N), R, C);
    System.out.println(count);
  }

  private static void search(int N, int R, int C) {
    if (N == 1) {
      return;
    }

    if (R < N / 2  && C < N / 2) {
      search(N / 2, R, C);
    } else if (R < N / 2 && C >= N / 2) {
      count += (N * N / 4);
      search(N / 2, R, C - N / 2);
    } else if (R >= N / 2 && C < N / 2) {
      count += (N * N / 4) * 2;
      search(N / 2, R - N / 2, C);
    } else {
      count += (N * N / 4) * 3;
      search(N / 2, R - N / 2, C - N / 2);
    }
  }
}
