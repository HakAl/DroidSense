package util;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class BitmapResourceTask extends AsyncTask<Integer, Void, Bitmap>
{
	private final WeakReference<ImageView> imageViewReference;
    private int data = 0;
    private Context context;
    private int width, height;

    public BitmapResourceTask(ImageView imageView, Context context, int w, int h) 
    {
        // Use a WeakReference to ensure the ImageView can be garbage collected
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.context = context;
        this.width = w;
        this.height = h;
    }

    // Decode image in background.
    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return getSampledBitmap(context.getResources(), data, width, height);
    }

    // Once complete, see if ImageView is still around and set bitmap.
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

	
	public static int calculateInSampleSize(BitmapFactory.Options opts, int reqW, int reqH) 
	{
	    // Raw height and width of image
	    final int height = opts.outHeight;
	    final int width = opts.outWidth;
	    int inSampleSize = 1;
	
	    if (height > reqH || width > reqW) 
	    {
	
	        final int halfHeight = height / 2;
	        final int halfWidth = width / 2;
	
	        // Calculate the largest inSampleSize value that is POT and keeps both
	        // h and w larger than  reqH and reqW.
	        while ((halfHeight / inSampleSize) > reqH
	                && (halfWidth / inSampleSize) > reqW) 
	        {
	            inSampleSize *= 2;
	        }
	    }
	
	    return inSampleSize;
	}
	/*
	 * mImageView.setImageBitmap(
     *		decodeSampledBitmapFromResource(getResources(), R.id.myimage, 100, 100));
	 */
	public static Bitmap getSampledBitmap(Resources res, int resId, int reqW, int reqH) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqW, reqH);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
}
