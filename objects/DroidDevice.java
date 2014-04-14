package objects;

import com.jacmobile.droidsense.R;

import util.Device;
import android.content.Context;
import android.content.res.Resources;

public class DroidDevice extends ADevice 
{	
	private Resources mRes;
	
	private String mSDK;
	private String mModel;
	private String mProduct;
	private String mOSVersion;
	private String mOSIncrement;
	
	private String[] mDeviceAttribs;
	
	public DroidDevice(Context context, Device device) 
	{
		super(context, device);
		
		mRes = context.getResources();
		
		mModel = device.getModel();
		mProduct = device.getProduct();
		mOSVersion = device.getOSVersion();
		mOSIncrement = device.getOSVersionIncremental();
		mSDK = device.getSDKVersion();
		
		mDeviceAttribs = mRes.getStringArray(R.array.device_array);
	}
	public String getModel() 
	{
		return mModel;
	}

	public String getProduct() 
	{
		return mProduct;
	}

	public String getOSVersion() 
	{
		return mOSVersion;
	}

	public String getOSIncrement() 
	{
		return mOSIncrement;
	}

	public String getSDK() 
	{
		return mSDK;
	}
	@Override
	public String toString() 
	{
//		device has 5 attributes model, product, os, increment, sdk
		return mDeviceAttribs[0] + getModel() + '\n' +
				mDeviceAttribs[1] + getProduct() + '\n' +
				mDeviceAttribs[2] + getOSVersion() + '\n' +
				mDeviceAttribs[3] + getOSIncrement() + '\n' +
				mDeviceAttribs[4] + getSDK();
	}
}