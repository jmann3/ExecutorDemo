package com.isobar.jmann.studiounittests.generics;

import android.util.Log;

import java.util.List;

/**
 * Created by jmann on 1/2/15.
 */
public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        Log.d("Box", "U is " + u.getClass().getName());
    }

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        for (Box<U> box : boxes) {
            U boxContents = box.get();
        }
    }
}
