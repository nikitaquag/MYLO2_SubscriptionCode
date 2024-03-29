package com.mindyourlovedone.healthcare.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by welcome on 1/15/2018.
 */

public class IabBroadcastReceiver extends BroadcastReceiver {
    /**
     * The Intent action that this Receiver should filter for.
     */
    public static final String ACTION = "com.android.vending.billing.PURCHASES_UPDATED";
    private final IabBroadcastListener mListener;

    public IabBroadcastReceiver(IabBroadcastListener listener) {
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (mListener != null) {
            mListener.receivedBroadcast();
        }
    }

    /**
     * Listener interface for received broadcast messages.
     */
    public interface IabBroadcastListener {
        void receivedBroadcast();
    }
}