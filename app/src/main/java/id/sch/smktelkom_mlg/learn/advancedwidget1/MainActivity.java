package id.sch.smktelkom_mlg.learn.advancedwidget1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout liMain = (LinearLayout) findViewById(R.id.linearLayoutMain);

        addEditText(liMain);

        Button bProses = new Button(this);
        bProses.setText("Proses");
        liMain.addView(bProses);
        final TextView tvHasil = new TextView(this);
        liMain.addView(tvHasil);

        bProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProses(liMain);
            }
        });
    }

    private void doProses(LinearLayout liMain) {
        String hasil = "";
        for (int i = 0; i < 5; i++) {
            EditText etNama = (EditText) liMain.getChildAt(0);
            EditText etUmur = (EditText) liMain.getChildAt(1);

            String nama = etNama.getText().toString();
            String umur = etUmur.getText().toString();

            if (umur.isEmpty())
                umur = "0";
            if (!nama.isEmpty())
                hasil += "Anak ke-" + (i + 1) + ": " + nama + " umur " + umur + " tahun\n";

        }
        TextView tvHasil = (TextView) liMain.getChildAt(11);
        tvHasil.setText(hasil);
    }

    private void addEditText(LinearLayout liMain) {
        for (int i = 1; i <= 5; i++) {
            final EditText etNama = new EditText(this);
            liMain.addView(etNama);
            etNama.setHint("Isikan Nama Anak");

            final EditText etUmur = new EditText(this);
            liMain.addView(etUmur);
            etUmur.setHint("Isikan Umur Anak");
            etUmur.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }
}
