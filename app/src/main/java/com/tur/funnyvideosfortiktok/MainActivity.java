package com.tur.funnyvideosfortiktok;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flipkart.youtubeview.models.YouTubePlayerType;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.tur.funnyvideosfortiktok.youtubenative.YouTubeNativeActivityDemo;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private  Button rate;

    //-- ad purpose
    private InterstitialAd mInterstitialAd;
    private boolean showAdd = true;
    private int buttonpressed = 0;

    public CustomProgressBar customProgressBar;
    private boolean showLoadingBar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.start);
        rate = (Button)findViewById(R.id.rate);




        mInterstitialAd = new InterstitialAd(MainActivity.this);
        mInterstitialAd.setAdUnitId(getString(R.string.full_screen_ad_unit));
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice("547BABAE3AB2FE105C08D5339A13F684")
                .build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {


            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {

                if(buttonpressed == 1){

                    Intent intent = new Intent(MainActivity.this, YouTubeNativeActivityDemo.class);
                    intent.putExtra("playerType", YouTubePlayerType.STRICT_NATIVE);
                    startActivity(intent);

                }

            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                buttonpressed = 1;

                if (mInterstitialAd.isLoaded() && showAdd) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");


                    Intent intent = new Intent(MainActivity.this, YouTubeNativeActivityDemo.class);
                    intent.putExtra("playerType", YouTubePlayerType.STRICT_NATIVE);
                    startActivity(intent);

                }



            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OnRateButtonClick();


            }
        });

        //--custom loading bar area

        customProgressBar = new CustomProgressBar(MainActivity.this);
        customProgressBar.show();
        stopLoadingBar();





        //---------




    }

    //Rating_purpose
    private boolean MyStartActivity(Intent aIntent) {
        try
        {
            startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }

    public  void OnRateButtonClick() {


        Intent intent = new Intent(Intent.ACTION_VIEW);
        //Try Google play
        intent.setData(Uri.parse("market://details?id=com.tur.funnyvideosfortiktok"));
        if (!MyStartActivity(intent)) {
            //Market (Google play) app seems not installed, let's try to open a webbrowser
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.tur.funnyvideosfortiktok"));
            if (!MyStartActivity(intent)) {
                //Well if this also fails, we have run out of options, inform the user.

                Toast.makeText(MainActivity.this, "Could not open Play Store, please install the Google play app.", Toast.LENGTH_LONG).show();
            }
        }

        //-------------------

        /*

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.starsolo)
                .setTitle("রেটিং দিন")
                .setMessage("অ্যাপটি যদি আপনার ভাল লেগে থাকে তাহলে প্লে-ষ্টোরে এই অ্যাপটিকে রেটিং দিয়ে আমাদের উৎসাহিত করুন!")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //--

                    }

                })
                .setNegativeButton("Close", null)
                .show();

                */



    }






    //-----------


    @Override
    public void onBackPressed() {


        exitAlert();

    }

    private void exitAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title
        //  alertDialogBuilder.setTitle("Exit");

        // set dialog message
        alertDialogBuilder
                .setTitle("Exit")
                .setMessage("Do you want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //   mp.stop();
                        //   mp.release();


                        dialog.dismiss();
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing

                        dialog.cancel();
                    }
                })
                .create().
                show();


        // create alert dialog
        //AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        // alertDialog.show();
    }

    private void stopLoadingBar(){

        if(!showLoadingBar){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    customProgressBar.hide();
                    //Toast.makeText(Matched_Activity.this, "No match found!", Toast.LENGTH_LONG).show();

                }
            }, 5000);

            showLoadingBar = true;
        }

    }

}
