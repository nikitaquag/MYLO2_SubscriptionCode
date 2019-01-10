package com.mindyourlovedone.healthcare.DropBox;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by welcome on 12/14/2017.
 */

public class ZipTask extends AsyncTask<String, Void, String> {
    Context con;
    String outZipPath;
    String inputFolderPath;
    ZipListner context;
    ProgressDialog dialog;

    public ZipTask(FilesActivity filesActivity, String absolutePath, String path) {
        inputFolderPath = absolutePath;
        outZipPath = path;
        context = filesActivity;
        con = filesActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(con);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setMessage("Zipping");
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
//            FileOutputStream fos = new FileOutputStream(outZipPath);
//            ZipOutputStream zos = new ZipOutputStream(fos);
//            File srcFile = new File(inputFolderPath);
//            File[] files = srcFile.listFiles();
//            Log.d("", "Zip directory: " + srcFile.getName());
//            for (int i = 0; i < files.length; i++) {
//                Log.d("", "Adding file: " + files[i].getName());
//                byte[] buffer = new byte[1024];
//                FileInputStream fis = new FileInputStream(files[i]);
//                zos.putNextEntry(new ZipEntry(files[i].getName()));
//                int length;
//                while ((length = fis.read(buffer)) > 0) {
//                    zos.write(buffer, 0, length);
//                }
//                zos.closeEntry();
//                fis.close();
//            }
//
//            zos.close();

            if (zipFileAtPath(inputFolderPath, outZipPath)) {//nikita
                return outZipPath;
            }

        } catch (Exception ioe) {
            Log.e("", ioe.getMessage());
        }
        return null;
    }

    //nikita
    public boolean zipFileAtPath(String sourcePath, String toLocation) {
        final int BUFFER = 2048;

        File sourceFile = new File(sourcePath);
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(toLocation);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                    dest));
            if (sourceFile.isDirectory()) {
                zipSubFolder(out, sourceFile, sourceFile.getParent().length());
            } else {
                byte data[] = new byte[BUFFER];
                FileInputStream fi = new FileInputStream(sourcePath);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(getLastPathComponent(sourcePath));
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
/*
 *
 * Zips a subfolder
 *
 */

    private void zipSubFolder(ZipOutputStream out, File folder,
                              int basePathLength) throws IOException {

        final int BUFFER = 2048;

        File[] fileList = folder.listFiles();
        BufferedInputStream origin = null;
        for (File file : fileList) {
            if (file.isDirectory()) {
                zipSubFolder(out, file, basePathLength);
            } else {
                byte data[] = new byte[BUFFER];
                String unmodifiedFilePath = file.getPath();
                String relativePath = unmodifiedFilePath
                        .substring(basePathLength);
                FileInputStream fi = new FileInputStream(unmodifiedFilePath);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(relativePath);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
        }
    }

    /*
     * gets the last path component
     *
     * Example: getLastPathComponent("downloads/example/fileToZip");
     * Result: "fileToZip"
     */
    public String getLastPathComponent(String filePath) {
        String[] segments = filePath.split("/");
        if (segments.length == 0)
            return "";
        String lastPathComponent = segments[segments.length - 1];
        return lastPathComponent;
    }
    //nikita ....


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        context.getFile(s);
    }
}
