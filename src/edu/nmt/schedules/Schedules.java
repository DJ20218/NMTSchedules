package edu.nmt.schedules;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;

public class Schedules extends Activity
{
    private int count = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void countUp(View view){
	count+=1;
	TextView texty = (TextView) findViewById(R.id.mytextview);	
	texty.setText("Hello World: "+count);
    }
    public void stab(View view) {
	setContentView(R.layout.stabby);
    }



}
