package in.suni.cushionloading;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/*
* Created by Sunil Subramannian
*/
public class MainActivity extends AppCompatActivity {
    CustomProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDialog = new CustomProgressDialog(MainActivity.this);
        findViewById(R.id.btnShowDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //******Show dialog******
                mDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //*****close dialog*****
                        mDialog.dismiss();
                    }
                },5000);
            }
        });
    }
}
