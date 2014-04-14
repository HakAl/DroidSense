package objects;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class DroidSensorList 
{
	private Context mContext;
	private SensorManager mSensorManager;
	private ArrayList<Sensor> mSensors;
	private ArrayList<DroidSensor> mDroidSensors;
	
	public DroidSensorList(Context context)
	{
		mContext = context;
		mSensorManager = (SensorManager) mContext.getSystemService(Activity.SENSOR_SERVICE);
		mSensors = new ArrayList<Sensor>(mSensorManager.getSensorList(Sensor.TYPE_ALL));
		mDroidSensors = new ArrayList<DroidSensor>(getCount());
		getListElements();
	}
	
	public String[] getTitles()
	{
		String[] result = new String[getCount()];
		for (int i = 0; i < getCount(); i++)
		{
			result[i] = mDroidSensors.get(i).toString();
		}
		return result;		
	}
	
	public Integer[] getIcons()
	{
		Integer[] result = new Integer[getCount()];
		for (int i = 0; i < getCount(); i++)
		{
			result[i] = mDroidSensors.get(i).getIcon();
		}
		return result;
	}
	
	public ArrayList<DroidSensor> getList()
	{
		return mDroidSensors;
	}
	
	private void getListElements() 
	{
		for( int i = 0; i < getCount(); i++ )
		{
			Sensor temp = mSensors.get(i);
			
			if ( temp.getType() == Sensor.TYPE_ACCELEROMETER )
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_MAGNETIC_FIELD)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_ORIENTATION)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_GYROSCOPE)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_LIGHT)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_PRESSURE)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_TEMPERATURE)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_PROXIMITY)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_GRAVITY)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_LINEAR_ACCELERATION)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_ROTATION_VECTOR)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_RELATIVE_HUMIDITY)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_GYROSCOPE_UNCALIBRATED)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_SIGNIFICANT_MOTION)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_STEP_DETECTOR)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_STEP_COUNTER)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			} else if ( temp.getType() == Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)
			{
				mDroidSensors.add(new DroidSensor(mContext, temp));
			}
		}
	}

	public int getCount() 
	{
		return mSensors.size();
	}
}
