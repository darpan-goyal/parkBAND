package local;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyoAppLogicRunner
{
	private String userName;
	private String passWord;
	
	public MyoAppLogicRunner(String userName, String passWord)
	{
		this.userName = userName;
		this.passWord = passWord;
		System.out.println(this.userName);
	}
		
	public void run() throws Exception
	{
		ExeRunner exe = new ExeRunner();
		exe.execute();
		FileNameFinder find = new FileNameFinder();
		find.search();
		CSVParser parse = new CSVParser(find.getWanted(), find.getWanted2());
		String gyro = parse.findGyroMean();
		System.out.println(gyro);
		String emg = parse.findEmgMean();
		System.out.println(emg);
		String Data = "fn=upload&gyro="+gyro+"&emg="+emg+"&username="+userName+"&pass="+passWord;
		URL url = new URL("https://myo-health.azurewebsites.net/conn.php?");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.getOutputStream().write(Data.getBytes("UTF-8"));
        con.getInputStream();
	}
}
