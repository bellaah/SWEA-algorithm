import java.io.*;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int n, m, answer = 0;
		String str, tmp, sub = "";
		int[] decimalNum = new int[8];
		String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };

		for (int i = 1; i <= num; i++) {
			int count = 0;
			boolean isFind = false;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				str = br.readLine();
				for (int k = m - 1; k >= 0 && !isFind; k--) {
					if (str.charAt(k) == '1') {
						sub = str.substring(k - 55, k + 1);
						isFind = true;
					}
				}
			}

			for (int k = 0; k < sub.length(); k = k + 7) {
				tmp = sub.substring(k, k + 7);
				for (int l = 0; l < code.length; l++) {
					if (tmp.equals(code[l])) {
						decimalNum[count++] = l;
					}
				}
			}
			answer = (decimalNum[0] + decimalNum[2] + decimalNum[4] + decimalNum[6]) * 3 + decimalNum[1] + decimalNum[3]
					+ decimalNum[5] + decimalNum[7];
			if (answer % 10 == 0) {
				answer = 0;
				for (int j = 0; j < decimalNum.length; j++) {
					answer += decimalNum[j];
				}
			} else {
				answer = 0;
			}
			System.out.println("#" + i + " " + answer);
		}
	}
}
