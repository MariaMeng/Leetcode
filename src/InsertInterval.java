import java.util.*;

/**
 * Created by apple on 17/2/12.
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 解题思路：
 1.遍历原始的list<Interval></>列表，
 2.有重叠的部分，新newInterval的区间边界，
 3. newInterval == null 判断条件，是说如果newInterval 比其余的interval都小时，其余interval怎样处理。
 */
public class InsertInterval {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || interval.end < newInterval.start) // Disjoint interval, to the right of newInterval
                list.add(interval);
            else if (interval.start <= newInterval.end) {
                newInterval.end = Math.max(newInterval.end, interval.end); // Overlap interval, update newInterval
                newInterval.start = Math.min(newInterval.start, interval.start);
            } else { // Disjoint interval to the left of newInterval
                list.add(newInterval);
                newInterval = null;
                list.add(interval);
            }
        }
        if(newInterval != null) list.add(newInterval);
        return list;
    }

    public static void main(String[] args) {
        InsertInterval mySolution = new InsertInterval();
        List<InsertInterval.Interval>  list = new ArrayList<>();
        list.add(mySolution.new Interval(2, 5));
        list.add(mySolution.new Interval(6, 7));
        list.add(mySolution.new Interval(8, 9));
        Interval newInterval = mySolution.new Interval(0, 1);
        mySolution.insert(list, newInterval);
    }
}
