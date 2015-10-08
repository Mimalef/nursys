package fuzzium.nursys.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Patient;

public class SelectPatientActivity extends ActionBarActivity {
    private ArrayAdapter<Patient> adapter;
    private ListView listView;
    private List<Patient> patients;
    private EditText searchPatient;


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);


        listView = (ListView) findViewById(R.id.patientList);
        searchPatient = (EditText) findViewById(R.id.searchPatient);


        patients = Patient.listAll(Patient.class);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, patients);
        listView.setAdapter(adapter);


        listView.setTextFilterEnabled(true);
        searchPatient.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

                adapter.getFilter().filter(arg0.toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }


            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_patient, menu);
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
