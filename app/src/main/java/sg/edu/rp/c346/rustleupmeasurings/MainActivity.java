package sg.edu.rp.c346.rustleupmeasurings;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static android.R.layout.simple_dropdown_item_1line;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText1;
    Spinner spinner1;
    TextView textView1;
    TextView getTextView2;
    Button button1;
    //List<String> list;
    List<String> flourlist;
    List<String> butterlist;
    List<String> hvlist;
    List<String> pslist;
    List<String> gslist;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.fromValue);
        spinner1 = (Spinner) findViewById(R.id.fromSpinner);
        textView1 = (TextView) findViewById(R.id.result);
        getTextView2 = (TextView) findViewById(R.id.resultvalue);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button1 = (Button) findViewById(R.id.button_convert);
        final String str = editText1.getText().toString();

//        list = new ArrayList<String>();
//        list.add("Cup to Gram");
//        list.add("Cup to Stick");
//        list.add("Stick to Ounce");
//        list.add("Ounce to Gram");

        flourlist = new ArrayList<String>();
        flourlist.add("Cup to Gram");

        butterlist = new ArrayList<String>();
        butterlist.add("Cup to Stick");
        butterlist.add("Stick to Ounces");


        hvlist = new ArrayList<String>();
        hvlist.add("Cup to Gram");

        pslist = new ArrayList<String>();
        pslist.add("Cup to Gram");

        gslist = new ArrayList<String>();
        gslist.add("Cup to Gram");


        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(MainActivity.this,
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

                if (editText1.getText().toString().length() > 0) {
                    if (pos == 0) {
                        int value = Integer.parseInt(editText1.getText().toString());
                        int result = value;
                        int fixNum = 140;
                        int calculate = result * fixNum;
                        String strResult = String.valueOf(calculate);
                        getTextView2.setText(strResult);
                    } else if (pos == 1) {
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        for (int i = 0; i < butterlist.size(); i++) {
                            if (spinner1.getSelectedItemPosition() == 0) {
                        int value = Integer.parseInt(editText1.getText().toString());
                        int resultCS = value;
                        int fixNumCS = 2;
                        int calculateCS = resultCS * fixNumCS;
                        String strResultCS = String.valueOf(calculateCS);
                        getTextView2.setText(strResultCS);
                            }else if (spinner1.getSelectedItemPosition() == 1) {
                                int value = Integer.parseInt(editText1.getText().toString());
                                int resultSO = value;
                                int fixNumSO = 4;
                                int calculateSO = resultSO * fixNumSO;
                                String strResultSO = String.valueOf(calculateSO);
                                getTextView2.setText(strResultSO);

                            }

                        }

                    } else if (pos == 2) {
                        int value = Integer.parseInt(editText1.getText().toString());
                        int result3 = value;
                        int fixNum3 = 235;
                        int calculate3 = result3 * fixNum3;
                        String strResult3 = String.valueOf(calculate3);
                        getTextView2.setText(strResult3);

                    } else if (pos == 3) {
                        int value = Integer.parseInt(editText1.getText().toString());
                        int result4 = value;
                        int fixNum4 = 160;
                        int calculate4 = result4 * fixNum4;
                        String strResult4 = String.valueOf(calculate4);
                        getTextView2.setText(strResult4);

                    } else if (pos == 4) {
                        int value = Integer.parseInt(editText1.getText().toString());
                        int result5 = value;
                        int fixNum5 = 200;
                        int calculate5 = result5 * fixNum5;
                        String strResult5 = String.valueOf(calculate5);
                        getTextView2.setText(strResult5);
                    }
                }


            }


        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pos = radioGroup.indexOfChild(findViewById(checkedId));

                switch (pos) {
                    case 0://flour

//                        list.add("Cup to Gram");
//                        String conversionType = list.get(0);
                        ArrayAdapter<String> adpf = new ArrayAdapter<>(getBaseContext(), simple_dropdown_item_1line, flourlist);
                        spinner1.setAdapter(adpf);

                        break;
                    case 1: //butter
                        //list = new ArrayList<String>();
//                        list.add("Cup to Stick");
//                        list.add("Stick to Ounces");
//                        list.add("Ounces to Grams");
                        ArrayAdapter<String> adpb = new ArrayAdapter<>(getBaseContext(), simple_dropdown_item_1line, butterlist);
                        spinner1.setAdapter(adpb);
                        break;
                    case 2: //heavy cream
                        // list = new ArrayList<String>();
//                        list.add("Cup to Gram");
                        ArrayAdapter<String> adphc = new ArrayAdapter<>(getBaseContext(), simple_dropdown_item_1line, hvlist);
                        spinner1.setAdapter(adphc);
                        break;
                    case 3: //Powdered sugar
                        // list = new ArrayList<String>();
//                        list.add("Cup to Gram");
                        ArrayAdapter<String> adpps = new ArrayAdapter<>(getBaseContext(), simple_dropdown_item_1line, pslist);
                        spinner1.setAdapter(adpps);
                        break;
                    case 4: //granulated sugar
                        //ist = new ArrayList<String>();
//                        list.add("Cup to Gram");
                        ArrayAdapter<String> adpgs = new ArrayAdapter<>(getBaseContext(), simple_dropdown_item_1line, gslist);
                        spinner1.setAdapter(adpgs);
                        break;

                }

            }
//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        });
    }
}





