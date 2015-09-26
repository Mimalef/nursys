package fuzzium.nursys.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Patient;

public class AddPatientActivity extends ActionBarActivity implements View.OnClickListener {

    private Button regpatient,viewPatient;
    private EditText name,address,insurance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        initContol();
    }

    private void initContol() {

        regpatient=(Button) findViewById(R.id.regPatient);
        viewPatient=(Button)findViewById(R.id.viewPatient);
        regpatient.setOnClickListener(this);
        viewPatient.setOnClickListener(this);


        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.address);
        insurance=(EditText)findViewById(R.id.insurance);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regPatient:{
                Patient savePatient=new Patient();
                savePatient.setName(name.getText().toString());
                savePatient.setAddress(address.getText().toString());
                savePatient.setInsurance(3333);
                savePatient.setRegDate(33333);
                savePatient.save();


                break;
            }
            case R.id.viewPatient:
            {
                this.startActivity(new Intent(this,ViewPatient.class));
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_patient, menu);
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
