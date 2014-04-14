package util;
/*
 * This method uses double-checked locking, which should not be used prior 
 * to J2SE 5.0, as it is vulnerable to subtle bugs. 
 * The problem is that an out-of-order write may allow the instance reference
 * to be returned before the Singleton constructor is executed.
 */
public class Device 
{
	private static volatile Device instance = null;
	 
	private Device() {	}
 
	public static Device getInstance() 
	{
		if (instance == null) 
		{
			synchronized (Device.class)
			{
				if (instance == null) 
				{
					instance = new Device();
                }
			}
		}
		return instance;
	}
	/*
	 * Model is the end-user-visible name of the product
	 */
	public String getModel() 
	{
		return android.os.Build.MODEL;
	}
	/*
	 * The name of the overall product
	 */
	public String getProduct() 
	{
		return android.os.Build.PRODUCT;
	}
	/*
	 * OS (kernel) version
	 */
	public String getOSVersion() 
	{
		return System.getProperty("os.version");
	}
	/*
	 * Internal value used by underlying source control to represent this build. 
	 */
	public String getOSVersionIncremental() 
	{
		return android.os.Build.VERSION.INCREMENTAL ;
	}
	/*
	 * The user-visible SDK version of the framework; 
	 * its possible values are defined in Build.VERSION_CODES
	 */
	public String getSDKVersion() 
	{
		return ""+android.os.Build.VERSION.SDK_INT;
	}	 
}
