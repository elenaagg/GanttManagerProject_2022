package dom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tasks {
	private List<String[]> table2 = new ArrayList<String[]>();
	private List<String[]> sortedtable = new ArrayList<String[]>();   //the final sorted table
	private int[] taski; //to calculate the elements that is not given to us
	private float[] costi;  //to calculate the elements that is not given to us
	private int MamaId;
	private int start;
	private int end;           
	private int taskid;
	private int cost;
	public Tasks (List<String[]> sortedtable,List<String[]> table) {

			this.sortedtable=sortedtable;
	        this.table2=table;
	}
	public List<String[]> sortTasks(List<String[]> table){
		int i=0;
		int[] taskidvalues= new int[table.size()];

		for(String [] s :table) {
				taskid = Integer.parseInt(s[0]);
				taskidvalues[i]=taskid;
				i++;
		}
		Arrays.sort(taskidvalues);     
		i=0;
		while (table2.size()<table.size()){
			for(String [] s :table) {
				if(Integer.parseInt(s[0])==taskidvalues[i]) {
					table2.add(s);
				}
			}
			i++;
		}
		i=0;
		int k=1;
		int[] startvalues= new int[table.size()];
		int[] Endvalues= new int[table.size()];

		for(String [] s :table2) {
			MamaId = Integer.parseInt(s[2]);
			start = Integer.parseInt(s[3]);
			end = Integer.parseInt(s[4]);
			if(MamaId!=0) {
				startvalues[i]=start;
				Endvalues[k]=end;
				k++;
			}
			i++;
		}
		
		int counter=0;
	    cost=0;
		i=0;
		taski= new int[table.size()];
		costi= new float[table.size()];
		for(String [] s :table2) {
			if(Integer.parseInt(s[2])!=0) {
				counter++;
				cost+=Integer.parseInt(s[5]);     //add the cost of the elements
			}
			else
			{taski[i]=counter;costi[i]=cost;i++;cost=0;}
		}
		taski[i]=counter;
		costi[i]=cost;		
		
		i=0;
        int j=1;
		for(String [] s :table2) {
			if(Integer.parseInt(s[2])==0) {
				s[3]=String.valueOf(startvalues[i+1]);         //fill in the missing elements
				s[4]=String.valueOf(Endvalues[taski[j]]);
				s[5]=String.valueOf(costi[j]);
				j++;
			}
			i++;
		}
		i=0;
		j=0;
		int[] startval= new int[table.size()];
		for(String [] s :table2) {
			int start = Integer.parseInt(s[3]);
			startval[i]=start;
			i++;
		}
	
			int c=0;
			int r=0;
			int h=0;
			int[] tabl = new int[table2.size()];

			while(taski[c+1]!=0) {                       //count the subtasks between top level
				int[] startvalues2 = new int[(taski[c+1]-taski[c])+1];
				for(int l=0;l<(taski[c+1]-taski[c])+1;l++) {
					startvalues2[l]=startval[h];
					h++;

				}
				Arrays.sort(startvalues2);           // sort them according to start values
				for(int l=0;l<startvalues2.length;l++) {
					tabl[r]=startvalues2[l];
					r++;
				}
				c++;
			}
			i=0;                                            // and the make the final tasklist with the sorted start values
			while (sortedtable.size()<table2.size()){
				for(String [] s :table2) {
					if(Integer.parseInt(s[3])==tabl[i] ) {
						sortedtable.add(s);
						i++;
						if(i==table2.size()) {
							break;
						}
					}
				}
			}
		
		return sortedtable;
		
		
	}
}
		
	
	
	
	
	
	
	

