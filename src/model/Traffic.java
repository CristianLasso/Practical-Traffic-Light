package model;

import java.io.*;
import java.util.*;

public class Traffic {
	public final static String PATH_EXPORT = "data/startTimes.txt";
	
	private List<Long> startTimes;
	
	public Traffic() {
		startTimes = new ArrayList<Long>();
	}
	
	public void exportReport() throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File(PATH_EXPORT));
		String text = "";
		for(int i=0; i<startTimes.size(); i++) {
			text = text + (i+1) + " " + startTimes.get(i) + "\n";
		}
		pw.print(text);
		pw.close();
	}
	
	public void addStartTime(Long sTime) {
		startTimes.add(sTime);
	}
}
