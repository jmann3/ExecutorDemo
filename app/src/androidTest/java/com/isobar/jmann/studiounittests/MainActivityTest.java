package com.isobar.jmann.studiounittests;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

/**
 * Created by jmann on 1/13/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {


    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testGetGreeting() throws Exception {

        MainActivity activity = getActivity();

        int count = 0;

        String result = activity.getGreeting(count);

        assertEquals("Lisa", result);

        count = 1;

        result = activity.getGreeting(count);

        assertEquals("Bonjour tout le monde", result);

        count = 2;

        result = activity.getGreeting(count);

        assertEquals("Arielle", result);

        count = 3;

        result = activity.getGreeting(count);

        assertEquals("Hallo Welt", result);
    }
}
