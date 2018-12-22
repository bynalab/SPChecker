package com.example.bynalab.spchecker;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;


public class MainActivity extends AppCompatActivity {

    EditText number;
    TextView output;
    Button check;
    Button paste;
    String mtn = "MTN";
    String airtel = "AIRTEL";
    String etisalat = "ETISALAT";
    String glo = "GLO";
    String invalid = "Invalid Number";

    private ClipboardManager myClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText)findViewById(R.id.number);
        output = (TextView)findViewById(R.id.output);
        check = (Button)findViewById(R.id.button);
        paste = (Button)findViewById(R.id.paste);

        paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                String pasteData = "";

// If it does contain data, decide if you can handle the data.
                if (!(clipboard.hasPrimaryClip())) {


                } else if (!(clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {

                    // since the clipboard has data but it is not plain text

                } else {

                    //since the clipboard contains plain text.
                    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

                    // Gets the clipboard as text.
                    pasteData = item.getText().toString();
                    number.setText(pasteData);
                    Toast.makeText(getApplicationContext(), "Text Pasted",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String len = number.getText().toString();

                if(len.length() == 0){
                    output.setText("Input Number");
                }

                else if (len.length() >= 4) {

                    String pre = len.substring(0, 4);

                    if (pre.equals("0703") || pre.equals("0706") || pre.equals("0803") || pre.equals("0806") || pre.equals("0810") || pre.equals("0813") || pre.equals("0814") || pre.equals("0816") || pre.equals("0903") || pre.equals("0906")) {

                        //String sp =  mtn.concat(pre);
                        output.setText(mtn);

                    }
                    else if(pre.equals("0701") || pre.equals("0708") || pre.equals("0802") || pre.equals("0808") || pre.equals("0812") || pre.equals("0902") || pre.equals("0907")){

                        //String sp =  airtel.concat(pre);
                        output.setText(airtel);

                    }
                    else if(pre.equals("0809") || pre.equals("0817") || pre.equals("0818") || pre.equals("0909") || pre.equals("0908")){

                        //String sp =  etisalat.concat(pre);
                        output.setText(etisalat);

                    }
                    else if(pre.equals("0705") || pre.equals("0805") || pre.equals("0807") || pre.equals("0811") || pre.equals("0815") || pre.equals("0905")){

                        //String sp =  glo.concat(pre);
                        output.setText(glo);

                    }
                    else {

                        output.setText(invalid);

                    }

                }

                else {

                    output.setText("Incomplete");

                }
            }
        });



            }
    }