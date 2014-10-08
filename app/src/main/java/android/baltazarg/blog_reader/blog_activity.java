package android.baltazarg.blog_reader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.lang.reflect.Array;


public class blog_activity extends Activity {

    protected ProgressBar progressBar;
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_activity);

        String[] arrayStrings = new String[] {
                "Blog Post 1",
                "Blog Post 2",
                "Blog Post 3",
                "Blog Post 4"
        };

    progressBar=  (ProgressBar)findViewById(R.id.progressBar);
    listView = (ListView)findViewById(R.id.listView);

        listView.setEmptyView(progressBar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayStrings);
        listView.setAdapter(adapter);

        new BlogPostTask().execute();
    }
}
