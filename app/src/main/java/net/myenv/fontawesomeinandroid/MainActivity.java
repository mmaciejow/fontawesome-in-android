package net.myenv.fontawesomeinandroid;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mButton2;
    String FONTAWESOME = "fonts/fontawesome-webfont.ttf";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.mButton);
        mButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf"));

        mButton2 = (TextView) findViewById(R.id.mButton2);
        mButton2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf"));

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click Android Icon", Toast.LENGTH_LONG).show();

            }
        });

        Typeface iconFont = Typeface.createFromAsset(this.getAssets(), FONTAWESOME);
        markAsIconContainer(findViewById(R.id.icons_container), iconFont);

    }

    private void markAsIconContainer(View v, Typeface typeface) {
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                markAsIconContainer(child, typeface);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(typeface);
        }
    }

}
