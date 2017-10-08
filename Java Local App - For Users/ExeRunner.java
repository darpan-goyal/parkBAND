package local;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;

public class ExeRunner
{
	public void execute() throws Exception
	{
		Process pro = Runtime.getRuntime().exec("MyoDataCapture.exe");
		pro.waitFor(30L, TimeUnit.SECONDS);
		pro.destroy();
	}
}
