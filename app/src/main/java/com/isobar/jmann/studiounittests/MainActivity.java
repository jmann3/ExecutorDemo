package com.isobar.jmann.studiounittests;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.isobar.jmann.studiounittests.executor.BlockingQueue;
import com.isobar.jmann.studiounittests.generics.Box;
import com.isobar.jmann.studiounittests.generics.MorePairs;
import com.isobar.jmann.studiounittests.generics.OrderedPair;
import com.isobar.jmann.studiounittests.generics.Pair;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    TextView txtGreeting;
    Box<Integer> box;
    OrderedPair<String, Integer> orderedPair1;
    OrderedPair<String, String> orderedPair2;

    BlockingQueue blockingQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for Unit Testing
        box = new Box<>();
        box.inspect(10);

        txtGreeting = (TextView)findViewById(R.id.greeting);
        Random rndGenerator = new Random();
        int rnd = rndGenerator.nextInt(4);
        String greeting = getGreeting(rnd);
        txtGreeting.setText(greeting);

        orderedPair1 = new OrderedPair<>();
        orderedPair2 = new OrderedPair<>();

        MorePairs<Integer, String> pair1 = new MorePairs<>(1, "apple");
        MorePairs<Integer, String> pair2 = new MorePairs<>(2, "pear");



    }

    @Override
    protected void onResume() {
        super.onResume();

        blockingQueue = new BlockingQueue();
        blockingQueue.startExecutor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        blockingQueue.stopExecutor();
    }

    public String getGreeting(int msgNumber) {

        String greeting;

        switch (msgNumber) {
            case 0:
                greeting = "Lisa";
                break;
            case 1:
                greeting = "Joshua";
                break;
            case 2:
                greeting = "Arielle";
                break;
            case 3:
                greeting = "Rachel";
                break;
            default:
                greeting = "no one";
                break;
        }

        return greeting;
    }
}
