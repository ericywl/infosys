package eric.cohortq1;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GetComicTask extends AsyncTask<URL, Void, Bitmap> {
    public interface AsyncResponse {
        void processFinish(Bitmap s);
    }

    public AsyncResponse delegate = null;
    private String imgURLStr;

    public GetComicTask(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        URL url = urls[0];
        Bitmap xkcdPic = null;

        try{
            imgURLStr = parseJSON(getHttpURL(url));

            URL imgURL = new URL(imgURLStr);
            InputStream inputStream = imgURL.openStream();
            xkcdPic = BitmapFactory.decodeStream(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }

        return xkcdPic;
    }

    @Override
    protected void onPostExecute(Bitmap s) {
        delegate.processFinish(s);
    }

    private String getHttpURL(URL url) {
        StringBuilder output = new StringBuilder();

        try {
            String input;
            InputStream inputStream = url.openStream();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            while ((input = reader.readLine()) != null) {
                output.append(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return output.toString();
    }

    private String parseJSON(String JSONString) {
        JSONObject reader;
        String output = "";

        try {
            reader = new JSONObject(JSONString);
            output = reader.getString("img");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return output;
    }

    public String getImgURLStr() {
        return imgURLStr;
    }
}
