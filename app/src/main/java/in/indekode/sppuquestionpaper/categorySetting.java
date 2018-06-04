package in.indekode.sppuquestionpaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class categorySetting extends AppCompatActivity {

    Spinner spinnerYear = (Spinner) findViewById(R.id.spinner_year);
    Spinner spinnerBranch = (Spinner) findViewById(R.id.spinner_branch);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_setting);

        ArrayAdapter<CharSequence> staticAdapterYear = ArrayAdapter
                .createFromResource(this, R.array.choiceYear,
                        android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdapterBranch = ArrayAdapter
                .createFromResource(this, R.array.choiceBranch,
                        android.R.layout.simple_spinner_item);

        staticAdapterYear
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticAdapterBranch
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerYear.setAdapter(staticAdapterYear);
        spinnerBranch.setAdapter(staticAdapterBranch);

    }
}
