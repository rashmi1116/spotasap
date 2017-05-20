package rashmi.sampleproject.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ViewFlipper;

/**
 * Created by rashmi.ramesh on 20-05-2017.
 */

public class ViewFlipperPoints  extends ViewFlipper {


    Paint paint = new Paint();

    public ViewFlipperPoints(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        int width = getWidth();

        float margin = 7;
        float radius = 10;
        float cx = (width / 2 - ((radius + margin) * 2 * getChildCount() / 2));
        float cy = getHeight() -  30;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++)
        {
            if (i == getDisplayedChild())
            {
                paint.setColor(Color.WHITE);
                canvas.drawCircle(cx, cy, radius, paint);

            } else
            {
                paint.setColor(Color.LTGRAY);
                canvas.drawCircle(cx, cy, radius, paint);
            }
            cx += 2 * (radius + margin);
        }
        canvas.restore();
    }

}
