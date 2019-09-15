import java.io.*;
import java.util.*;

public class swea_7829 {
	static int N;
	static int n,k;
	static LinkedList<Integer> divisor = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			divisor.clear();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
      
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				divisor.add(Integer.parseInt(st.nextToken()));
			}
      
			divisor.sort(null);
			bw.write("#" + (i + 1) + " "+findNum()+"\n");
			bw.flush();
		}

	}
	public static int findNum(){
		int answer = 0;
		if(divisor.size() % 2 == 1) {
			int middle =  divisor.get(divisor.size()/2);
			answer = middle*middle;
		}else {
			answer = divisor.get(0) * divisor.get(divisor.size()-1);
		}
		return answer;
	}

}
