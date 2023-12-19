package com.limbark.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoStartActivity extends AppCompatActivity {

    LinearLayoutCompat laystart;
    LinearLayout unified_ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_start);
        ButterKnife.bind(this);
        laystart=findViewById(R.id.btnstart);
        unified_ad= (LinearLayout) findViewById(R.id.nativeAdsListView);
        AppCompatActivity activity = this;
        Admob(activity,MainActivity.nativeid);
        laystart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAd.load(getApplicationContext(), MainActivity.Industrial, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        InterstitialAd mInterstitialAdMob = interstitialAd;
                        mInterstitialAdMob.show(VideoStartActivity.this);
                        mInterstitialAdMob.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();

                                startActivity(new Intent(VideoStartActivity.this, VideoPlayerActivity.class));


                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);

                        startActivity(new Intent(VideoStartActivity.this, VideoPlayerActivity.class));



                    }
                });

            }
        });
    }
    public void Admob(AppCompatActivity activity, String AD_MANAGER_AD_UNIT_ID)
    {

        new AdLoader.Builder(this, getResources().getString(R.string.admob_native_big)).forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                NativeAdView NativeAdView = (NativeAdView) getLayoutInflater().inflate(R.layout.ad_unit_admob, (ViewGroup) null);
                populateNativeAdView(nativeAd, NativeAdView);
                unified_ad.removeAllViews();
                unified_ad.addView(NativeAdView);
            }
        }).withAdListener(new AdListener() {

            @Override
            public void onAdFailedToLoad(LoadAdError i) {
            }
        }).build().loadAd(new AdRequest.Builder().build());
    }

    private void populateNativeAdView(NativeAd unifiedNativeAd, NativeAdView NativeAdView) {
        NativeAdView.setMediaView((MediaView) NativeAdView.findViewById(R.id.ad_media));
        NativeAdView.setHeadlineView(NativeAdView.findViewById(R.id.ad_headline));
        NativeAdView.setBodyView(NativeAdView.findViewById(R.id.ad_body));
        NativeAdView.setCallToActionView(NativeAdView.findViewById(R.id.ad_call_to_action));
        NativeAdView.setIconView(NativeAdView.findViewById(R.id.ad_app_icon));
        NativeAdView.setPriceView(NativeAdView.findViewById(R.id.ad_price));
        NativeAdView.setStarRatingView(NativeAdView.findViewById(R.id.ad_stars));
        NativeAdView.setStoreView(NativeAdView.findViewById(R.id.ad_store));
        NativeAdView.setAdvertiserView(NativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) NativeAdView.getHeadlineView()).setText(unifiedNativeAd.getHeadline());
        NativeAdView.getMediaView().setMediaContent(unifiedNativeAd.getMediaContent());
        if (unifiedNativeAd.getBody() == null) {
            NativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            NativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) NativeAdView.getBodyView()).setText(unifiedNativeAd.getBody());
        }
        if (unifiedNativeAd.getCallToAction() == null) {
            NativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            NativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) NativeAdView.getCallToActionView()).setText(unifiedNativeAd.getCallToAction());
        }
        if (unifiedNativeAd.getIcon() == null) {
            NativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) NativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.getIcon().getDrawable());
            NativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        if (unifiedNativeAd.getPrice() == null) {
            NativeAdView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            NativeAdView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) NativeAdView.getPriceView()).setText(unifiedNativeAd.getPrice());
        }
        if (unifiedNativeAd.getStore() == null) {
            NativeAdView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            NativeAdView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) NativeAdView.getStoreView()).setText(unifiedNativeAd.getStore());
        }
        if (unifiedNativeAd.getStarRating() == null) {
            NativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) NativeAdView.getStarRatingView()).setRating(unifiedNativeAd.getStarRating().floatValue());
            NativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
        }
        if (unifiedNativeAd.getAdvertiser() == null) {
            NativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) NativeAdView.getAdvertiserView()).setText(unifiedNativeAd.getAdvertiser());
            NativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
        }
        NativeAdView.setNativeAd(unifiedNativeAd);
    }
}