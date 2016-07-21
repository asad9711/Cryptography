import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asad.learnclipboard.R;

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

    private ClipboardManager myClipboard;
    private ClipData myClip;
    KeyGenerator keygenerator;
    // create a key
    SecretKey secretkey;
    // create a cipher based upon Blowfish
    Cipher cipher;
    byte[] encrypted;
    byte[] decrypted;
    //    String encryptedText=null;
    String decryptedText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decrypt_activity);
        ed1 = (EditText) findViewById(R.id.decrypteditText);


        b1 = (Button) findViewById(R.id.decryptbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData abc = myClipboard.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);
//                String text = item.getText().toString();
                try {
                    Cipher cipher2 = Cipher.getInstance("Blowfish");
                    cipher2.init(Cipher.DECRYPT_MODE, secretkey);
//                    cipher.init(Cipher.DECRYPT_MODE, secretkey);
                    // decrypt message
//                     decrypted = cipher.doFinal(encrypted);
                    byte[] encrypted =ed1.getText().toString().getBytes();
                    decrypted = cipher2.doFinal(encrypted);

                    tv.setText(new String(decrypted));
                } catch (Exception e) {
                }
                Toast.makeText(getApplicationContext(), "Text Pasted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
