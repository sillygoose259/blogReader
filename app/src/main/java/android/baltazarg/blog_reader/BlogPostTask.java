package android.baltazarg.blog_reader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject>{
    @Override
    protected JSONObject doInBackground(Activity... params) {
        try {
            URL blogFeedURL = new URL("http://blogs.teamtreehouse.com/api/get_recent_summary/?count=10");

            HttpURLConnection connection = (HttpURLConnection)blogFeedURL.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                Log.i("BlogPostTask", "Successful Connection" + responseCode);
            }

        }

        catch(MalformedURLException error) {
                 Log.e("BlogPostTask", "Malformed URL" + error);
        }
        catch(IOException error) {
            Log.e("BlogPostTask", " IO Exception:" + error);
        }
        return null;
    }
}
