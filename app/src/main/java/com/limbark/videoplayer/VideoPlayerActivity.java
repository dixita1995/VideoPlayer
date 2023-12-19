package com.limbark.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

public class VideoPlayerActivity extends AppCompatActivity {
    LinearLayout unified_ad;
    LinearLayoutCompat tranding;
    LinearLayoutCompat video;
    LinearLayoutCompat download;
    SharedPreferences sharedPreferences;
    boolean bol = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        ButterKnife.bind(this);
        tranding=findViewById(R.id.btntranding);
        download=findViewById(R.id.btndownloader);
        video=findViewById(R.id.btnvideo);
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);


// The value will be default as empty string because for
// the v
// Creating an Editor object to edit(write to the file)
        bol = sharedPreferences.getBoolean("bool", false);
        if (!bol) {
            Permission();
        }
        unified_ad= (LinearLayout) findViewById(R.id.nativeAdsListView);
        AppCompatActivity activity = this;
        Admob(activity, MainActivity.nativeid);
        tranding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAd.load(getApplicationContext(), MainActivity.Industrial, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        InterstitialAd mInterstitialAdMob = interstitialAd;
                        mInterstitialAdMob.show(VideoPlayerActivity.this);
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

                                /*startActivity(new Intent(VideoStartActivity.this, Vi.class));
                                finish();*/

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

                       /* startActivity(new Intent(VideoStartActivity.this, VideoStartActivity.class));
                        finish();*/


                    }
                });

            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAd.load(getApplicationContext(), MainActivity.Industrial, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        InterstitialAd mInterstitialAdMob = interstitialAd;
                        mInterstitialAdMob.show(VideoPlayerActivity.this);
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

                                /*startActivity(new Intent(VideoStartActivity.this, Vi.class));
                                finish();*/

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

                       /* startActivity(new Intent(VideoStartActivity.this, VideoStartActivity.class));
                        finish();*/


                    }
                });

            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAd.load(getApplicationContext(), MainActivity.Industrial, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        InterstitialAd mInterstitialAdMob = interstitialAd;
                        mInterstitialAdMob.show(VideoPlayerActivity.this);
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

                                /*startActivity(new Intent(VideoStartActivity.this, Vi.class));
                                finish();*/

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

                       /* startActivity(new Intent(VideoStartActivity.this, VideoStartActivity.class));
                        finish();*/


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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 &&  PermissionChecker.checkSelfPermission(this,
                READ_EXTERNAL_STORAGE)
                == PERMISSION_GRANTED && PermissionChecker.checkSelfPermission(this,
                WRITE_EXTERNAL_STORAGE)
                == PERMISSION_GRANTED )
        {
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putBoolean("bool", true);
            myEdit.commit();
            bol=true;
            Toast.makeText(VideoPlayerActivity.this, "Permission Granted.", Toast.LENGTH_LONG).show();
            return;
        }
    }
    public void Permission()
    {
        try {
            ActivityCompat.requestPermissions(this, new String[]{ READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, 110);
        } catch (Exception e) {
            e.getMessage();
        }

    }
}