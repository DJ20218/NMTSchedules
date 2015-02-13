package edu.nmt.schedules;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
//TODO: Make use animations, and proper layout changing
public class Schedules extends Activity
{
    private int count = 0;
    int card_flip_time_full=2;
    int card_flip_time_half=1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageviewer);
	getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment())
                    .commit();
    }
    /**
     * A fragment representing the front of the card.
     */
    public class CardFrontFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            return inflater.inflate(R.layout.main, container, false);
        }
    }
    private void flipCard() {
        //if (mShowingBack) {
        //    getFragmentManager().popBackStack();
        //    return;
        //}
        // Flip to the back.
        //mShowingBack = true;
        // Create and commit a new fragment transaction that adds the fragment for the back of
        // the card, uses custom animations, and is part of the fragment manager's back stack.
        getFragmentManager()
            .beginTransaction()
            // Replace the default fragment animations with animator resources representing
            // rotations when switching to the back of the card, as well as animator
            // resources representing rotations when flipping back to the front (e.g. when
            // the system Back button is pressed).
            .setCustomAnimations(
                    R.animator.flipleftin, R.animator.flipleftout,
                    R.animator.flipleftin, R.animator.flipleftout)
            // Replace any fragments currently in the container view with a fragment
            // representing the next page (indicated by the just-incremented currentPage
            // variable).
            .replace(R.id.container, new CardBackFragment())
            // Add this transaction to the back stack, allowing users to press Back
            // to get to the front of the card.
            .addToBackStack(null)
            // Commit the transaction.
            .commit();
    }
    /**
     * A fragment representing the back of the card.
     */
    public class CardBackFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            return inflater.inflate(R.layout.stabby, container, false);
        }
    }
    //Called when the button gets pressed
    public void countUp(View view){
	count+=1;
	TextView texty = (TextView) findViewById(R.id.mytextview);	
	texty.setText("Hello World: "+count);
    }
    //called when we switch to stab view
    public void stab(View view) {
	    flipCard();
    }
}
