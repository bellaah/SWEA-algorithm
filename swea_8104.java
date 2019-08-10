import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] teamLevel = new int[21];
	static int n,k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(teamLevel,0);
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int count = 1;
			boolean flag = true;
			
			for(int j = 0; j < n; j++) {
				if(flag) {
					for(int l = 1; l <= k; l++) {
						teamLevel[l] += count ++;
					}
				}else {
					for(int l = k; l > 0; l--) {
						teamLevel[l] += count ++;
					}
				}
				flag = !flag;
			}
			
			bw.write("#"+(i+1)+" ");
			for(int j = 1; j <= k; j++) {
				bw.write(teamLevel[j]+" ");
			}
			bw.write("\n");
			bw.flush();
		}
			
	}

}
