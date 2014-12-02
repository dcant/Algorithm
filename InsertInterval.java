package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class InsertInterval {
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		ArrayList<Interval> res = ii.insert(intervals, new Interval(4,9));
		for (Interval item : res)
			System.out.println(item.start + ":" + item.end);
	}

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> res = new ArrayList<Interval>();
	    if(intervals==null)
	        return intervals;
        if (intervals.size() == 0) {
        	res.add(newInterval);
            return res;
        }
	    boolean flag = false;
	    int i = 0;
	    if (newInterval.start < intervals.get(0).start) {
	    	res.add(newInterval);
	    	flag = true;
	    }
	    else {
	    	res.add(intervals.get(0));
	    	i++;
	    }
	    for(;i<intervals.size();i++)
	    {
	        if (!flag && newInterval.start < intervals.get(i).start) {
	        	flag = true;
	        	if (res.get(res.size() - 1).end >= newInterval.start) {
	        		if (newInterval.end >= intervals.get(i).start)
	        			res.get(res.size() - 1).end = Math.max(newInterval.end, intervals.get(i).end);
	        		else {
	        			res.get(res.size() - 1).end = Math.max(newInterval.end, res.get(res.size() - 1).end);
	        			res.add(intervals.get(i));
	        		}
	        	} else {
        			if (newInterval.end >= intervals.get(i).start) {
        				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        				res.add(newInterval);
        			} else {
        				res.add(newInterval);
        				res.add(intervals.get(i));
        			}
	        	}
	        } else {
	        	if (res.get(res.size() - 1).end >= intervals.get(i).start)
	        		res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
	        	else
	        		res.add(intervals.get(i));
	        }
	    }
	    if (!flag) {
    		if (res.get(res.size() - 1).end >= newInterval.start)
    			res.get(res.size() - 1).end = Math.max(newInterval.end, res.get(res.size() - 1).end);
    		else
    			res.add(newInterval);
	    }
	    return res;
	}
}
