package net.woowa_bros_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 우아한형제들 짝수번 겹치는 구간 구하기
// n 은 1 ~ 5 * 10 ^ 8 까지
public class Main02 {
    static int N;
    static Range[] ranges;
    static List<Range> result;
    static Set<Integer> vtxs = new TreeSet<>();

    static class Range implements Comparable<Range> {
        int start;
        boolean startInc;
        int end;
        boolean endInc;

        public Range(int start, boolean startInc, int end, boolean endInc){
            this.start = start;
            this.startInc = startInc;
            this.end = end;
            this.endInc = endInc;
        }

        @Override
        public int compareTo(Range range){
            if(this.start == range.start){
                return range.end - this.end;
            } else {
                return this.start - range.start;
            }
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Range == false) return false;
            Range range = (Range) obj;
            return this.start == range.start && this.startInc == range.startInc && this.end == range.end && this.endInc == range.endInc;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.start, this.startInc, this.end, this.endInc);
        }

        @Override
        public String toString(){
            char startC = this.startInc && (this.start > 0) ? '[' : '(';
            char endC = this.endInc && (this.end <= 2 * N) ? ']' : ')';
            String startV = (this.start > 0) ? Integer.toString(this.start) : "-";
            String endV = (this.end > 2 * N) ? "+" : Integer.toString(this.end);
            return String.format("%c%s, %s%c", startC, startV, endV, endC);
        }
    }

    static Range getOddRange(int start, int end) {
        int posCnt = 0;
        int count = 0;
        for(Range r : ranges){
            int left = r.start;
            int right = r.end;
            if(left <= start && end <= right) {
                posCnt += 1;
                count += 1;
            } else if(left == start || right == start) {
                posCnt += 1;
            }

            if(left >= end) break;
        }

        if(count % 2 == 0) {
            boolean included = posCnt % 2 == 0;
            return new Range(start, included, end, false);
        } else {
            boolean included = posCnt % 2 == 0;
            return new Range(start, included, start, included);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ranges = new Range[N];
        result = new ArrayList<>();

        vtxs.add(0);
        vtxs.add(2*N + 1);

        StringTokenizer st;
        for(int k=0;k<N;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            vtxs.add(start);
            vtxs.add(end);

            ranges[k] = new Range(start, true, end, true);
        }

        Arrays.sort(ranges);

        Integer[] visit = vtxs.toArray(new Integer[0]);
        for(int k=0;k<visit.length - 1;k++){
            result.add(getOddRange(visit[k], visit[k+1]));
        }

        Range[] tmp = result.toArray(new Range[0]);
        Stack<Range> res = new Stack<>();
        for(int k=0;k<tmp.length;k++){
            if(res.isEmpty()){
                res.push(tmp[k]);
            } else {
                Range temp = res.peek();
                if(temp.end == tmp[k].start) {
                    temp = res.pop();
                    temp.end = tmp[k].end;
                    temp.endInc = !temp.endInc && tmp[k].endInc ? true : false;
                    res.push(temp);
                } else {
                    if(tmp[k].start == tmp[k].end && !tmp[k].startInc) continue;
                    res.push(tmp[k]);
                }
            }
        }

        for(Range r : res) {
            System.out.println(r);
        }
    }
}
