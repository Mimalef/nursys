package fuzzium.nursys.activities;

import android.app.AlertDialog;
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

public class AddInsurenceActivity extends ActionBarActivity {

    private EditText insurenceType,discount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_insurence);
        initContol();
    }

    private void initContol() {

        insurenceType=(EditText)findViewById(R.id.insurencname);
        discount=(EditText)findViewById(R.id.insuranceDiscount);

    }


    public void registerInsurence(View view) {
        Insurence newInsurence=new Insurence();
        newInsurence.setDiscount(Integer.parseInt(discount.getText().toString()));
        newInsurence.setInsurenceType(insurenceType.getText().toString());
        newInsurence.save();
        showMessageDialog("ثبت شد!");

    }
    private void showMessageDialog(final String message)
    {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
