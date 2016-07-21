            package com.example.asad.learnclipboard;

            import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
    public class MainActivity extends AppCompatActivity {

//    EditText ed1;TextView tv;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

    }
  public void startEncrypt(View v)
  {
      Intent intent=new Intent(this,EncryptActivity.class);
      startActivity(intent);
  }
   public  void startDecrypt(View v)
        {
            Intent intent=new Intent(this,DecryptActivity.class);
            startActivity(intent);
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
