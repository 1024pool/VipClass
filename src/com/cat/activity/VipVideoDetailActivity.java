package com.cat.activity;

//import android.app.Activity;
import com.ta.TAActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
//import android.content.pm.ActivityInfo;

public class VipVideoDetailActivity extends TAActivity  implements MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {
    public static final String TAG = "VideoPlayer";
    private VideoView mVideoView;
    private Uri mUri;
    private int mPositionWhenPaused = -1;

    private MediaController mMediaController;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vipvideodetail);

        //Set the screen to landscape.
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mVideoView = (VideoView)findViewById(R.id.video_view);

        //Video file
        mUri = Uri.parse(Environment.getExternalStorageDirectory() + "/wandoujia/video/m1.mp4");

        //Create media controller
        mMediaController = new MediaController(this);
        mVideoView.setMediaController(mMediaController);
    }

    public void onStart() {
        // Play Video
        mVideoView.setVideoURI(mUri);
        mVideoView.start();

        super.onStart();
    }

    public void onPause() {
        // Stop video when the activity is pause.
        mPositionWhenPaused = mVideoView.getCurrentPosition();
        mVideoView.stopPlayback();
        Log.d(TAG, "OnStop: mPositionWhenPaused = " + mPositionWhenPaused);
        Log.d(TAG, "OnStop: getDuration  = " + mVideoView.getDuration());

        super.onPause();
    }

    public void onResume() {
        // Resume video player
        if(mPositionWhenPaused >= 0) {
            mVideoView.seekTo(mPositionWhenPaused);
            mPositionWhenPaused = -1;
        }

        super.onResume();
    }

    public boolean onError(MediaPlayer player, int arg1, int arg2) {
        //return false;
    	return true;
    }

    public void onCompletion(MediaPlayer mp) {
        //this.finish();
        doActivity(R.string.vipvideoactivity);
    }
}