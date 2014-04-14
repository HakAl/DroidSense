package objects;

import android.content.Context;
import android.hardware.Sensor;

public abstract class ASensor 
{
//	Application context
	protected Context mContext;
//	The sensor
	protected Sensor mSensor;
//	Type # 1-13 for standard sensors. 14 - 20 for new Sensors
	protected int mType;
//	Each sensor is represented by an icon
	protected int mIcon;
	/*
	 * Sensor properties
	 */
	protected String mName;
	protected String mVendor;
	protected String mPower;
	protected String mResolution;
	protected String mRange;
	protected String mDelay;
	
	public ASensor(Context context, Sensor sensor)
	{
		this.mContext = context;
		this.mSensor = sensor;
	}
}
