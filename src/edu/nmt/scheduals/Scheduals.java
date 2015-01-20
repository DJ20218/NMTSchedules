package edu.nmt.scheduals;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class Scheduals extends Activity
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
}
