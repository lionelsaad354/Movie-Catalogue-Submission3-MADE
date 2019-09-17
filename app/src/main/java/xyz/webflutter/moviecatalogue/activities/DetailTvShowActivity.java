package xyz.webflutter.moviecatalogue.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import xyz.webflutter.moviecatalogue.R;
import xyz.webflutter.moviecatalogue.models.ResultTvShow;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOW = "tv_show_catalogue";
    private static final String STATE_RESULT = "state_result";
    private TextView tvName;
    private TextView tvOverview;
    private TextView tvFirstAirDate;
    private TextView tvLanguages;
    private TextView tvVoteAverage;
    private TextView tvVoteCount;
    private TextView tvPopularity;
    private TextView tvOverviewText;
    private TextView detailViewTvShow;
    private ImageView ivThumbnail;
    private CardView cvOverviewTvShow;
    private CardView cvDetailTvShow;
    String resultInstance;
    RatingBar ratingBar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        initView();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();
        if (savedInstanceState != null) {
            resultInstance = savedInstanceState.getString(STATE_RESULT);
            tvName.setText(resultInstance);
            tvOverview.setText(resultInstance);
            tvFirstAirDate.setText(resultInstance);
            tvLanguages.setText(resultInstance);
            tvVoteAverage.setText(resultInstance);
            tvVoteCount.setText(resultInstance);
            tvPopularity.setText(resultInstance);
            Glide.with(getApplicationContext())
                    .load(resultInstance)
                    .into(ivThumbnail);
            Objects.requireNonNull(getSupportActionBar()).setSubtitle(resultInstance);
        }
        getData();
        initializeAnimation();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        ResultTvShow resultTvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);
        outState.putString(STATE_RESULT, resultTvShow.getOriginalName());
        outState.putString(STATE_RESULT, resultTvShow.getOverview());
        outState.putString(STATE_RESULT, resultTvShow.getFirstAirDate());
        outState.putString(STATE_RESULT, resultTvShow.getOriginalLanguage());
        outState.putString(STATE_RESULT, resultTvShow.getVoteCount());
        outState.putString(STATE_RESULT, resultTvShow.getVoteAverage());
        outState.putString(STATE_RESULT, resultTvShow.getPopularity());
        outState.putString(STATE_RESULT, resultTvShow.getPosterPath());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            progressDialog.dismiss();
        }
    }

    private void initView() {
        tvName = findViewById(R.id.name_tv_show_detail);
        tvOverview = findViewById(R.id.overview_tv_show_detail);
        tvFirstAirDate = findViewById(R.id.first_air_date);
        tvLanguages = findViewById(R.id.language_tv_show);
        tvVoteAverage = findViewById(R.id.vote_average_tv_show_detail);
        tvVoteCount = findViewById(R.id.vote_count_tv_show_detail);
        tvOverviewText = findViewById(R.id.overview_tv_show);
        detailViewTvShow = findViewById(R.id.detail_view_tv_show);
        tvPopularity = findViewById(R.id.popularity_tv_show_detail);
        ratingBar = findViewById(R.id.vote_rating_tv_show);
        ivThumbnail = findViewById(R.id.thumbnail_tv_show_detail);
        cvOverviewTvShow = findViewById(R.id.cv_overview_tv_show);
        cvDetailTvShow = findViewById(R.id.cv_detail_tv_show);
    }

    private void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                ResultTvShow modelTvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);
                tvName.setText(modelTvShow.getOriginalName());
                tvOverview.setText(modelTvShow.getOverview());
                tvFirstAirDate.setText(modelTvShow.getFirstAirDate());
                tvLanguages.setText(modelTvShow.getOriginalLanguage());
                tvVoteAverage.setText(modelTvShow.getVoteAverage());
                tvVoteCount.setText(modelTvShow.getVoteCount());
                tvPopularity.setText(modelTvShow.getPopularity());
                ratingBar.setRating(Float.parseFloat(modelTvShow.getVoteAverage()));
                Glide.with(getApplicationContext())
                        .load(modelTvShow.getPosterPath())
                        .into(ivThumbnail);
                Objects.requireNonNull(getSupportActionBar()).setSubtitle(modelTvShow.getOriginalName());
            }
        }, 2000);
    }

    private void initializeAnimation() {
        Animation zoomingAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
        Animation swipeUp1 = AnimationUtils.loadAnimation(this, R.anim.swipe_animation1);
        Animation swipeUp2 = AnimationUtils.loadAnimation(this, R.anim.swipe_animation2);

        ivThumbnail.startAnimation(zoomingAnimation);
        tvName.startAnimation(swipeUp1);
        tvOverviewText.startAnimation(swipeUp1);
        detailViewTvShow.startAnimation(swipeUp1);
        cvOverviewTvShow.startAnimation(swipeUp2);
        cvDetailTvShow.startAnimation(swipeUp2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
