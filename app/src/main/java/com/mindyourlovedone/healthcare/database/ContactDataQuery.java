package com.mindyourlovedone.healthcare.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mindyourlovedone.healthcare.model.Contact;

import java.util.ArrayList;

/**
 * Created by varsha on 9/1/2017.
 */

public class ContactDataQuery {
    public static final String TABLE_NAME = "ContactNumber";
    public static final String COL_ID = "Id";
    public static final String COL_ID_FROMTABLE = "idFromTable";
    public static final String COL_USERID = "UserId";
    public static final String COL_CONTACTTYPE = "contactType";
    public static final String COL_VALUE = "value";
    public static final String COL_EMAIL = "userEmail";
    public static final String COL_FROMTABLE = "fromTable";

    static DBHelper dbHelper;
    Context context;


    public ContactDataQuery(Context context, DBHelper dbHelper) {
        this.context = context;
        ContactDataQuery.dbHelper = dbHelper;
    }

    public static String createContactDataTable() {
        String createTableQuery = "create table  If Not Exists " + TABLE_NAME + "(" + COL_ID + " INTEGER," + COL_ID_FROMTABLE + " INTEGER," + COL_USERID + " INTEGER," + COL_CONTACTTYPE + " VARCHAR(30)," + COL_VALUE + " VARCHAR(50)," + COL_EMAIL + " VARCHAR(50)," + COL_FROMTABLE + " VARCHAR(30));";
        return createTableQuery;
    }

    public static String dropTable() {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        return dropTableQuery;
    }

   /* public static boolean insertContactDataTable(String id, String name, String number, String email, byte[] image, String address, String homePhone, String workPhone) {
        boolean flag;
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(COL_ID, id);
        cv.put(COL_NAME, name);
        cv.put(COL_PHONE, number);
        cv.put(COL_EMAIL, email);
        cv.put(COL_IMAGE, image);
        cv.put(COL_ADDRESS, address);
        cv.put(COL_HPHONE, homePhone);
        cv.put(COL_WPHONE, workPhone);

        long rowid = db.insert(TABLE_NAME, null, cv);

        flag = rowid != -1;

        return flag;
    }

    public static ArrayList<Contact> fetchAllContactDetails() {
        ArrayList contactList = new ArrayList();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                int roll = c.getInt(c.getColumnIndex(COL_ID));
                String name = c.getString(c.getColumnIndex(COL_NAME));
                String phone = c.getString(c.getColumnIndex(COL_PHONE));
                String wphone = c.getString(c.getColumnIndex(COL_WPHONE));
                String hphone = c.getString(c.getColumnIndex(COL_HPHONE));
                String email = c.getString(c.getColumnIndex(COL_EMAIL));
                String address = c.getString(c.getColumnIndex(COL_ADDRESS));
                byte[] image = c.getBlob(c.getColumnIndex(COL_IMAGE));

                Contact contact = new Contact();
                contact.setName(name);
                contact.setPhone(phone);
                contact.setHomePhone(hphone);
                contact.setWorkPhone(wphone);
                contact.setEmail(email);
                contact.setImage(image);
                contact.setAddress(address);

                contactList.add(contact);

            } while (c.moveToNext());
        }

        return contactList;
    }*/

    public static void deleteContactDataTable() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
    }
}
