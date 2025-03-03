package com.example.trivia;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;
    private FbModule fbModule;
    private String backgrounColor="";
    private String c="1";

    private ConstraintLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll=findViewById(R.id.main);

        fbModule=new FbModule(this);

        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {

                        if (o.getResultCode()==RESULT_OK)
                        {
                            Intent data=o.getData();
                            String str=data.getStringExtra("color");
                           // Toast.makeText(MainActivity.this, ""+str, Toast.LENGTH_SHORT).show();
                            fbModule.writeBackgroundColorToFb(str);
                            c=str;


                        }

                    }
                }
        );

    }

    public void onStartGame(View view) {
        Intent intent=new Intent(this, GameActivity.class);
        intent.putExtra("color",c);
        startActivity(intent);
    }

    public void onSetting(View view) {

        Intent i=new Intent(this, SettingActivity.class);
        launcher.launch(i);

    }

    public void onInstruction(View view) {
    }

    public void setNewColorFromFb(String str) {
        this.backgrounColor=str;
        //Toast.makeText(this, ""+backgrounColor, Toast.LENGTH_SHORT).show();
        setBackgrounColor(str);

    }

    public void setBackgrounColor(String color)
    {
        switch (color)
        {
            case "Red":
            {
                ll.setBackgroundColor(Color.argb(255,240,128,128));
                break;
            }
            case "Blue":
            {
                ll.setBackgroundColor(Color.argb(255,135,206,235));
                break;
            }
            case "Pink":
            {
                ll.setBackgroundColor(Color.argb(255,219,112,147));
                break;
            }

            case "Yellow":
            {
                ll.setBackgroundColor(Color.argb(255,255,250,205));
                break;
            }
            default:
                ll.setBackgroundColor(Color.WHITE);
        }
    }
}