package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public final class Controller implements IController{
	private String deli;
	private String fileName;
	private String[] line= {};

	public Controller(String fileName,String delimeter) {
		
		this.fileName=fileName;
		this.deli=delimeter;
	}

	public List<String[]> readTasks(List<String[]> table) {        //read the lines from the file 
		 try (BufferedReader buffer = new BufferedReader(
	            new FileReader(fileName))) {

	       String str;
	       while ((str = buffer.readLine()) != null) {
	    	   String[] lin= {"0","0","0","-1","-1","-1"};   // make the null elements temporally -1 so we can write later
	           line=str.split(deli);
	           if(line[2].equals("0") && line.length!=7) {
	        	   for(int i=0;i<3;i++) {
	        		   lin[i]=line[i]; 
	        	   }
	        	  table.add(lin);
	           }else{table.add(line);}
	       }
	       
		 } 
	    catch (IOException e) {
	           e.printStackTrace();
	    }
		return table;
        
    }
	

}	
	
	



