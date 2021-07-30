package com.example.android.earthquake;

public class Earthquake {
    //declare private string value
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String murl;

    //constructor
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url)
    {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        murl = url;
    }


    //public function for private string value
    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return murl;
    }
}
