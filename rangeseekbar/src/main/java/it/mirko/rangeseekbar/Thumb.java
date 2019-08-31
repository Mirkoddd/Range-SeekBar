package it.mirko.rangeseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

public class Thumb extends FrameLayout {

    private Rect thumb;
    private View scrubber;
    private Paint disableCircle;
    private int circleRadius;

    Thumb(Context context) {
        super(context);
        setWillNotDraw(false);

        int thumbSize = context.getResources().getDimensionPixelSize(R.dimen.thumb_size);
        thumb = new Rect(0, 0, thumbSize, thumbSize);
        disableCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        disableCircle.setStyle(Paint.Style.STROKE);
        disableCircle.setStrokeWidth(context.getResources().getDimension(R.dimen.line));
        circleRadius = context.getResources().getDimensionPixelSize(R.dimen.circle_radius);

        addRipple(context);


        addScrubber(context);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2, getHeight()/2, circleRadius, disableCircle);
    }

    private void addRipple(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View ripple = new View(context);
            ripple.setBackgroundResource(getStyledValueFor(context, android.R.attr.selectableItemBackgroundBorderless));
            int rippleSize = context.getResources().getDimensionPixelSize(R.dimen.ripple_size);
            LayoutParams rippleLayoutParams = new LayoutParams(rippleSize, rippleSize);
            rippleLayoutParams.gravity = Gravity.CENTER;
            addView(ripple, rippleLayoutParams);
        }
    }

    private void addScrubber(Context context){
        scrubber = new View(context);
        int colorAccent = ContextCompat.getColor(context, getStyledValueFor(context, R.attr.colorControlActivated));

        Drawable drawable = getResources().getDrawable(R.drawable.seekbar_thumb_material_anim);
        Drawable wrapDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapDrawable, colorAccent);
        scrubber.setBackground(wrapDrawable);

        int scrubberSize = context.getResources().getDimensionPixelSize(R.dimen.scrubber_size);
        LayoutParams scrubberLayoutParams = new LayoutParams(scrubberSize, scrubberSize);
        scrubberLayoutParams.gravity = Gravity.CENTER;
        addView(scrubber, scrubberLayoutParams);
    }

    void setColor(int color){
        Drawable drawable = scrubber.getBackground();
        Drawable wrapDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapDrawable, color);
        scrubber.setBackground(wrapDrawable);
    }

    void setDisableCircleColor(int color){
        disableCircle.setColor(color);
    }

    static int getStyledValueFor(Context context, int attr){
        TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attr, value, true);
        return value.resourceId;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        scrubber.setVisibility(enabled ? VISIBLE : INVISIBLE);
        disableCircle.setAlpha(enabled ? 0 : 255);
        invalidate();
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    int getHalfThumbWidth() {
        return thumb.width() / 2;
    }

    int getThumbWidth() {
        return thumb.width();
    }

}
