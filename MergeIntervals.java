package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		List<Interval> res = mi.merge(intervals);
		for (Interval item : res)
			System.out.println(item.start + ":" + item.end);
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	    ArrayList<Interval> res = new ArrayList<Interval>();
	    if(intervals==null || intervals.size()==0)
	        return intervals;
	    Comparator<Interval> comp = new Comparator<Interval>()
	    {
	        @Override
	        public int compare(Interval i1, Interval i2)
	        {
	            if(i1.start==i2.start)
	                return i1.end-i2.end;
	            return i1.start-i2.start;
	        }
	    };
	    Collections.sort(intervals,comp);
	    
	    res.add(intervals.get(0));
	    for(int i=1;i<intervals.size();i++)
	    {
	        if(res.get(res.size()-1).end>=intervals.get(i).start)
	        {
	            res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
	        }
	        else
	        {
	            res.add(intervals.get(i));
	        }
	    }
	    return res;
	}
}
