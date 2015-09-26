package fuzzium.nursys.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Patient;

/**
 * Created by yasi on 9/26/2015.
 */
 public class ViewPatient extends ListActivity
{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        List<Patient> patients = Patient.listAll(Patient.class);
        setListAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, patients));


    }


}
