package com.ardhendu.internetstatus;

/*
https://razablog.com/how-to-check-internet-status-in-android/
 */
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(haveNetwork()){
            Toast.makeText(MainActivity.this,"network access",Toast.LENGTH_SHORT).show();

        }
        else{
            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,R.style.AppTheme);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Please Check Your Network Connection...");
            progressDialog.show();
        }
    }
    private boolean haveNetwork() {
        boolean have_WIFI = false;
        boolean have_MobileData = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) ;
            if (info.isConnected())
                if (info.isConnected())
                    have_WIFI = true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE"))
                if (info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData || have_WIFI;
    }
}