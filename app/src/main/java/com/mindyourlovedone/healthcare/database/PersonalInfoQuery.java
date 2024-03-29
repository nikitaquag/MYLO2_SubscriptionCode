package com.mindyourlovedone.healthcare.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mindyourlovedone.healthcare.model.PersonalInfo;

import java.util.ArrayList;

/**
 * Created by welcome on 9/12/2017.
 */

public class PersonalInfoQuery {
    public static final String TABLE_NAME = "PersonalInfo";
    public static final String COL_NAME = "Name";
    public static final String COL_EMAIL = "Email";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_COUNTRY = "Country";
    public static final String COL_MOBILE = "Mobile";
    public static final String COL_PHONE = "Phone";
    public static final String COL_GENDER = "Gender";
    public static final String COL_DOB = "DOB";
    public static final String COL_PASS = "Password";
    public static final String COL_PHOTO = "Photo";
    public static final String COL_ID = "Id";
    public static final String COL_HEIGHT = "height";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_PROFESSION = "profession";
    public static final String COL_EMPLOYED = "employed";
    public static final String COL_MANGER_PHONE = "Manager_Phone";
    public static final String COL_RELIGION = "religion";
    public static final String COL_EYES = "eyes";
    public static final String COL_LANG = "language";
    public static final String COL_MARITAL = "marital_status";
    public static final String COL_VETERAN = "veteran";
    public static final String COL_PET = "pet";
    public static final String COL_IDNUMBER = "IDNUmber";
    public static final String COL_PHOTOCARD = "PhotoCard";
    public static final String COL_ENGLISH = "English";
    public static final String COL_CHILD = "child";
    public static final String COL_FRIEND = "friend";
    public static final String COL_GRAND = "grandparent";
    public static final String COL_PARENT = "parent";
    public static final String COL_SPOUSE = "spouse";
    public static final String COL_OTHER_SIGN = "significant_other";
    public static final String COL_OTHER = "other";
    public static final String COL_LIVE = "Living";
    public static final String COL_OTHER_LANG = "other_language";
    static DBHelper dbHelper;
    Context context;


    public PersonalInfoQuery(Context context, DBHelper dbHelper) {
        this.context = context;
        PersonalInfoQuery.dbHelper = dbHelper;
    }

    public static String createPersonalInfoTable() {
        String createTableQuery = "create table  If Not Exists " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY, " + COL_NAME + " VARCHAR(50)," + COL_EMAIL + " VARCHAR(50)," + COL_MOBILE + " VARCHAR(20)," + COL_PHONE + " VARCHAR(20)," +
                COL_GENDER + " VARCHAR(20)," + COL_ADDRESS + " TEXT," + COL_COUNTRY + " VARCHAR(40)," + COL_DOB + " VARCHAR(20)," + COL_PASS + " VARCHAR(10)," +
                COL_HEIGHT + " VARCHAR(10)," + COL_WEIGHT + " VARCHAR(10)," + COL_PROFESSION + " VARCHAR(10)," + COL_EMPLOYED + " VARCHAR(10)," + COL_RELIGION + " TEXT," +
                COL_MANGER_PHONE + " VARCHAR(20)," + COL_EYES + " VARCHAR(10)," + COL_LANG + " VARCHAR(10)," + COL_MARITAL + " VARCHAR(10)," + COL_VETERAN + " VARCHAR(10)," + COL_ENGLISH + " VARCHAR(10)," +
                COL_PET + " VARCHAR(10)," + COL_IDNUMBER + " TEXT," + COL_PHOTOCARD + " VARCHAR(50)," +
                COL_CHILD + " VARCHAR(10)," + COL_FRIEND + " VARCHAR(10)," + COL_GRAND + " VARCHAR(10)," + COL_PARENT + " VARCHAR(10)," + COL_SPOUSE + " VARCHAR(10)," +
                COL_OTHER_SIGN + " TEXT," + COL_OTHER_LANG + " TEXT," + COL_OTHER + " TEXT," + COL_LIVE + " VARCHAR(20)," +
                COL_PHOTO + " VARCHAR(50));";

        return createTableQuery;
    }

    public static String dropTable() {
        String dropTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        return dropTableQuery;
    }

