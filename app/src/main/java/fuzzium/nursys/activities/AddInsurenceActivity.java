package fuzzium.nursys.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import fuzzium.nursys.R;
import fuzzium.nursys.entities.Insurence;

/**
 * Created by yasi on 10/7/2015.
 */


//
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        student_name_et = (EditText) findViewById(R.id.student_name_et);
        address_et = (EditText) findViewById(R.id.address_et);
        teacher_sp = (Spinner) findViewById(R.id.teacher_sp);
        reset_btn = (Button) findViewById(R.id.reset_btn);
        submit_btn = (Button) findViewById(R.id.submit_btn);

        try {
            // This is how, a reference of DAO object can be done
            // Need to find out list of TeacherDetails from database, so initialize DAO for TeacherDetails first
            final Dao<TeacherDetails, Integer> teachDao = getHelper().getTeacherDao();

            // Query the database. We need all the records so, used queryForAll()
            teacherList = teachDao.queryForAll();

            // Populate the spinner with Teachers data by using CustomAdapter
            teacher_sp.setAdapter(new CustomAdapter(this,android.R.layout.simple_spinner_item, android.R.layout.simple_spinner_dropdown_item, teacherList));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        reset_btn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);
    }

    // This is how, DatabaseHelper can be initialized for future use
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return databaseHelper;
    }

    *
    * */
public class AddInsurenceActivity extends ActionBarActivity {

    private EditText insurenceType,discount;
    private List<Insurence> insurenceList;
    private Spinner insur_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_insurence);
        initContol();
    }

    private void initContol() {

        insurenceType=(EditText)findViewById(R.id.insurencname);
        discount=(EditText)findViewById(R.id.insuranceDiscount);
        insur_sp = (Spinner) findViewById(R.id.insur_sp);
        insurenceList=Insurence.listAll(Insurence.class);
        ArrayAdapter<Insurence> dataAdapter = new ArrayAdapter<Insurence>(this, android.R.layout.simple_spinner_item, insurenceList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        insur_sp.setAdapter(dataAdapter);
    }


    public void registerInsurence(View view) {
        Insurence newInsurence=new Insurence();
        newInsurence.setDiscount(Integer.parseInt(discount.getText().toString()));
        newInsurence.setInsurenceType(insurenceType.getText().toString());
        newInsurence.save();
        Insurence in=new Insurence();
        in=(Insurence)insur_sp.getSelectedItem();
        Toast.makeText(this,String.valueOf(in.getDiscount()),Toast.LENGTH_SHORT).show();
    }

}
