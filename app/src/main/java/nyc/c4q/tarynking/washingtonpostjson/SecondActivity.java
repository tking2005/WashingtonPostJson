package nyc.c4q.tarynking.washingtonpostjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView idTextView;
    private TextView titleTextView;
    private TextView contentTextView;
    private TextView dateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        idTextView = (TextView) findViewById(R.id.post_id2);
        titleTextView = (TextView) findViewById(R.id.post_title2);
        contentTextView = (TextView) findViewById(R.id.post_content2);
        dateTextView = (TextView) findViewById(R.id.post_date);

        //Retrieve information from bundle
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String id = extras.getString("POST_ID");
        String title = extras.getString("POST_TITLE");
        String content = extras.getString("POST_CONTENT");
        String date = extras.getString("POST_DATE");

        //After retrieving the information put the data onto the views
        idTextView.setText(id);
        titleTextView.setText(title);
        contentTextView.setText(content);
        dateTextView.setText(date);

    }
}
