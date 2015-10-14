package fuzzium.nursys.activities;

import android.annotation.TargetApi;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Patient;

public class SelectPatientActivity extends ActionBarActivity {
    private ArrayAdapter<Patient> adapter;
    private ListView listView;
    private List<Patient> patients;
    private EditText searchPatient;
    private Patient selectedPatient;
    @TargetApi(11)
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);


        listView = (ListView) findViewById(R.id.patientList);
        searchPatient = (EditText) findViewById(R.id.searchPatient);


        patients = Patient.listAll(Patient.class);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, patients);
        listView.setAdapter(adapter);


        final ActionMode.Callback modeCallBack = new ActionMode.Callback() {
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
                mode = null;
                getSupportActionBar().show();

            }
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {


                getSupportActionBar().hide();
                mode.getMenuInflater().inflate(R.menu.menu_select_patient, menu);
                return true;

            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.view: {
                        Toast.makeText(getApplicationContext(), "Item ... ! "+ selectedPatient.getFname()+" "+selectedPatient.getLname(), Toast.LENGTH_LONG).show();
                        mode.finish();
                        break;
                    }
                    case R.id.delete: {
                        Toast.makeText(getApplicationContext(), "Item  deleted! "+selectedPatient.getFname()+" "+selectedPatient.getLname(), Toast.LENGTH_LONG).show();
                        selectedPatient.delete();
                        mode.finish();

                        break;
                    }
                    case R.id.edit: {
                        Toast.makeText(getApplicationContext(), "Item  edited! "+selectedPatient.getFname()+" "+selectedPatient.getLname(), Toast.LENGTH_LONG).show();
                        mode.finish();
                        break;
                    }
                    default:
                        return false;
                }

                return true;

            }
        };


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
                startActionMode(modeCallBack);
                view.setSelected(true);
                view.getFocusables(position);
                selectedPatient =(Patient) (listView.getItemAtPosition(position));
                return true;
            }
        });


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
        if (id == R.id.Item1) {
            Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Item2) {
            Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Item3) {
            Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

