package com.kelompokpjw.diskonramayana;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//kelompok kami menggunakan AppCompatActivity karena ActionBarActivity berstatus deprecated
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextInputHarga, editTextInputDiskon, editTextOutputTotal, editTextOutputHargaStlhDiskon;
    Button btnHitung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInputHarga = (EditText) findViewById(R.id.inputHarga);
        editTextInputDiskon = (EditText) findViewById(R.id.inputDiskon);
        editTextOutputTotal = (EditText) findViewById(R.id.outputTotal);
        editTextOutputHargaStlhDiskon = (EditText) findViewById(R.id.outputHargaStlhDiskon);

        btnHitung = (Button) findViewById(R.id.btnHitung);

        btnHitung.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHitung:
                String harga = editTextInputHarga.getText().toString();
                String diskon = editTextInputDiskon.getText().toString();

                Double totalDiskon = Double.parseDouble(harga) * Double.parseDouble(diskon) / 100;
                Double hargaStlhDiskon = Double.parseDouble(harga) - totalDiskon;

                editTextOutputTotal.setText(String.valueOf(totalDiskon));
                editTextOutputHargaStlhDiskon.setText(String.valueOf(hargaStlhDiskon));
                break;


        }
    }
}