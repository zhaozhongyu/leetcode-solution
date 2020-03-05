package leetcode.old;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        for(int i = 0; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(interval.end < newInterval.start ){
                if(i == intervals.size() -1){ //最后一个
                    intervals.add(newInterval);
                }
                continue;
            }
            else if(interval.start > newInterval.end){
                intervals.add(i, newInterval);
                break;
            }
            //从这里开始处理
            int start = Math.min(interval.start, newInterval.start);
            int end = newInterval.end;
            if(interval.end < newInterval.end){
                for(int j = i+1; j < intervals.size(); ){
                    if (intervals.get(j).start > newInterval.end) {
                        break;
                    }
                    if(intervals.get(j).end >= newInterval.end){
                        end = intervals.get(j).end;
                        intervals.remove(j);
                        break;
                    } else {
                        intervals.remove(j);
                    }
                }
                intervals.remove(i);
                intervals.add(i, new Interval(start, end));
                break;
            } else {
                intervals.remove(i);
                intervals.add(i, new Interval(start, interval.end));
                break;
            }
        }
        if(intervals.size() == 0){
            intervals.add(newInterval);
        }
        return intervals;
    }
}