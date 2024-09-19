import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
  private static int N;
  private static int M;
  private static int[] nums;
  private static int[] S;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nums = new int[N + 1];
    S = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    makeS();
    for (int k = 1; k <= M; k++) {
      st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      int i = Integer.parseInt(st.nextToken());
      sb.append(String.valueOf(S[i] - S[j - 1])).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static void makeS() {
    for (int i = 1; i <= N; i++) {
      S[i] += nums[i] + S[i - 1];
    }
  }
}