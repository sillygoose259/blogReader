package android.baltazarg.blog_reader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject>{
    private Activity activity;
    @Override
    protected JSONObject doInBackground(Activity... params) {
        activity = activities[0];
        JSONObject jsonObject = null;
        try {
            URL blogFeedURL = new URL("http://blogs.teamtreehouse.com/api/get_recent_summary/?count=10");

            HttpURLConnection connection = (HttpURLConnection)blogFeedURL.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                Log.i("BlogPostTask", "Successful Connection" + responseCode);
                jsonObject = BlogPostParser.get().parse(connection.getInputStream());
            }

        }

        catch(MalformedURLException error) {
                 Log.e("BlogPostTask", "Malformed URL" + error);
        }
        catch(IOException error) {
            Log.e("BlogPostTask", " IO Exception:" + error);
        }
        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
            BlogPostParser.get().readFeed(jsonObject);
        ListView listView = (ListView)activity.findViewById(R.id.listView);
        ArrayAdapter<BlogPost> adapter = new ArrayAdapter<BlogPost>(activity, android.R.layout.simple_list_item_1, BlogPostParser.get().posts);
        listView.setAdapter(adapter);


    }
}
