/**
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc&categoryId=AV5LwsHaD1MDFAXc&categoryType=CODE&&&
 */
 
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static char[][] minesweeper;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String str;
		int answer;

		for (int i = 1; i <= n; i++) {
			size = Integer.parseInt(br.readLine());
			minesweeper = new char[size][size];

			for (int j = 0; j < size; j++) {
				str = br.readLine();
				for (int k = 0; k < size; k++) {
					minesweeper[j][k] = str.charAt(k);
				}
			}
			
			answer = getMinClickCount();
			System.out.println("#" + i + " " + answer);
		}
	}

	public static int getMinClickCount() {
		char[][] mineCountArray = getMineCountArray();
		int count = 0;

		for (int i = 0; i < size; i++) {		//0부터 클릭
			for (int j = 0; j < size; j++) {
				if (mineCountArray[i][j] == '0' && minesweeper[i][j] == '.') {
					count++;
					clickMinesweeper(mineCountArray,i,j);
				}
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (minesweeper[i][j] == '.') {
					count++;
				}
			}
		}

		return count;
	}
	
	public static void clickMinesweeper(char[][] mineCountArray, int i, int j) {
		int nx, ny, count = 0;
		minesweeper[i][j] = mineCountArray[i][j];

		for (int k = 0; k < 8; k++) {
			nx = i + dx[k];
			ny = j + dy[k];

			if (isRange(nx, ny)) {
				if(minesweeper[nx][ny] == '.' && mineCountArray[nx][ny] == '0') {		//open하지않은 0이 있으면 0을 방문하여 open 
					clickMinesweeper(mineCountArray,nx,ny);
				}
				minesweeper[nx][ny] = mineCountArray[nx][ny];
			}
			
		}
	}

	public static char[][] getMineCountArray() {
		char[][] mineCountArray = deepCopy();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (mineCountArray[i][j] == '.') {
					mineCountArray[i][j] = getMineCount(i, j);
				}
			}
		}
		return mineCountArray;
	}

	public static char getMineCount(int i, int j) {
		int nx, ny, count = 0;

		for (int k = 0; k < 8; k++) {
			nx = i + dx[k];
			ny = j + dy[k];

			if (isRange(nx, ny) && minesweeper[nx][ny] == '*') {
				count++;
			}
		}
		return Character.forDigit(count, 10);
	}

	public static boolean isRange(int x, int y) {
		if (x < 0 || x >= size || y < 0 || y >= size) {
			return false;
		}
		return true;
	}
	
	public static char[][] deepCopy() {
	    char[][] copyArray = new char[size][size];
	    for (int i = 0; i < size; i++) {
	        System.arraycopy(minesweeper[i], 0, copyArray[i], 0, size);
	    }
	    return copyArray;
	}
	
}
