package michaelstanek.tescht;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class startsingleplayer extends AppCompatActivity {

    public final static String EXTRA_MESSAGE5 = "michaelstanek.tescht.SHIP";
    public final static String EXTRA_MESSAGE4 = "michaelstanek.tescht.SHIP4";
    public final static String EXTRA_MESSAGE3 = "michaelstanek.tescht.SHIP3";
    public final static String EXTRA_MESSAGE2 = "michaelstanek.tescht.SHIP2";
    public int s5=1,s4=2,s3=3,s2=4;
    SeekBar sickbar;


    SeekBar customSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startsingleplayer);




        customSeekBar =(SeekBar)findViewById(R.id.seekBar);
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView text = (TextView) findViewById(R.id.textView2);
                String s = String.valueOf(progress);
                text.setText(s);
                s5=progress;}


            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Maybe something

            }
        });

        customSeekBar =(SeekBar)findViewById(R.id.seekBar2);
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView text = (TextView) findViewById(R.id.textView3);
                String s=String.valueOf(progress);
                text.setText(s);
                s4=progress;}


            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Maybe something

            }
        });

        customSeekBar =(SeekBar)findViewById(R.id.seekBar3);
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView text = (TextView) findViewById(R.id.textView4);
                String s = String.valueOf(progress);
                text.setText(s);
                s3=progress;}

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Maybe something

            }
        });

        customSeekBar =(SeekBar)findViewById(R.id.seekBar4);
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView text = (TextView) findViewById(R.id.textView5);
                String s=String.valueOf(progress);
                text.setText(s);
                s2=progress;}


            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //TODO Maybe something

            }
        });

    }


    // mochstuff();


    public void StartGame(View view){
         Intent intent= new Intent(this,singleplayergame.class);
        String string5=String.valueOf(s5);
        intent.putExtra(EXTRA_MESSAGE5,string5);
        String string4=String.valueOf(s4);
        intent.putExtra(EXTRA_MESSAGE4,string4);
        String string3=String.valueOf(s3);
        intent.putExtra(EXTRA_MESSAGE3,string3);
        String string2=String.valueOf(s2);
        intent.putExtra(EXTRA_MESSAGE2,string2);
        startActivity(intent);
    }
}