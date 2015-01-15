package com.isobar.jmann.studiounittests;

import android.test.InstrumentationTestCase;

/**
 * Created by jmann on 12/31/14.
 */
public class ExampleTest extends InstrumentationTestCase {

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}
