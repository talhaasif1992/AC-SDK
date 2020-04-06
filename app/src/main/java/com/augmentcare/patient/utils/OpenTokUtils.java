package com.augmentcare.patient.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.RequiresPermission;

import com.opentok.android.BaseVideoRenderer;
import com.opentok.android.OpentokError;
import com.opentok.android.Publisher;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import com.opentok.android.Stream;
import com.opentok.android.Subscriber;

import static android.content.Context.POWER_SERVICE;

/////////////////////// Some Info of OpenTokBox ///////////////////////////////////////////
//    1 - Subscriber: other user who is going to be connected to you
//    2 - Publisher: your user
//    3 - Session: session object which is created on your side and seperate on other side
//    4 - Stream: whenever new session subscribes to you stream is sent to you
///////////////////////////////////////////////////////////////////////////////////////////

/**
 * Witten By Zulqurnain Jutt
 * Phone +923364116933
 */
public class OpenTokUtils {
    private Session mSession;
    private Publisher mPublisher;
    private Subscriber mSubscriber;
    private FrameLayout mPublisherViewContainer;
    private FrameLayout mSubscriberViewContainer;

    //////////////// TokBox API fields ///////////////
    String api;
    String token;
    String session_id;
    /////////////////////////////////////////////////

    private Context appContext;
    private OnSessionListener sessionCustomListner;

    private OpenTokUtils(String API_KEY, String tokboxToken, String sessionID) {
        this.api = API_KEY;
        this.token = tokboxToken;
        this.session_id = sessionID;
    }

    public static OpenTokUtils getMe(
            Context appContext,
            String API_KEY,
            String tokboxToken,
            String sessionID
    ){
        OpenTokUtils utils = new OpenTokUtils(API_KEY,tokboxToken,sessionID);
        utils.appContext = appContext;
        return utils;
    }

    @RequiresPermission(allOf = {Manifest.permission.INTERNET,Manifest.permission.RECORD_AUDIO,Manifest.permission.CAMERA})
    public void initOpenTok(
            OnSessionListener listener,
            FrameLayout yourVideoView,
            FrameLayout otherUserVideoView
    ){
        if(listener != null) {
            sessionCustomListner = listener;
        }else {
            sessionCustomListner = new OnSessionListener() {
            };
        }
        mPublisherViewContainer = yourVideoView;
        mSubscriberViewContainer = otherUserVideoView;

        mSession = new Session.Builder(appContext, api, session_id).build();
        mSession.setSessionListener(new Session.SessionListener() {
            @Override
            public void onConnected(Session session) {
                mPublisher = new Publisher.Builder(appContext).build();
                mPublisher.getRenderer().setStyle(BaseVideoRenderer.STYLE_VIDEO_SCALE, BaseVideoRenderer.STYLE_VIDEO_FILL);
                mPublisher.setPublisherListener(new PublisherKit.PublisherListener() {
                    @Override
                    public void onStreamCreated(PublisherKit publisherKit, Stream stream) {
                        Log.d("OPEN_TOK_UTILS", "onStreamCreated: Publisher Stream Created. Own stream " + stream.getStreamId());
                        sessionCustomListner.onYourStreamStart(publisherKit, stream);
                    }

                    @Override
                    public void onStreamDestroyed(PublisherKit publisherKit, Stream stream) {
                        Log.d("OPEN_TOK_UTILS", "onStreamDestroyed: Publisher Stream Destroyed. Own stream " + stream.getStreamId());
                        sessionCustomListner.onYourStreamEnd(publisherKit, stream);
                    }

                    @Override
                    public void onError(PublisherKit publisherKit, OpentokError opentokError) {
                        Log.e("OPEN_TOK_UTILS", "onError: " + opentokError.getErrorDomain() + " : " + opentokError.getErrorCode() + " - " + opentokError.getMessage());
                        sessionCustomListner.onYourStreamFails(publisherKit, opentokError);
                    }
                });
                mPublisherViewContainer.addView(mPublisher.getView());
                mSession.publish(mPublisher);

                if (mPublisher.getView() instanceof GLSurfaceView) {
                    ((GLSurfaceView) mPublisher.getView()).setZOrderOnTop(true);
                }
                sessionCustomListner.onConnect(session);
            }

            @Override
            public void onDisconnected(Session session) {
                sessionCustomListner.onDisconnect(session);
            }

            @Override
            public void onStreamReceived(Session session, Stream stream) {
                if (mSubscriber == null) {
                    mSubscriber = new Subscriber.Builder(appContext, stream).build();
                    mSubscriber.getRenderer()
                            .setStyle(
                                    BaseVideoRenderer.STYLE_VIDEO_SCALE,
                                    BaseVideoRenderer.STYLE_VIDEO_FILL
                            );
                    mSession.subscribe(mSubscriber);
                    mSubscriberViewContainer.addView(mSubscriber.getView());
                }
                sessionCustomListner.onNewStream(session,stream);
            }

            @Override
            public void onStreamDropped(Session session, Stream stream) {
                if (mSubscriber != null) {
                    mSubscriber = null;
                    mSubscriberViewContainer.removeAllViews();
                }
                sessionCustomListner.onStreamEnded(session,stream);
            }

            @Override
            public void onError(Session session, OpentokError opentokError) {
                if(mSession != null)
                    mSession.connect(token);
                sessionCustomListner.onError(session,opentokError);
            }
        });
        mSession.connect(token);
    }

