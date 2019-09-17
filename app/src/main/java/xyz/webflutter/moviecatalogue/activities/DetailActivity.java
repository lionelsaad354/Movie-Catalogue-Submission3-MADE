package xyz.webflutter.moviecatalogue.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import xyz.webflutter.moviecatalogue.R;
import xyz.webflutter.moviecatalogue.models.ResultMovie;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "movie_catalogue";
    private static final String STATE_RESULT = "state_result";
    private TextView title, overview, releasedDate, voteCount, popularity, language, voteAverage, overviewText;
    private ImageView poster;
    private RatingBar ratingBar;
    private View detailLayout;
    private CardView overviewLayout;
    private TableLayout tableLayout;
    private ProgressDialog progressDialog;
    ResultMovie resultMovie;
    String resultInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();
        getItem();
        if (savedInstanceState != null) {
            resultInstance = savedInstanceState.getString(STATE_RESULT);
            title.setText(resultInstance);
            overview.setText(resultInstance);
            releasedDate.setText(resultInstance);
            language.setText(resultInstance);
            voteAverage.setText(resultInstance);
            voteCount.setText(resultInstance);
            popularity.setText(resultInstance);
            Glide.with(getApplicationContext())
                    .load(resultInstance)
                    .into(poster);
            Objects.requireNonNull(getSupportActionBar()).setSubtitle(resultInstance);
        }
        getView();
        initAnimation();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        resultMovie = getIntent().getParcelableExtra(EXTRA_DATA);
        outState.putString(STATE_RESULT, resultMovie.getOriginalTitle());
        outState.putString(STATE_RESULT, resultMovie.getOverview());
        outState.putString(STATE_RESULT, resultMovie.getReleaseDate());
        outState.putString(STATE_RESULT, resultMovie.getOriginalLanguage());
        outState.putString(STATE_RESULT, resultMovie.getVoteCount());
        outState.putString(STATE_RESULT, resultMovie.getVoteAverage());
        outState.putString(STATE_RESULT, resultMovie.getPopularity());
        outState.putString(STATE_RESULT, resultMovie.getPosterPath());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            progressDialog.dismiss();
        }
    }

    private void getItem() {
        title = findViewById(R.id.title_film);
        overview = findViewById(R.id.overview_film);
        releasedDate = findViewById(R.id.date_film);
        language = findViewById(R.id.language);
        voteCount = findViewById(R.id.vote_count);
        voteAverage = findViewById(R.id.vote_average);
        popularity = findViewById(R.id.popularity_film);
        poster = findViewById(R.id.poster);
        ratingBar = findViewById(R.id.vote_rating);
        overviewLayout = findViewById(R.id.overviewLayout);
        detailLayout = findViewById(R.id.detailLayout);
        overviewText = findViewById(R.id.overview);
        tableLayout = findViewById(R.id.table_view);
    }

    private void getView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                ResultMovie modelMovie = getIntent().getParcelableExtra(EXTRA_DATA);
                title.setText(modelMovie.getOriginalTitle());
                overview.setText(modelMovie.getOverview());
                releasedDate.setText(modelMovie.getReleaseDate());
                language.setText(modelMovie.getOriginalLanguage());
                voteAverage.setText(modelMovie.getVoteAverage());
                voteCount.setText(modelMovie.getVoteCount());
                popularity.setText(modelMovie.getPopularity());
                ratingBar.setRating(Float.parseFloat(modelMovie.getVoteAverage()));
                Glide.with(getApplicationContext())
                        .load(modelMovie.getPosterPath())
                        .into(poster);
                Objects.requireNonNull(getSupportActionBar()).setSubtitle(modelMovie.getOriginalTitle());
            }
        }, 2000);
    }

    private void initAnimation() {
        Animation zoomingAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
        Animation swipeUp1 = AnimationUtils.loadAnimation(this, R.anim.swipe_animation1);
        Animation swipeUp2 = AnimationUtils.loadAnimation(this, R.anim.swipe_animation2);

        poster.startAnimation(zoomingAnimation);
        title.startAnimation(swipeUp1);
        overviewText.startAnimation(swipeUp1);
        overviewLayout.startAnimation(swipeUp2);
        detailLayout.startAnimation(swipeUp2);
        overview.startAnimation(swipeUp2);
        tableLayout.startAnimation(swipeUp2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
