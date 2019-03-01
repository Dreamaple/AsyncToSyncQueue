package com.example.dreamaple.testinstants;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);


        AsyncToSyncQueueThread.getInstance().startWorkQueue(new UnitEngineering(-1, false, 1) {
            @Override
            void execute() {
                Log.i("11", "--------exec" + String.valueOf(getId()));
                findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("11", "--------view" + String.valueOf(getId()));
                        AsyncToSyncQueueThread.getInstance().addQueueWithTemp();
                    }
                });
            }
        });
        findViewById(R.id.btn).setOnClickListener(view -> {
            for (int i = 0; i < 10; i++) {
                AsyncToSyncQueueThread.getInstance().addingWorks(new UnitEngineering(i, false, 1) {
                    @Override
                    void execute() {
                        Log.i("11", "--------exec" + String.valueOf(getId()));
                        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("11", "--------view" + String.valueOf(getId()));
                                AsyncToSyncQueueThread.getInstance().addQueueWithTemp();
                            }
                        });
                    }
                });
            }
        });
    }
}
