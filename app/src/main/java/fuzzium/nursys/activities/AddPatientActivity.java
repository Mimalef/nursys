package fuzzium.nursys.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Patient;
import fuzzium.nursys.entities.Telephone;

public class AddPatientActivity extends ActionBarActivity implements View.OnClickListener {

    private Button regpatient,viewPatient;
    private EditText fname,lname,address,insurance;
    List<EditText> tells = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        initContol();
        // ActionBar bar = getActionBar();
        //bar.hide();
    }

    private void initContol() {

        regpatient=(Button) findViewById(R.id.regPatient);
        viewPatient=(Button)findViewById(R.id.viewPatient);
        regpatient.setOnClickListener(this);
        viewPatient.setOnClickListener(this);


        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        address=(EditText)findViewById(R.id.address);
        insurance=(EditText)findViewById(R.id.insurance);
        EditText tell=(EditText)findViewById(R.id.phone);
        tells.add(tell);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regPatient:{
                Patient savePatient=new Patient();
                savePatient.setFname(fname.getText().toString());
                savePatient.setLname(lname.getText().toString());
                savePatient.setAddress(address.getText().toString());
                savePatient.setInsurance(3333);
                savePatient.save();


                for(int i=0; i < tells.size(); i++){
                    Telephone patienttel=new Telephone();
                    patienttel.setTell(tells.get(i).getText().toString());
                    patienttel.patient=savePatient;
                    patienttel.save();

                }


                break;
            }
            case R.id.viewPatient:
            {
                this.startActivity(new Intent(this,SelectPatientActivity.class));
            }
        }
    }
    public void addTell(View view) {


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.GroupLayout);
        EditText editTextView = new EditText(this);
        editTextView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        editTextView.setLayoutParams(params);
        editTextView.setHint("????? ????");
        editTextView.setWidth(300);
        linearLayout.addView(editTextView);
        tells.add(editTextView);
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
