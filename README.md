# Range-SeekBar
Android Range SeekBar, as close as possible as the original SeekBar

<a href="https://media.giphy.com/media/izaEaghHGgV1gsybc2/giphy.gif"><img src="https://media.giphy.com/media/izaEaghHGgV1gsybc2/giphy.gif"/></a>

[![](https://jitpack.io/v/Mirkoddd/Range-SeekBar.svg)](https://jitpack.io/#Mirkoddd/Range-SeekBar) 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/25c70ef8d1fc49799edff02490dc4882)](https://www.codacy.com/app/Mirkoddd/Range-SeekBar?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Mirkoddd/Range-SeekBar&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Installation

Add it in your root `build.gradle` at the end of repositories:

```gradle
allprojects {
   	repositories {
   		...
   		maven { url "https://jitpack.io" }
   	}
}
```

Add the dependency in your android app module's `build.gradle` file.

```gradle
dependencies {
    implementation 'com.github.Mirkoddd:Range-SeekBar:1.0.9'
}
```

## Usage

Add `RangeSeekBar` in your `.xml` layout like a normal `SeekBar`:

```xml
<it.mirko.rangeseekbar.RangeSeekBar
    android:layout_margin="8dp"
    android:id="@+id/rangeSeekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
Declare your `RangeSeekBar` in your `Activity` or `Fragment`:

```java
RangeSeekBar rangeSeekBar = findViewById(R.id.rangeSeekBar);
```

then setup your `RangeSeekBar` values:

```java
rangeSeekBar.setStartProgress(20); // default is 0
rangeSeekBar.setEndProgress(80); // default is 50
```
`setStartProgress(int startProgress)` set the left thumb initial progress
<br/>
`setEndProgress(int endProgress)` set the right thumb initial progress

By default the minimum threshold between the `startProgress` and the `endProgress` is `20` but you can edit it:

```java
rangeSeekBar.setMinDifference(15); // default is 20
```

To keep track of your new values you can set a `OnRangeSeekBarListener` letting it implement by your `Activity` or `Fragment`:

```java

...

public class ExampleActivity extends AppCompatActivity implements OnRangeSeekBarListener{

...

rangeSeekBar.setOnRangeSeekBarListener(this);

...

    @Override
    public void onRangeValues(RangeSeekBar rangeSeekBar, int start, int end) {
//        switch (rangeSeekBar.getId()){ // this only in case you have multiple Range Seek Bars
//            case R.id.rangeSeekBar:
                startText.setText(String.valueOf(start)); // example using start value
                endText.setText(String.valueOf(end)); // example using end value
//                break;
//        }
    }

...

```

You can refer the [example](https://github.com/Mirkoddd/Range-SeekBar/tree/master/rangeseekbar-demo).

## Customization

`RangeSeekBar` is designed to be as close as possible similar to `SeekBar`, so the customization is pretty standard:
<br/>
you can only change the max total progress with `setMax(int maxProgress)` (default is 100);
<br/>
you can change `rangeColor` and `trackColor` with `setRangeColor(int color)` and `setTrackColor(int color)`.
<br/>

```java
rangeSeekBar.setMax(120); // default is 100
rangeSeekBar.setRangeColor(Color.BLUE);
rangeSeekBar.setTrackColor(Color.LTGRAY);
```
## License

```license
Copyright 2019 Mirko Dimartino

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
