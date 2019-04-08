package com.mindyourlovedone.healthcare.utility;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Niki on 04-10-2018.
 */

public class UIEmails {


    public void emailAttachement(Context context, String s, String Data) {
       Preferences preferences = new Preferences(context);
      /*   Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[]{""});
        String name = preferences.getString(PrefConstants.CONNECTED_NAME);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                s); // subject


        String body = "Hi, \n" +
                "\n" +
                "\n" + name +
                " shared this User Instructions with you... \n\n" + Data +
                "\n\n" +
                "Thanks,\n" +
                name;
        // "Mind Your Loved Ones - Support";
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body); // Body

        emailIntent.setPackage("com.google.android.gm");

        if (emailIntent.resolveActivity(context.getPackageManager())!=null)
            context.startActivity(emailIntent);
        else
            Toast.makeText(context,"Gmail App is not installed",Toast.LENGTH_SHORT).show();*/


       Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[]{""});
        String name = preferences.getString(PrefConstants.CONNECTED_NAME);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
               s); // subject


        String body = "Hi, \n" +
                "\n" +
                "\n" + name +
                " shared these "+s+" with you... \n\n" + Data +
                "\n\n" +
                "Thanks,\n" +
                name;
        // "Mind Your Loved Ones - Support";
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body); // Body

       emailIntent.setType("text/plain");

        context.startActivity(Intent.createChooser(emailIntent, "Send Instructions..."));
    }

}
