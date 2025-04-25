package dom;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;


public class Filters {
	
	private List<String[]> top2 = new ArrayList<String[]>();  //list to host top level tasks
	private List<String[]> pre2 = new ArrayList<String[]>();  //list to host tasks by certain prefix
	private List<String[]> idd2 = new ArrayList<String[]>();  //list to host tasks by certain id

	public Filters(List<String[]> top,List<String[]> pre,List<String[]> idd) {
		this.top2=top;
		this.pre2=pre;
		this.idd2=idd;
	}
	public List<String[]> getTop(List<String[]> top){  //gettoplevetasks
		for(String [] s :top) {
			if(Integer.parseInt(s[2])==0) {
				top2.add(s);
			}

		}
		return top2;
	}
	
	public List<String[]> getPrefix(List<String[]> pre,String prefix){   //gettasksbyprefix
		for(String [] s :pre) {
			String[] tasktext = s[1].split("\t"); 
			if(tasktext[0].contains(prefix)) {
				pre2.add(s);
			}
		}
		return pre2;
	}
	
	public List<String[]> getId(List<String[]> idd,int id){     //gettasksbyid
		for(String [] s :idd) {
			if(Integer.parseInt(s[0])==id) {
				idd2.add(s);
			}
		}
		return idd2;
	}
	
}
