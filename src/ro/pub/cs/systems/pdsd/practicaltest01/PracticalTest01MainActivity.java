package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        if (savedInstanceState != null) {
        	CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        	cb1.setChecked(savedInstanceState.getBoolean("check1"));
        	
        	CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        	cb2.setChecked(savedInstanceState.getBoolean("check2"));
        	
        	EditText e1 = (EditText) findViewById(R.id.editText1);
        	e1.setText(savedInstanceState.getString("text1"));
        	
        	EditText e2 = (EditText) findViewById(R.id.editText2);
        	e2.setText(savedInstanceState.getString("text2"));
        }
        
        final EditText t1 = (EditText)findViewById(R.id.editText1);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					t1.setFocusable(true);
	                t1.setFocusableInTouchMode(true);
	                t1.setClickable(true);
				} else {
					t1.setFocusable(false);
	                t1.setFocusableInTouchMode(false);
	                t1.setClickable(false);
				}
			}
		});
        
        final EditText t2 = (EditText)findViewById(R.id.editText2);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					t2.setFocusable(true);
	                t2.setFocusableInTouchMode(true);
	                t2.setClickable(true);
				} else {
					t2.setFocusable(false);
	                t2.setFocusableInTouchMode(false);
	                t2.setClickable(false);
				}
			}
		});
        
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String txt1 = t1.getText().toString();
				String txt2 = t2.getText().toString();
				
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.practicaltest01.intent.action.SecondaryActivity");
				intent.putExtra("text1", txt1);
				intent.putExtra("text2", txt2);
				startActivityForResult(intent, 1);
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (requestCode == 1) {
    		if (resultCode == 0) {
    			Toast.makeText(this, "Received OK", Toast.LENGTH_SHORT).show();;
    		} else if (resultCode == 1) {
    			Toast.makeText(this, "Received Cancel", Toast.LENGTH_SHORT).show();
    		}
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	EditText e1 = (EditText) findViewById(R.id.editText1);
    	String txt1 = e1.getText().toString();
    	savedInstanceState.putString("text1", txt1);
    	
    	EditText e2 = (EditText) findViewById(R.id.editText2);
    	String txt2 = e2.getText().toString();
    	savedInstanceState.putString("text2", txt2);
    	
    	CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
    	savedInstanceState.putBoolean("check1", cb1.isChecked());
    	
    	CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
    	savedInstanceState.putBoolean("check2", cb2.isChecked());
    }
}