    public static Boolean insertPersonalInfoData(String name, String email, String address, String country, String phone, String bdate, String password, String photo, String homephone, String gender, String photoCard) {
        boolean flag;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_EMAIL, email);
        cv.put(COL_ADDRESS, address);
        cv.put(COL_COUNTRY, country);
        cv.put(COL_MOBILE, phone);
        cv.put(COL_DOB, bdate);
        cv.put(COL_PASS, password);
        cv.put(COL_PHOTO, photo);
        cv.put(COL_PHONE, homephone);
        cv.put(COL_GENDER, gender);
        cv.put(COL_PHOTOCARD, photoCard);


        long rowid = db.insert(TABLE_NAME, null, cv);

        flag = rowid != -1;

        return flag;
    }

    public static ArrayList<PersonalInfo> fetchOneRecord(String username, String password) {
        ArrayList<PersonalInfo> personList = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TABLE_NAME + ";", null);
        if (c != null && c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    if (username.equals(c.getString(c.getColumnIndex(COL_EMAIL))) && password.equals(c.getString(c.getColumnIndex(COL_PASS)))) {
                        {
                            PersonalInfo Person = new PersonalInfo();

                            Person.setName(c.getString(c.getColumnIndex(COL_NAME)));
                            Person.setId(c.getInt(c.getColumnIndex(COL_ID)));
                            Person.setAddress(c.getString(c.getColumnIndex(COL_ADDRESS)));
                            Person.setEmail(c.getString(c.getColumnIndex(COL_EMAIL)));
                            Person.setCountry(c.getString(c.getColumnIndex(COL_COUNTRY)));

                            Person.setPhone(c.getString(c.getColumnIndex(COL_MOBILE)));
                            Person.setPassword(c.getString(c.getColumnIndex(COL_PASS)));
                            Person.setDob(c.getString(c.getColumnIndex(COL_DOB)));
                            Person.setPhoto(c.getString(c.getColumnIndex(COL_PHOTO)));
                            Person.setHomePhone(c.getString(c.getColumnIndex(COL_PHONE)));

                            Person.setGender(c.getString(c.getColumnIndex(COL_GENDER)));
                            Person.setHeight(c.getString(c.getColumnIndex(COL_HEIGHT)));
                            Person.setWeight(c.getString(c.getColumnIndex(COL_WEIGHT)));
                            Person.setProfession(c.getString(c.getColumnIndex(COL_PROFESSION)));
                            Person.setEmployed(c.getString(c.getColumnIndex(COL_EMPLOYED)));

                            Person.setReligion(c.getString(c.getColumnIndex(COL_RELIGION)));
                            Person.setEyes(c.getString(c.getColumnIndex(COL_EYES)));
                            Person.setLanguage(c.getString(c.getColumnIndex(COL_LANG)));
                            Person.setMarital_status(c.getString(c.getColumnIndex(COL_MARITAL)));
                            Person.setVeteran(c.getString(c.getColumnIndex(COL_VETERAN)));

                            Person.setPet(c.getString(c.getColumnIndex(COL_PET)));
                            Person.setIdnumber(c.getString(c.getColumnIndex(COL_IDNUMBER)));
                            Person.setManager_phone(c.getString(c.getColumnIndex(COL_MANGER_PHONE)));
                            Person.setPhotoCard(c.getString(c.getColumnIndex(COL_PHOTOCARD)));
                            Person.setEnglish(c.getString(c.getColumnIndex(COL_ENGLISH)));

                            Person.setChildren(c.getString(c.getColumnIndex(COL_CHILD)));
                            Person.setFriend(c.getString(c.getColumnIndex(COL_FRIEND)));

                            Person.setGrand(c.getString(c.getColumnIndex(COL_GRAND)));
                            Person.setParents(c.getString(c.getColumnIndex(COL_PARENT)));
                            Person.setSpouse(c.getString(c.getColumnIndex(COL_SPOUSE)));
                            Person.setSign_other(c.getString(c.getColumnIndex(COL_OTHER_SIGN)));
                            Person.setOther_person(c.getString(c.getColumnIndex(COL_OTHER)));
                            Person.setLive(c.getString(c.getColumnIndex(COL_LIVE)));
                            Person.setOtherLang(c.getString(c.getColumnIndex(COL_OTHER_LANG)));

                            personList.add(Person);
                        }
                    }
                } while (c.moveToNext());
            }
        }

        return personList;
    }


    public static PersonalInfo fetchEmailRecord(int email) {
        PersonalInfo connection = new PersonalInfo();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL_ID + "='" + email + "';", null);

        if (c.moveToFirst()) {
            do {
                connection.setName(c.getString(c.getColumnIndex(COL_NAME)));
                connection.setId(c.getInt(c.getColumnIndex(COL_ID)));
                connection.setAddress(c.getString(c.getColumnIndex(COL_ADDRESS)));
                connection.setEmail(c.getString(c.getColumnIndex(COL_EMAIL)));
                connection.setPhone(c.getString(c.getColumnIndex(COL_MOBILE)));

                connection.setPhoto(c.getString(c.getColumnIndex(COL_PHOTO)));
                connection.setCountry(c.getString(c.getColumnIndex(COL_COUNTRY)));
                connection.setDob(c.getString(c.getColumnIndex(COL_DOB)));
                connection.setHomePhone(c.getString(c.getColumnIndex(COL_PHONE)));
                connection.setGender(c.getString(c.getColumnIndex(COL_GENDER)));

                connection.setHeight(c.getString(c.getColumnIndex(COL_HEIGHT)));
                connection.setWeight(c.getString(c.getColumnIndex(COL_WEIGHT)));
                connection.setProfession(c.getString(c.getColumnIndex(COL_PROFESSION)));
                connection.setEmployed(c.getString(c.getColumnIndex(COL_EMPLOYED)));
                connection.setReligion(c.getString(c.getColumnIndex(COL_RELIGION)));

                connection.setEyes(c.getString(c.getColumnIndex(COL_EYES)));
                connection.setLanguage(c.getString(c.getColumnIndex(COL_LANG)));
                connection.setMarital_status(c.getString(c.getColumnIndex(COL_MARITAL)));
                connection.setVeteran(c.getString(c.getColumnIndex(COL_VETERAN)));
                connection.setPet(c.getString(c.getColumnIndex(COL_PET)));

                connection.setIdnumber(c.getString(c.getColumnIndex(COL_IDNUMBER)));
                connection.setManager_phone(c.getString(c.getColumnIndex(COL_MANGER_PHONE)));
                connection.setPhotoCard(c.getString(c.getColumnIndex(COL_PHOTOCARD)));
                connection.setEnglish(c.getString(c.getColumnIndex(COL_ENGLISH)));

                connection.setChildren(c.getString(c.getColumnIndex(COL_CHILD)));
                connection.setFriend(c.getString(c.getColumnIndex(COL_FRIEND)));

                connection.setGrand(c.getString(c.getColumnIndex(COL_GRAND)));
                connection.setParents(c.getString(c.getColumnIndex(COL_PARENT)));
                connection.setSpouse(c.getString(c.getColumnIndex(COL_SPOUSE)));
                connection.setSign_other(c.getString(c.getColumnIndex(COL_OTHER_SIGN)));
                connection.setOther_person(c.getString(c.getColumnIndex(COL_OTHER)));
                connection.setLive(c.getString(c.getColumnIndex(COL_LIVE)));
                connection.setOtherLang(c.getString(c.getColumnIndex(COL_OTHER_LANG)));

            } while (c.moveToNext());
        }

        return connection;
    }

    public static Boolean searchEmailAvailability(String email) {
        Boolean flag;
        PersonalInfo connection = new PersonalInfo();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL_EMAIL + "='" + email + "';", null);

        flag = c.moveToFirst();

        return flag;
    }

    public static Boolean updatePersonalInfoData(int id, String name, String email, String address, String country, String phone, String bdate, String photo, String homephone, String gender, String height, String weight, String eyes, String profession, String employed, String language, String marital_status, String religion, String veteran, String idnumber, String pet, String manager_phone, String photoCard, String english, String child, String friend, String grandParent, String parent, String spouse, String other, String liveOther, String live, String otherLang) {
        boolean flag;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_EMAIL, email);
        cv.put(COL_ADDRESS, address);
        cv.put(COL_COUNTRY, country);
        cv.put(COL_MOBILE, phone);
        cv.put(COL_DOB, bdate);
        cv.put(COL_PHOTO, photo);
        cv.put(COL_PHONE, homephone);
        cv.put(COL_GENDER, gender);

        cv.put(COL_HEIGHT, height);
        cv.put(COL_WEIGHT, weight);
        cv.put(COL_PROFESSION, profession);
        cv.put(COL_EMPLOYED, employed);
        cv.put(COL_RELIGION, religion);
        cv.put(COL_EYES, eyes);
        cv.put(COL_LANG, language);
        cv.put(COL_MARITAL, marital_status);
        cv.put(COL_VETERAN, veteran);
        cv.put(COL_PET, pet);
        cv.put(COL_IDNUMBER, idnumber);
        cv.put(COL_MANGER_PHONE, manager_phone);
        cv.put(COL_PHOTOCARD, photoCard);
        cv.put(COL_ENGLISH, english);

        cv.put(COL_CHILD, child);
        cv.put(COL_FRIEND, friend);
        cv.put(COL_GRAND, grandParent);
        cv.put(COL_PARENT, parent);
        cv.put(COL_SPOUSE, spouse);
        cv.put(COL_OTHER_SIGN, other);
        cv.put(COL_OTHER, liveOther);
        cv.put(COL_LIVE, live);
        cv.put(COL_OTHER_LANG, otherLang);


        int rowid = db.update(TABLE_NAME, cv, COL_ID + "=" + id, null);

        flag = rowid != 0;

        return flag;
    }

    public static PersonalInfo fetchProfile(String email) {
        PersonalInfo connection = new PersonalInfo();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL_EMAIL + "='" + email + "';", null);

        if (c.moveToFirst()) {
            do {
                connection.setName(c.getString(c.getColumnIndex(COL_NAME)));
                connection.setId(c.getInt(c.getColumnIndex(COL_ID)));
                connection.setAddress(c.getString(c.getColumnIndex(COL_ADDRESS)));
                connection.setEmail(c.getString(c.getColumnIndex(COL_EMAIL)));
                connection.setPhone(c.getString(c.getColumnIndex(COL_MOBILE)));

                connection.setPhoto(c.getString(c.getColumnIndex(COL_PHOTO)));
                connection.setCountry(c.getString(c.getColumnIndex(COL_COUNTRY)));
                connection.setDob(c.getString(c.getColumnIndex(COL_DOB)));
                connection.setHomePhone(c.getString(c.getColumnIndex(COL_PHONE)));
                connection.setGender(c.getString(c.getColumnIndex(COL_GENDER)));

                connection.setHeight(c.getString(c.getColumnIndex(COL_HEIGHT)));
                connection.setWeight(c.getString(c.getColumnIndex(COL_WEIGHT)));
                connection.setProfession(c.getString(c.getColumnIndex(COL_PROFESSION)));
                connection.setEmployed(c.getString(c.getColumnIndex(COL_EMPLOYED)));
                connection.setReligion(c.getString(c.getColumnIndex(COL_RELIGION)));

                connection.setEyes(c.getString(c.getColumnIndex(COL_EYES)));
                connection.setLanguage(c.getString(c.getColumnIndex(COL_LANG)));
                connection.setMarital_status(c.getString(c.getColumnIndex(COL_MARITAL)));
                connection.setVeteran(c.getString(c.getColumnIndex(COL_VETERAN)));
                connection.setPet(c.getString(c.getColumnIndex(COL_PET)));

                connection.setIdnumber(c.getString(c.getColumnIndex(COL_IDNUMBER)));
                connection.setManager_phone(c.getString(c.getColumnIndex(COL_MANGER_PHONE)));
                connection.setPhotoCard(c.getString(c.getColumnIndex(COL_PHOTOCARD)));
                connection.setEnglish(c.getString(c.getColumnIndex(COL_ENGLISH)));

                connection.setChildren(c.getString(c.getColumnIndex(COL_CHILD)));
                connection.setFriend(c.getString(c.getColumnIndex(COL_FRIEND)));

                connection.setGrand(c.getString(c.getColumnIndex(COL_GRAND)));
                connection.setParents(c.getString(c.getColumnIndex(COL_PARENT)));
                connection.setSpouse(c.getString(c.getColumnIndex(COL_SPOUSE)));
                connection.setSign_other(c.getString(c.getColumnIndex(COL_OTHER_SIGN)));
                connection.setOther_person(c.getString(c.getColumnIndex(COL_OTHER)));
                connection.setLive(c.getString(c.getColumnIndex(COL_LIVE)));
                connection.setOtherLang(c.getString(c.getColumnIndex(COL_OTHER_LANG)));

            } while (c.moveToNext());
        }

        return connection;

    }

    public static PersonalInfo fetchProfiles() {
        PersonalInfo connection = new PersonalInfo();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + ";", null);

        if (c.moveToFirst()) {
            do {
                connection.setName(c.getString(c.getColumnIndex(COL_NAME)));
                connection.setId(c.getInt(c.getColumnIndex(COL_ID)));
                connection.setAddress(c.getString(c.getColumnIndex(COL_ADDRESS)));
                connection.setEmail(c.getString(c.getColumnIndex(COL_EMAIL)));
                connection.setPhone(c.getString(c.getColumnIndex(COL_MOBILE)));

                connection.setPhoto(c.getString(c.getColumnIndex(COL_PHOTO)));
                connection.setCountry(c.getString(c.getColumnIndex(COL_COUNTRY)));
                connection.setDob(c.getString(c.getColumnIndex(COL_DOB)));
                connection.setHomePhone(c.getString(c.getColumnIndex(COL_PHONE)));
                connection.setGender(c.getString(c.getColumnIndex(COL_GENDER)));

                connection.setHeight(c.getString(c.getColumnIndex(COL_HEIGHT)));
                connection.setWeight(c.getString(c.getColumnIndex(COL_WEIGHT)));
                connection.setProfession(c.getString(c.getColumnIndex(COL_PROFESSION)));
                connection.setEmployed(c.getString(c.getColumnIndex(COL_EMPLOYED)));
                connection.setReligion(c.getString(c.getColumnIndex(COL_RELIGION)));

                connection.setEyes(c.getString(c.getColumnIndex(COL_EYES)));
                connection.setLanguage(c.getString(c.getColumnIndex(COL_LANG)));
                connection.setMarital_status(c.getString(c.getColumnIndex(COL_MARITAL)));
                connection.setVeteran(c.getString(c.getColumnIndex(COL_VETERAN)));
                connection.setPet(c.getString(c.getColumnIndex(COL_PET)));

                connection.setIdnumber(c.getString(c.getColumnIndex(COL_IDNUMBER)));
                connection.setManager_phone(c.getString(c.getColumnIndex(COL_MANGER_PHONE)));
                connection.setPhotoCard(c.getString(c.getColumnIndex(COL_PHOTOCARD)));
                connection.setEnglish(c.getString(c.getColumnIndex(COL_ENGLISH)));

                connection.setChildren(c.getString(c.getColumnIndex(COL_CHILD)));
                connection.setFriend(c.getString(c.getColumnIndex(COL_FRIEND)));

                connection.setGrand(c.getString(c.getColumnIndex(COL_GRAND)));
                connection.setParents(c.getString(c.getColumnIndex(COL_PARENT)));
                connection.setSpouse(c.getString(c.getColumnIndex(COL_SPOUSE)));
                connection.setSign_other(c.getString(c.getColumnIndex(COL_OTHER_SIGN)));
                connection.setOther_person(c.getString(c.getColumnIndex(COL_OTHER)));
                connection.setLive(c.getString(c.getColumnIndex(COL_LIVE)));
                connection.setOtherLang(c.getString(c.getColumnIndex(COL_OTHER_LANG)));

            } while (c.moveToNext());
        }

        return connection;

    }

    public static Boolean fetchEmailRecord(String email) {
        Boolean flag = false;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from " + TABLE_NAME + " where " + COL_EMAIL + "='" + email + "';", null);

        flag = c.moveToFirst();

        return flag;
    }
}
