package eric.cohortq1;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements GetComicTask.AsyncResponse {
    EditText editTextComicNo;
    ImageView imageViewComic;
    TextView textViewURL;
    TextView textViewJSON;
    GetComicTask getComicTask;

    final String xkcd_BASE = "xkcd.com";
    final String xkcd_TAIL = "info.0.json";
    final String xkcd_SCHEME = "https";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextComicNo = findViewById(R.id.comic_number);
        imageViewComic = findViewById(R.id.comic_placeholder);
        textViewURL = findViewById(R.id.comic_url);
        textViewJSON = findViewById(R.id.comic_json);
    }

   public void onClickGetComic(View view) {
        URL xkcdURL = buildURL();
        textViewURL.setText(xkcdURL.toString());

        getComicTask = new GetComicTask(this);
        getComicTask.execute(xkcdURL);
    }

    @Override
    public void processFinish(Bitmap s) {
        textViewJSON.setText(getComicTask.getImgURLStr());
        imageViewComic.setImageBitmap(s);
    }

    private URL buildURL() {
        URL xkcdURL = null;
        String comicNo = editTextComicNo.getText().toString();

        Uri.Builder myUriBuilder = new Uri.Builder();
        myUriBuilder.scheme(xkcd_SCHEME)
                .authority(xkcd_BASE)
                .appendPath(comicNo)
                .appendPath(xkcd_TAIL);
        Uri xkcdUri = myUriBuilder.build();

        try {
            xkcdURL = new URL(xkcdUri.toString());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        return xkcdURL;
    }
}
