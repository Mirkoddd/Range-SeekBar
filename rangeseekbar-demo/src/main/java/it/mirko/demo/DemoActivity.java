package it.mirko.demo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import it.mirko.rangeseekbar.OnRangeSeekBarListener;
import it.mirko.rangeseekbar.RangeSeekBar;

public class DemoActivity extends AppCompatActivity implements OnRangeSeekBarListener {

    private RangeSeekBar rangeSeekBar;
    private TextView startText, endText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        declareViews();

        setupViews();
    }

    private void declareViews() {
        rangeSeekBar = findViewById(R.id.rangeSeekBar);
        startText = findViewById(R.id.startValue);
        endText = findViewById(R.id.endValue);
    }

    private void setupViews(){
        rangeSeekBar.setStartProgress(20); // default is 0
        rangeSeekBar.setEndProgress(80); // default is 50
        rangeSeekBar.setMinDifference(15); // default is 20
        startText.setText(String.valueOf(rangeSeekBar.getStartProgress()));
        endText.setText(String.valueOf(rangeSeekBar.getEndProgress()));
        rangeSeekBar.setOnRangeSeekBarListener(this);
    }

    @Override
    public void onRangeValues(RangeSeekBar rangeSeekBar, int start, int end) {
        switch (rangeSeekBar.getId()){ // this only in case you have multiple Range Seek Bars
            case R.id.rangeSeekBar:
                startText.setText(String.valueOf(start));
                endText.setText(String.valueOf(end));
                break;
        }
    }
}
