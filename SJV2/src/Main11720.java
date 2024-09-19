import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main11720 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println(calcSum(br.readLine().split(""), N));
  }

  private static int calcSum(String[] nums, int N) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += Integer.parseInt(nums[i]);
    }
    return sum;
  }
}
