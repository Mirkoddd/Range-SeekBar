package it.mirko.rangeseekbar;

/**
 * Callback that returns the start and the end range values of RangeSeekBar
 */
public interface OnRangeSeekBarListener {
    /**
     * @param rangeSeekBar The {@link RangeSeekBar} which is returning the below values
     * @param start Start value returned by this callback
     * @param end End value returned by this callback
     */
    void onRangeValues(RangeSeekBar rangeSeekBar, int start, int end);
}
