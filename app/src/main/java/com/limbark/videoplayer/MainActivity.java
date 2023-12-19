package com.limbark.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    public static String Industrial = "", bannerId = "", nativeid = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonParse();
        AppOpenManager appOpenManager = new AppOpenManager(getApplication());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }


        new Handler().postDelayed(new Runnable() {
            public void run() {
                InterstitialAd.load(getApplicationContext(), MainActivity.Industrial, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        InterstitialAd mInterstitialAdMob = interstitialAd;
                        mInterstitialAdMob.show(MainActivity.this);
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

                                    startActivity(new Intent(MainActivity.this, VideoStartActivity.class));
                                    finish();

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

                            startActivity(new Intent(MainActivity.this, VideoStartActivity.class));
                            finish();


                    }
                });

            }
        }, 1000);



    }
    RequestQueue requestQueue;
    private void jsonParse() {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://jsonkeeper.com/b/VVY5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    AppOpenManager.AD_UNIT_ID = response.getString("appopen");
                    Industrial = response.getString("interstitial");
                    bannerId = response.getString("banner");
                    nativeid = response.getString("native");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        if (bannerId.isEmpty()) {
            bannerId = Constant.Bannerid;
        }
        if (Industrial.isEmpty()) {
            Industrial = Constant.interstitial;
        }
        if (nativeid.isEmpty()) {
            nativeid = Constant.nativeid;
        }
        requestQueue.add(request);
    }


}