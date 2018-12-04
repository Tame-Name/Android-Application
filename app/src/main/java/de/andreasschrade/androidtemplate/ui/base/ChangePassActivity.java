package de.andreasschrade.androidtemplate.ui.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.andreasschrade.androidtemplate.R;
import de.andreasschrade.androidtemplate.ui.SettingsActivity;
import de.andreasschrade.androidtemplate.ui.quote.ListActivity;

public class ChangePassActivity extends AppCompatActivity {

    EditText ip;
    FirebaseAuth auth;
    private Button button_sav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        ip=(EditText)findViewById(R.id.editText);
        button_sav =(Button)findViewById(R.id.button_sr);
        button_sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back_main();
            }
        });
    }
    public void changep(View v){
        final FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234");
        user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    user.updatePassword(ip.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ChangePassActivity.this, "Change successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangePassActivity.this, "Fail to change", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void back_main(){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
}
