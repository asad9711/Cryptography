package com.example.asad.learnclipboard;

/**
 * Created by Asad on 17-07-2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Created by Asad on 17-07-2016.
 */
public class DecryptActivity extends AppCompatActivity {

    EditText ed1;
    TextView tv;
    Button b1,b2;
    byte[] decrypted;
    String decryptedText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decrypt_activity);
        ed1 = (EditText) findViewById(R.id.decrypteditText);
        b1 = (Button) findViewById(R.id.decryptbutton);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("asd","inside onclick");
                try {
                    Log.d("asd","inside try of decryptActivity");
                    KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
                    SecretKey secretkey = keygenerator.generateKey();
                    Cipher cipher2 = Cipher.getInstance("Blowfish");
                      cipher2.init(Cipher.DECRYPT_MODE,secretkey);
                    Log.d("asd","in decrypt key is"+secretkey.toString());
                    Log.d("asd","before getBytes");
                    byte[] encrypted =ed1.getText().toString().getBytes();
                    Log.d("asd",ed1.getText().toString());
                    decrypted = cipher2.doFinal(encrypted);
                    tv=(EditText)findViewById((R.id.textView));
                    tv.setText("Asd");
                    Log.d("asd",new String(decrypted));
                } catch (Exception e) {
                }
                Toast.makeText(getApplicationContext(), "Text Pasted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
