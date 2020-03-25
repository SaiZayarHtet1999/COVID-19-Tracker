package com.ucs_tgi.trackcovid.ui.country;

public class covidCountry {

    String mCovidCountry, mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mActive, mCritical;

    public covidCountry(String mCovidCountry, String mCases, String mTodayCases, String mDeaths, String mTodayDeaths, String mRecovered, String mActive, String mCritical) {
        this.mCovidCountry = mCovidCountry;
        this.mCases = mCases;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.mTodayDeaths = mTodayDeaths;
        this.mRecovered = mRecovered;
        this.mActive = mActive;
        this.mCritical = mCritical;
    }

    public String getmCovidCountry() {
        return mCovidCountry;
    }

    public String getmCases() {
        return mCases;
    }

    public String getmTodayCases() {
        return mTodayCases;
    }

    public String getmDeaths() {
        return mDeaths;
    }

    public String getmTodayDeaths() {
        return mTodayDeaths;
    }

    public String getmRecovered() {
        return mRecovered;
    }

    public String getmActive() {
        return mActive;
    }

    public String getmCritical() {
        return mCritical;
    }

}
