package com.mindyourlovedone.healthcare.utility;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Niki on 04-10-2018.
 */

public class UIEmails {


    public void emailAttachement(Context context, String s, String Data) {
        Preferences preferences = new Preferences(context);
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[]{""});
        String name = preferences.getString(PrefConstants.CONNECTED_NAME);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, s); // subject


        String body = "Hi, \n" +
                "\n" +
                "\n" + name +
                " shared this User Instructions with you... \n\n" + Data +
                "\n\n" +
                "Thanks,\n" +
                name;
        // "Mind Your Loved Ones - Support";
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body); // Body

        emailIntent.setType("application/email");

        context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

}
