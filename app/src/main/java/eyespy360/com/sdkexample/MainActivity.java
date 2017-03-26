package eyespy360.com.sdkexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button buttonTourEditor;

    protected static final int  EYESPY360_TOUR_EDITOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTourEditor = (Button) findViewById(R.id.buttonTourEditor);

        buttonTourEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, EyeSpy360TourEditorActivity.class);
                Bundle b = new Bundle();
                b.putString("key",            "key"); // Your key  from 'API Credentials' in 'My Company' section
                b.putString("secret",         "secret"); // Your secret from 'API Credentials' in 'My Company' section
                b.putString("externalTourID", "my_unique_tour_id");
                b.putString("tour",           "my_tour_title");
                b.putString("hl",             "en"); // Language
                // for more infomration, please see https://www.eyespy360.com - API
                intent.putExtras(b);
                startActivityForResult(intent, EYESPY360_TOUR_EDITOR);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EYESPY360_TOUR_EDITOR) {
            if (resultCode == RESULT_OK) {
                ((EditText) findViewById(R.id.virtualTourURL)).setText(data.getStringExtra("virtualTourURL"));
            }
        }
    }
}
