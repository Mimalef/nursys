package fuzzium.nursys.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import fuzzium.nursys.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener  {


    private Button addPatient, addService, Schedule, newPeroid;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void initControl() {

        addPatient = (Button) findViewById(R.id.buttonAddPatient);
        addPatient.setOnClickListener(this);
        addPatient = (Button) findViewById(R.id.buttonSchedule);
        addPatient.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonAddPatient: {
                this.startActivity(new Intent(this,AddPatientActivity.class));

                 }
                break;

            case R.id.buttonSchedule: {


            }
            break;

        }
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

}
