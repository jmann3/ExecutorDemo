package com.isobar.jmann.studiounittests.generics;

/**
 * Created by jmann on 1/2/15.
 */
public class MorePairs<K, V> {

    private K key;
    private V value;

    public MorePairs(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Generic methods
    public void setKey(K key) {this.key = key;}
    public void setValue(V value) {this.value = value;}
    public K getKey() {return key;}
    public V getValue() {return value;}

}
