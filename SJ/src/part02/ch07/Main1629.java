package part02.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1629 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    System.out.println(cal(A, B, C));

  }

  private static long cal(int A, int B, int C) {
    if (B == 1) { // 종료조건
      return A % C;
    }

    long temp = cal(A, B / 2, C);

    if (B % 2 == 1) {
      return (temp * temp % C) * A % C;
    }
    return temp * temp % C;
  }
}