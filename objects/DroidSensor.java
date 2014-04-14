package objects;
/**
 * A DroidSensor represents a particular sensor.
 * 
 * It contains the Sensor's title -- toString()
 * the description == getDescription()
 * a reference to the icon representing the sensor 
 */
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.hardware.Sensor;

import com.jacmobile.droidsense.R;

public class DroidSensor extends ASensor implements Comparable<DroidSensor>
{
//	Descriptions
	private String[] mDescriptions;
//	Sensor titles
	private String[] mSensorTitles;
//	Icon array
	private TypedArray mIcons;
//	Resources
	private Resources mRes;
	
	public DroidSensor(Context context, Sensor sensor) 
	{
		super(context, sensor);
//		Get resources
		mRes = context.getResources();
		
//		Load descriptions
		mDescriptions = mRes.getStringArray(R.array.sensor_descripts);
//		Load titles
		mSensorTitles = mRes.getStringArray(R.array.sensor_titles);
//		Set info for the sensor
		this.mDelay = "" + sensor.getMinDelay();
		this.mVendor = sensor.getVendor();
		this.mPower = "" + sensor.getPower();
		this.mName = sensor.getName();
		this.mRange = "" + sensor.getMaximumRange();
		this.mResolution = "" + sensor.getResolution();
//		Tells us which sensor it is
		this.mType = sensor.getType();
//		Get a reference to the sensor icon
		this.mIcon = getIcon();
	}
	public int getIcon() 
	{
		mIcons = mRes.obtainTypedArray(R.array.icons);
		int resId = mIcons.getResourceId(mType - 1, -1);
		mIcons.recycle();
		return resId;
	}
	/**
	 * Returns a String formatted as follows:
	 * Vendor: vendor
	 * Model: model
	 * Power Usage: power
	 * Resolution: resolution
	 * Max Range: range
	 * Min Delay: min delay
	 */
	public String getInfo()
	{
		String result = "";

		result += mRes.getString(R.string.vendor) + this.mVendor + '\n' +
				mRes.getString(R.string.make) + this.mName + '\n' +
				mRes.getString(R.string.power) + this.mPower + mRes.getString(R.string.milli_amp) + '\n' +
				mRes.getString(R.string.resolution) + this.mResolution + '\n' +
				mRes.getString(R.string.max_range) + this.mRange + '\n' +
				mRes.getString(R.string.min_delay) + this.mDelay + mRes.getString(R.string.micro_sec);
		
		return result;
	}
	public String getDescription()
	{
		return mDescriptions[this.mType - 1];
	}	
	/**
	 * Returns the name of the sensor.
	 */
	@Override
	public String toString() 
	{		
		return mSensorTitles[this.mType - 1];
	}
	/**
	 * Return 0 if equal; else -1.
	 */
	@Override
	public int compareTo(DroidSensor another) 
	{
		if (this.mType == another.mType)
			return 0;
		else 
			return -1;
	}
}
