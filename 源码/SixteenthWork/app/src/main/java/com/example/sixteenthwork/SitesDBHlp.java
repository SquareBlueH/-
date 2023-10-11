package com.example.sixteenthwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
//创建和编写好数据库操作类
public class SitesDBHlp extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sites";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "sitesInfo";
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " ( " +
                    " id TEXT NOT NULL, " +
                    " name TEXT NOT NULL, " +
                    " phoneNo TEXT, " +
                    " address TEXT, PRIMARY KEY (id));";
    private static final String COL_id = "id";
    private static final String COL_name = "name";
    private static final String COL_phoneNo = "phoneNo";
    private static final String COL_address = "address";

    public SitesDBHlp(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertDB(Site site) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_id, site.getId());
        values.put(COL_name, site.getName());
        values.put(COL_phoneNo, site.getPhoneNo());
        values.put(COL_address, site.getAddress());
        long rowId = db.insert(TABLE_NAME, null, values);
        db.close();
        return rowId;
    }

    public int updateDB(Site site) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_name, site.getName());
        values.put(COL_phoneNo, site.getPhoneNo());
        values.put(COL_address, site.getAddress());
        String whereClause = COL_id + "='" + site.getId() + "'";
        int count = db.update(TABLE_NAME, values, whereClause, null);
        db.close();
        return count;
    }

    public int deleteDB(String id) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = COL_id + "='" + id + "'";
        int count = db.delete(TABLE_NAME, whereClause, null);
        db.close();
        return count;

    }

    public void fillDB() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from sqlite_master where name="+"'"+ TABLE_NAME +"'";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() == 0) {//表不存在则插入数据
            cursor.close();
            db.execSQL(TABLE_CREATE);
            ContentValues[] values = new ContentValues[4];
            for (int i = 0; i < values.length; i++)
                values[i] = new ContentValues();
            values[0].put("id", "wdc");
            values[0].put("name", "王大锤");
            values[0].put("phoneNo", "88888888");
            values[0].put("address", "银滩大道88号");


            values[1].put("id", "wnm");
            values[1].put("name", "王尼玛");
            values[1].put("phoneNo", "6666666");
            values[1].put("address", "南珠大道9号");


            values[2].put("id", "pry");
            values[2].put("name", "潘瑞远");
            values[2].put("phoneNo", "13317791731");
            values[2].put("address", "北部湾中路xx号");


            values[3].put("id", " ppp");
            values[3].put("name", "ppp");
            values[3].put("phoneNo", "110");
            values[3].put("address", "北部湾1号");
            for (ContentValues row : values) {
                db.insert(TABLE_NAME, null, row);
            }
            db.close();
        }
    }
    public ArrayList<String> getInfo(String name){
        SQLiteDatabase db = getReadableDatabase() ;
        String sql = "SELECT name,phoneNo,address FROM " + TABLE_NAME + " WHERE name LIKE ?";
        String[] args = {"%"+ name + "%"};
        Cursor cursor = db.rawQuery(sql, args);
        ArrayList<String> info = new ArrayList<String>();
        int columnCount = cursor . getColumnCount();
        while(cursor . moveToNext()){
            String str = "";
            for(int i=0; i<columnCount; i++)
                str += cursor . getString(i) + "\n";
            info. add(str);
        }
        cursor .close();
        db.close();
        return info;
    }
    public ArrayList<Site> getAllSites(){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {COL_id,COL_name,COL_phoneNo,COL_address};
        Cursor cursor = db.query(TABLE_NAME,columns,null,null,null,null,null);
        ArrayList<Site> sites = new ArrayList<Site>();
        while(cursor .moveToNext()){
            String id = cursor . getString(0);
            String name = cursor . getString(1);
            String phoneNo = cursor . getString(2);
            String address = cursor . getString(3);
            Site site = new Site(id, name, phoneNo, address);
            sites.add(site);
        }
        cursor .close();
        db.close();
        return sites;
    }
}

