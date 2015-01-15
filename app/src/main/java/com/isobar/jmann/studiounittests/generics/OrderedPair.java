package com.isobar.jmann.studiounittests.generics;

/**
 * Created by jmann on 1/2/15.
 */
public class OrderedPair<K, V> implements Pair {

    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}


