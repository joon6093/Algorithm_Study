import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        int start=1;
        int end=M;
        int count=0;

        int q=Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++){
            int landing=Integer.parseInt(br.readLine());
            if(landing>end){
                count+=landing-end;
                start+=landing-end;
                end=landing;
            }

            if(landing<start){
                count+=start-landing;
                end-=start-landing;
                start=landing;
            }
        }

        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}