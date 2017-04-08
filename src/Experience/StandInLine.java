package Experience;

import java.util.*;

/**
 * Created by apple on 17/4/7.
 */
public class StandInLine {
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        System.out.println(helper(n, s));
    }
    private static int helper(int n, String s) {
        List<Interval> intervals = findIntervals(n, s);
        List<Interval> result = merge(intervals);

        find(result, s);
        return count;
    }
    private static void find(List<Interval> list, String s) {
        for (Interval interval : list) {
            for (int i = interval.start; i <= interval.end; i++) {
                char c = s.charAt(i);
                if (c == 'X') {
                    count++;
                }
            }
        }
    }
    private static List<Interval> findIntervals(int n, String s) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // 数字
                int range = Integer.parseInt(c + "");
                int left = (i - range) >= 0 ? i - range : 0;
                int right = (i + range) < n ? i + range : n - 1;
                list.add(new Interval(left, right));
            }
        }
        return list;
    }
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        //add last element in intervals
        result.add(new Interval(start, end));
        return result;
    }

}
class Interval{
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }

}
