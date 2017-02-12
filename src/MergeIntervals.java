import Experience.LinkList;

import java.util.*;
/**
 * Created by apple on 17/2/11.
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 注意事项：
 1. 使用匿名内部类的两个前提条件：必须继承一个父类或实现一个接口。
 2. 按Interval中start排序。
 3. 当前Interval的start与上一个end比大小，如果有重叠，则返回新的边界。
 4. 两个counter(分别是start和end)维护区间Interval边界.
 */
public class MergeIntervals {
    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
    //方法二：可以采用内部类方法
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // 方法一： Sort by ascending starting point using an anonymous Comparator
        /*
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        */
        Collections.sort(intervals,new IntervalComparator()); //方法二

        //List<Interval> result = new LinkedList<Interval>(); //链表
        List<Interval> result = new ArrayList<>();
        //两个counter维护区间边界start和end
        int start = intervals.get(0).start; //返回头位置的start数值
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
    public static void main(String[] args) {
        MergeIntervals mySolution = new MergeIntervals();
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < 10; i = i + 2) {
           list.add(mySolution.new Interval(i, i + 1));
        }
        //before
        for (int i = 0; i < list.size(); i++)
            System.out.print("[" + list.get(i).start + "," + list.get(i).end + "]" + "\t");

        List<Interval> l = mySolution.merge(list);
        // after
        System.out.println();
        for (int i = 0; i < l.size(); i++)
            System.out.print("[" + l.get(i).start + "," + l.get(i).end + "]" + "\t");
    }
}
