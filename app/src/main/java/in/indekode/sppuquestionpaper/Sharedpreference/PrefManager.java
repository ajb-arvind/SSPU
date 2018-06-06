package in.indekode.sppuquestionpaper.Sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    Context context;

    public PrefManager(Context context) {
        this.context = context;
    }

    public void saveEnterDetails(String year, String branch){
        SharedPreferences sharedPreferences = context.getSharedPreferences("EnterDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Year", year);
        editor.putString("Branch", branch);
        editor.commit();
    }

    public String getYear() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("EnterDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Year", "");
    }

    public String getBranch() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("EnterDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Branch", "");
    }

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("EnterDetails", Context.MODE_PRIVATE);
        boolean isYearEmpty = sharedPreferences.getString("Year", "").isEmpty();
        boolean isBranchEmpty = sharedPreferences.getString("Branch", "").isEmpty();
        return isYearEmpty || isBranchEmpty;

    }

}
