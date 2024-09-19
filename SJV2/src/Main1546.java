import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1546 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.valueOf(br.readLine());
    double[] nums = new double[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Double.valueOf(st.nextToken());
    }

    System.out.println(calcAvg(nums, max(nums)));

    br.close();
  }

  private static double max(double[] nums) {
    double max = Double.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    return max;
  }

  private static double calcAvg(double[] nums, double max) {
    double sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum / max * 100 / nums.length;
  }
}