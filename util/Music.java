package util;

import android.content.Context;
import android.media.MediaPlayer;

import com.jacmobile.droidsense.R;

public class Music 
{
	private Context context;
	
	public Music(Context context)
	{
		this.context = context;
	}
	/*
	 * sound 0 : droid
	 * sound 1 : flux
	 */
	public void playSound(int sound) {
		try
		{
			switch (sound)
			{
			case 0:
				final MediaPlayer startPlayer = MediaPlayer.create(context, R.raw.droid);
				startPlayer.setVolume(0.75f, 0.75f);
				
				startPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
				{
					@Override
					public void onCompletion(MediaPlayer mp) 
					{
						startPlayer.release();
					}
				});
				startPlayer.start();
				
				break;
			case 1:
				final MediaPlayer fluxPlayer = MediaPlayer.create(context, R.raw.arc);
				fluxPlayer.setVolume(0.25f, 0.25f);
				
				fluxPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
				{
					@Override
					public void onCompletion(MediaPlayer mp) 
					{
						fluxPlayer.release();
					}
				});
				fluxPlayer.start();
				
				break;
			}
		} catch(Throwable t)
		{}
	}
}
