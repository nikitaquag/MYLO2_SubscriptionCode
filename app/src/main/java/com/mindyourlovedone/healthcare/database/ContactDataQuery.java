package com.mindyourlovedone.healthcare.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mindyourlovedone.healthcare.model.ContactData;
import com.mindyourlovedone.healthcare.model.Pharmacy;

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
        String createTableQuery = "create table  If Not Exists " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY, " + COL_ID_FROMTABLE + " INTEGER," + COL_USERID + " INTEGER," + COL_CONTACTTYPE + " VARCHAR(30)," + COL_VALUE + " VARCHAR(50)," + COL_EMAIL + " VARCHAR(50)," + COL_FROMTABLE + " VARCHAR(30));";
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

    public static Boolean insertContactsData(int fromtableid, int userid, String email, String value, String contactType, String fromtable) {
        boolean flag;
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(COL_ID_FROMTABLE, fromtableid);
        cv.put(COL_USERID, userid);
        cv.put(COL_VALUE, value);
        cv.put(COL_EMAIL, email);
        cv.put(COL_CONTACTTYPE, contactType);
        cv.put(COL_FROMTABLE, fromtable);


        long rowid = db.insert(TABLE_NAME, null, cv);

        flag = rowid != -1;

        return flag;
    }

    public static ArrayList<ContactData>fetchContactRecord(int userId, int id, String fromtables) {
        ArrayList contactList = new ArrayList();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                int pid = c.getInt(c.getColumnIndex(COL_ID));
                int idFromtable = c.getInt(c.getColumnIndex(COL_ID_FROMTABLE));
                int userid = c.getInt(c.getColumnIndex(COL_USERID));
                String email = c.getString(c.getColumnIndex(COL_EMAIL));
                String fromtable = c.getString(c.getColumnIndex(COL_FROMTABLE));
                String value = c.getString(c.getColumnIndex(COL_VALUE));
                String type = c.getString(c.getColumnIndex(COL_CONTACTTYPE));
               if (idFromtable==id && fromtable.equalsIgnoreCase(fromtables)) {
                   ContactData contact = new ContactData();
                   contact.setId(pid);
                   contact.setValue(value);
                   contact.setContactType(type);
                   contact.setUserEmail(email);
                   contact.setFromtable(fromtable);
                   contact.setIdFromTable(id);
                   contact.setUserId(userId);


                   contactList.add(contact);
               }

            } while (c.moveToNext());
        }

        return contactList;
    }

    public static boolean deleteRecord(String connection, int id) {
        ArrayList<Pharmacy> noteList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL_FROMTABLE + "='" + connection + "' and " + COL_ID_FROMTABLE + "='" + id + "';", null);

        if (c.moveToFirst()) {
            do {
//                Pharmacy notes = new Pharmacy();
//                notes.setId(c.getInt(c.getColumnIndex(COL_ID)));
//                notes.setUserid(c.getInt(c.getColumnIndex(COL_USER_ID)));
//                notes.setName(c.getString(c.getColumnIndex(COL_NAME)));
//                notes.setAddress(c.getString(c.getColumnIndex(COL_ADDRESS)));
//                notes.setPhone(c.getString(c.getColumnIndex(COL_OFFICE_PHONE)));
//                notes.setFax(c.getString(c.getColumnIndex(COL_FAX)));
//                notes.setWebsite(c.getString(c.getColumnIndex(COL_WEBSITE)));
//                notes.setNote(c.getString(c.getColumnIndex(COL_NOTE)));
//                notes.setPhoto(c.getString(c.getColumnIndex(COL_PHOTO)));
//                notes.setPhotoCard(c.getString(c.getColumnIndex(COL_PHOTOCARD)));
//                notes.setLocator(c.getString(c.getColumnIndex(COL_LOCATOR)));
//
//                noteList.add(notes);

                db.execSQL("delete from " + TABLE_NAME + " where " + COL_FROMTABLE + "='" + connection + "' and " + COL_ID_FROMTABLE + "='" + id + "';");
            } while (c.moveToNext());
        }


        return true;
    }


    public static Boolean updateUserId(int id) {
        boolean flag=true;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c=db.rawQuery("update " + TABLE_NAME + " set "+COL_USERID+ "="+id, null);
        c.moveToFirst();
        c.close();
       /* ContentValues cv = new ContentValues();
        cv.put(COL_USERID, id);
        int rowid = db.update(TABLE_NAME, cv,null, null);

        flag = rowid != 0;*/

        return flag;
    }
}
