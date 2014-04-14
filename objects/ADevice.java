package objects;

import util.Device;
import android.content.Context;

public abstract class ADevice 
{
	protected Device mDevice;
	protected Context mContext;

	protected String mSDK;
	protected String mModel;
	protected String mProduct;
	protected String mOSVersion;
	protected String mOSIncrement;
	
	public ADevice(Context context, Device device)
	{
		mDevice = device;
		mContext = context;
	}
}
