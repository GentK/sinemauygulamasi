package com.gent.movies.network;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.gent.movies.R;
import com.gent.movies.listing.MoviesListingActivity;

import java.util.Map;

public class NotificationService extends FirebaseMessagingService {


    private static final String TAG = "FirebaseService";
    private static int count = 0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String click_action = remoteMessage.getNotification().getClickAction();

        if (remoteMessage.getNotification() != null) {
            sendNotification(remoteMessage.getNotification().getTitle(),
                    remoteMessage.getNotification().getBody(), remoteMessage.getData(),click_action);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendNotification(String messageTitle, String messageBody, Map<String, String> row, String click_action) {
        String CHANNEL_ID = "panda";
        CharSequence name = "panda";
       // Uri NOTIFICATION_SOUND_URI = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + BuildConfig.APPLICATION_ID + "/" + R.raw.voice_notification);
        long[] VIBRATE_PATTERN    = {0, 500};
        int importance = NotificationManager.IMPORTANCE_HIGH;

        Intent resultIntent = new Intent(click_action);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle();
        resultIntent.putExtras(bundle);
        resultIntent.putExtra("notify","true");
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
        mChannel.setShowBadge(true);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MoviesListingActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent pendingIntent = (PendingIntent) PendingIntent.getActivity(getApplicationContext(),0,resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmSound  =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notificationBuilder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_popcorn3_foreground)
                .setColor(getColor(R.color.colorAccent)) //(getColor(R.color.colorPrimaryDark))
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
              //  .setSound(NOTIFICATION_SOUND_URI)
                .setVibrate(VIBRATE_PATTERN)
             //   .setSmallIcon(R.drawable.common_google_signin_btn_icon_light_normal)
                .setAutoCancel(true)
                .setStyle(new Notification.BigTextStyle())
                .setContentIntent(pendingIntent).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(count, notificationBuilder);
        count++;
    }
}
