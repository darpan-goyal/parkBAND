package local;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class FileNameFinder 
{
	String str;
	private static Pattern fileExtnPtrn = Pattern.compile("gyro-([0-9]*).csv");
	private static Pattern fileExtnPtrn2 = Pattern.compile("emg-([0-9]*).csv");
	private File wanted;
	private File wanted2;
	private String timestamp = "";
	
	public FileNameFinder()
	{
		wanted = new File(".");
		wanted2 = new File(".");
	}

	public void search() throws Exception 
	{
		File dir = new File(".");
		File [] files = dir.listFiles();
		
			for(File file: files) {
				if(validateFileExtn(file.getName())) {
					System.out.println("This method works");
					wanted = file;
					System.out.println(wanted.getName());
				}
				if(validateFileExtn2(file.getName())) {
					wanted2 = file;
				}
			}
			//String str = wanted.getName().substring(5);
			Date date = new Date();
			timestamp = Long.toString(date.getTime());
			
			
	}
	
	public static boolean validateFileExtn(String name){
         
        Matcher mtch = fileExtnPtrn.matcher(name);
        if(mtch.matches()){
            return true;
        }
        return false;
	}
	public static boolean validateFileExtn2(String name){
        
        Matcher mtch = fileExtnPtrn2.matcher(name);
        if(mtch.matches()){
            return true;
        }
        return false;
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	
	public File getWanted()
	{
		return wanted;
	}
	
	public File getWanted2()
	{
		return wanted2;
	}
	
	public String getTimeStamp()
	{
		return timestamp;
	}
	

}
