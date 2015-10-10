package fuzzium.nursys.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.andreabaccega.widget.FormEditText;

import java.util.ArrayList;
import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Insurence;
import fuzzium.nursys.entities.Patient;
import fuzzium.nursys.entities.Telephone;

public class AddPatientActivity extends ActionBarActivity  {

    private EditText address;
    private FormEditText fname,lname,tell;

    List<EditText> tells = new ArrayList<>();

    private List<Insurence> insurenceList;
    private Spinner insur_sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        initContol();

    }

    private void initContol() {

        fname=(FormEditText)findViewById(R.id.fname);
        lname=(FormEditText)findViewById(R.id.lname);
        tell=(FormEditText)findViewById(R.id.phone);
        tells.add(tell);//add to tell lists

        address=(EditText)findViewById(R.id.address);

        insur_sp = (Spinner) findViewById(R.id.insur_sp);
        insurenceList=Insurence.listAll(Insurence.class);
        ArrayAdapter<Insurence> dataAdapter = new ArrayAdapter<Insurence>(this, android.R.layout.simple_spinner_item, insurenceList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        insur_sp.setAdapter(dataAdapter);
        insur_sp.setPrompt("بیمه تحت پوشش");



    }

    public void AddPatientOpration(View view) {

        FormEditText[] allFields    = { fname, lname, tell };


        boolean allValid = true;
        for (FormEditText field: allFields) {
            allValid = field.testValidity() && allValid;
        }

        if (!allValid) {
            showMessageDialog(" تمام فیلدها را وارد کنید! All files must be filled");
        }
        else {
            Insurence patientInsurence = new Insurence();
            patientInsurence = (Insurence) insur_sp.getSelectedItem();
            patientInsurence.save();

            Patient savePatient = new Patient();
            savePatient.setFname(fname.getText().toString());
            savePatient.setLname(lname.getText().toString());
            savePatient.setAddress(address.getText().toString());
            savePatient.save();

            savePatient.insurance = patientInsurence;

            for (int i = 0; i < tells.size(); i++) {
                Telephone patienttel = new Telephone();
                patienttel.setTell(tells.get(i).getText().toString());
                patienttel.patient = savePatient;
                patienttel.save();

            }
            showDialog();

        }
    }
     public void StartSelcetPatientActivity(View view) {
        this.startActivity(new Intent(this,SelectPatientActivity.class));

    }
    public void addTell(View view) {


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.GroupLayout);
        FormEditText editTextView = new FormEditText(this);
        editTextView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        editTextView.setLayoutParams(params);
        editTextView.setHint("تلفن");
        editTextView.setWidth(300);
        editTextView.setError("عدد وارد کنید");
        linearLayout.addView(editTextView);
        tells.add(editTextView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_patient, menu);
        return true;
    }
    private void showMessageDialog(final String message)
    {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void showDialog()
    {
        // After submission, Dialog opens up with "Success" message. So, build the AlartBox first
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Set the appropriate message into it.
        alertDialogBuilder.setMessage("موفق به ثبت! register successfuly");

        // Add a positive button and it's action. In our case action would be, just hide the dialog box
        // so no need to write any code for that.
        alertDialogBuilder.setPositiveButton("اضافه کردن",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });

        // Add a negative button and it's action. In our case, just open up the ViewStudentRecordActivity screen
        //to display all the records
        alertDialogBuilder.setNegativeButton("مشاهده",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Intent negativeActivity = new Intent(getApplicationContext(),SelectPatientActivity.class);
                        startActivity(negativeActivity);
                        finish();

                    }
                });

        // Now, create the Dialog and show it.
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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
