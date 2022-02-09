package tutorials.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJ2263 {
    static int n;
    static int[] in, post, position;

    public static void pre(int inS, int inE, int postS, int postE) {
        if (inS > inE || postS > postE) {
            return;
        }
        int root = post[postE];
        System.out.print(root + " ");
        int idx = position[root];    //인오더 루트 인덱스
        int left = idx - inS;   //왼쪽 자식의 수
        pre(inS, idx - 1, postS, postS + left - 1);
        pre(idx + 1, inE, postS + left, postE - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        in = new int[n + 1];
        post = new int[n + 1];
        position = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            position[in[i]] = i; // 인오더에서 루트의 위치를 저장해주는 인덱스배열
        }

        pre(0, n - 1, 0, n - 1);
    }

}
