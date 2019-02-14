package nl.cspconnections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView TextLocationView;
    private ImageView Image;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.TextLocationView = findViewById( R.id.TextLocation );
        this.Image = findViewById( R.id.DiceLocation );
    }

    private String getDateString() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "d-M-y H:m:s:S", Locale.US );
        return dateFormat.format( date );
    }

    public void randomize( View v ) {
        Random random = new Random();

        int randomNumber = random.nextInt( 6 ) + 1;
        int diceNumber = 0;

        switch ( randomNumber ) {
            case 1: diceNumber = R.drawable.dice1; break;
            case 2: diceNumber = R.drawable.dice2; break;
            case 3: diceNumber = R.drawable.dice3; break;
            case 4: diceNumber = R.drawable.dice4; break;
            case 5: diceNumber = R.drawable.dice5; break;
            case 6: diceNumber = R.drawable.dice6; break;
            default: diceNumber = R.drawable.dice1;
        }

        HistoryActivity.History.add( this.getDateString() + " -> " + randomNumber );

        this.Image.setImageResource( diceNumber );
        this.TextLocationView.setText( "You threw: " + randomNumber );
    }

    public void seeHistory( View v ) {
        Intent intent = new Intent( this, HistoryActivity.class );
        startActivity( intent );
    }
}
