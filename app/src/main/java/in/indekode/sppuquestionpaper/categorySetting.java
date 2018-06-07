package in.indekode.sppuquestionpaper;

import android.content.Intent;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import in.indekode.sppuquestionpaper.Sharedpreference.PrefManager;

public class categorySetting extends AppCompatActivity {

    Spinner spinnerYear = (Spinner) findViewById(R.id.spinner_year);
    Spinner spinnerBranch = (Spinner) findViewById(R.id.spinner_branch);
    Button buttonEnter = (Button)findViewById(R.id.enter_button);
    String stringYear, stringBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_setting);

        if (new PrefManager(this).isUserLogedOut()){
            startHomeActivity();
        }
        //Year
        ArrayAdapter<CharSequence> staticAdapterYear = ArrayAdapter
                .createFromResource(this, R.array.choiceYear,
                        android.R.layout.simple_spinner_item);
        staticAdapterYear
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerYear.setAdapter(staticAdapterYear);

        //Branch
        ArrayAdapter<CharSequence> staticAdapterBranch = ArrayAdapter
                .createFromResource(this, R.array.choiceBranch,
                        android.R.layout.simple_spinner_item);

        staticAdapterBranch
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBranch.setAdapter(staticAdapterBranch);


        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onNothingSelected(spinnerYear) && onNothingSelected(spinnerYear)){
                    Toast.makeText(getApplicationContext(), "You should choose above", Toast.LENGTH_SHORT).show();
                }
                else{
                    attempLogin();
                    startHomeActivity();
                    saveEnterDetails(stringYear,stringBranch);
                }
            }
        });
    }

    private void attempLogin(){
        stringYear = spinnerYear.getSelectedItem().toString();
        stringBranch = spinnerBranch.getSelectedItem().toString();

    }

    private void startHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void saveEnterDetails(String year, String branch){
        new PrefManager(this).saveEnterDetails(year, branch);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id){
    /*
        switch (parent.getId()){
            case R.id.spinner_year:
                        stringYear = parent.getSelectedItem().toString();
                break;

            case R.id.spinner_branch:
                       stringBranch = parent.getSelectedItem().toString();
                break;
        }
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)*/
    }

    public boolean onNothingSelected(AdapterView<?> parent) {
        // Another interface callback

        return  false;
    }

}
