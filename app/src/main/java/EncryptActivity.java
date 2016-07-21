import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asad.learnclipboard.R;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Created by Asad on 17-07-2016.
 */
public class EncryptActivity extends AppCompatActivity {

    EditText ed1;
    Button b1;

    private ClipboardManager myClipboard;
    private ClipData myClip;
    KeyGenerator keygenerator ;
    // create a key
    SecretKey secretkey;
    // create a cipher based upon Blowfish
    Cipher cipher;
    byte[] encrypted;
//    byte[] decrypted;
    String encryptedText=null;
//    String decryptedText=null;
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

                String text = ed1.getText().toString();//now encrypt the message
                // create a key generator based upon the Blowfish cipher
                try {
                    keygenerator = KeyGenerator.getInstance("Blowfish");

                    // create a key
                    secretkey = keygenerator.generateKey();

                    // create a cipher based upon Blowfish
                    cipher = Cipher.getInstance("Blowfish");
                    // initialise cipher to with secret key
                    cipher.init(Cipher.ENCRYPT_MODE, secretkey);

                    // encrypt message
                    encrypted = cipher.doFinal(text.getBytes());
//                    myClip = ClipData.newPlainText("text", text);
                    encryptedText = encrypted.toString();
                    myClip = ClipData.newPlainText("text", encryptedText);

                    myClipboard.setPrimaryClip(myClip);

                    Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
    }



}