    public void keepScreenOn(Activity myActivity){
        try {
            PowerManager powerManager = (PowerManager) myActivity.getApplicationContext().getSystemService(POWER_SERVICE);
            PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyApp::MyWakelockTag");
            Window win = myActivity.getWindow();
            win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
            myActivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchYourCamera(){
        try {
            if(mPublisher != null) {
                mPublisher.cycleCamera();
            }
        } catch (Exception e) {
        }
    }

    /**
     * mute you audio of voice to other
     * @return true if muted voice false otherwise
     */
    public boolean muteYourAudio(){
        try {
            mPublisher.setPublishAudio(!mPublisher.getPublishAudio());

            return mPublisher.getPublishAudio();
        } catch (Exception ignored) {
        }
        return false;
    }

    public void disconnectCall() {
        try {
            mSession.disconnect();
        } catch (Exception e) {
        }
    }

    public abstract class OnSessionListener{
        /**
         * Invoked when the client connects to the OpenTok session.
         * @param yourSession The session your client connected to.
         */
        void onConnect(Session yourSession){ }

        /**
         * Invoked when the client is no longer connected to the OpenTok session.
         * @param oppositeClient The session your client disconnected from.
         */
        void onDisconnect(Session oppositeClient){ }

        /**
         * Invoked when something goes wrong when connecting or connected to the session.
         * @param session The session in which the error occured.
         * @param opentokError An error describing the cause for error.
         */
        void onError(Session session, OpentokError opentokError){ }

        /**
         * when this user get connected or connection request from new other user
         * @param session
         * @param newStream
         */
        void onNewStream(Session session, Stream newStream){ }
        /**
         * when other user stops or end the stream
         * @param session The session from which the stream was removed.
         * @param droppedStream other user removed stream
         */
        void onStreamEnded(Session session, Stream droppedStream){ }

        /**
         * when i get's connected to other user
         * @param publisherKit
         * @param stream my stream
         */
        void onYourStreamStart(PublisherKit publisherKit, Stream stream){}
        /**
         * when your stream ends
         * @param publisherKit
         * @param stream my stream
         */
        void onYourStreamEnd(PublisherKit publisherKit, Stream stream){}

        /**
         * when your stream fails at some point
         * @param publisher
         * @param error
         */
        void onYourStreamFails(PublisherKit publisher, OpentokError error){}
    }
}
