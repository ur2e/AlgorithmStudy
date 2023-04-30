import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start,end);
        }

        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for (int i = 1; i < n; i++){
            if (pq.peek() <= lectures[i].start){
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }

        bw.write(pq.size()+"");

        bw.flush();
        bw.close();
        br.close();
    }

}

class Lecture{
    int start;
    int end;

    Lecture(int start, int end){
        this.start = start;
        this.end = end;
    }
}