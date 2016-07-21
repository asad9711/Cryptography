package com.example.asad.learnclipboard;

/**
 * Created by Asad on 17-07-2016.
 */

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
//import javax.xml.bind.DatatypeConverter;
/**
 * Created by Asad on 17-07-2016.
 */
public class EncryptActivity extends AppCompatActivity {

    EditText ed1;
    Button b1;

    private ClipboardManager myClipboard;
    private ClipData myClip;
    KeyGenerator keygenerator;
    static SecretKey secretkey;

    Cipher cipher;
    byte[] encrypted;
    String encryptedText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypt_activity);
        ed1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  text = ed1.getText().toString();//now encrypt the message
                try {
                    keygenerator = KeyGenerator.getInstance("Blowfish");
                    secretkey = keygenerator.generateKey();
                    Log.d("asd", secretkey.toString());
                    cipher = Cipher.getInstance("Blowfish");
                    cipher.init(Cipher.ENCRYPT_MODE, secretkey);
                    encrypted = cipher.doFinal(text.getBytes());
                    encryptedText = encrypted.toString();
//                    Log.d("asd",encryptedText);
//                    Log.d("asd",javax.xml.bind.DatatypeConverter.printHexBinary(encrypted));
                    Log.d("asd", Base64.encodeToString(encrypted,Base64.DEFAULT));
                    myClip = ClipData.newPlainText("text", encryptedText);
                    myClipboard.setPrimaryClip(myClip);
//                    cipher.init(Cipher.DECRYPT_MODE, secretkey);
//                    byte[] decryptbyte = cipher.doFinal(encrypted);
//                    Log.d("asd", "decrypted text in encryptactivity is" + new String(decryptbyte));
                    Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
    }
}
