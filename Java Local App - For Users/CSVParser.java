package local;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class CSVParser
{
	private File gyro;
	private File emg;
	private String gyroMean;
	private String emgMean;
	public FileReader readGyro;
	public FileReader readEmg;
	public BufferedReader bufferGyro;
	public BufferedReader bufferEmg;
	private Float[] gyroSum = new Float[2500];
	private Float[] emgSum = new Float[26000];

	int count = 0;
	
	public CSVParser(File gyro, File emg)
	{
		this.gyro = gyro;
		this.emg = emg;
		
		try {
			readGyro = new FileReader(this.gyro);
			bufferGyro = new BufferedReader(readGyro);
		}
		catch(Exception e)
		{
			System.out.println("Error. Gyro file not found");
		}
		
		try {
			readEmg = new FileReader(this.emg);
			bufferEmg = new BufferedReader(readEmg);
		}
		catch(Exception e)
		{
			System.out.println("Error. Emg file not found");
		}
	}
	
	public String findGyroMean() throws Exception
	{
		String line = "";
		try {
			bufferGyro.readLine();
			float sum = 0;
			while((line = bufferGyro.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				gyroSum[count] = Math.abs(Float.valueOf(splitLine[1]));
				sum += gyroSum[count];
				System.out.println(sum);
				count++;
			}
			sum = sum/count;			
			System.out.println("The float sum of gyro is: " + Float.toString(sum));
			return Float.toString(sum);
		}
		catch(Exception e)
		{
			System.out.println("");
			return line;
		}
		
		
	}
	
	public String findEmgMean() throws Exception
	{ 
		count = 0;
		String line = "";
		try {
			bufferEmg.readLine();
			float sum = 0;
			while((line = bufferEmg.readLine()) != null)
			{
				String[] splitLine = line.split(",");
				emgSum[count] = Math.abs(Float.valueOf(splitLine[5]));
				sum += emgSum[count];
				count++;
			}
			sum = sum/count;
			System.out.println("The float sum of emg is: " + Float.toString(sum));
			return Float.toString(sum);
		}
		catch(Exception e)
		{
			System.out.println("");
			return line;
		}
		
	}
}
