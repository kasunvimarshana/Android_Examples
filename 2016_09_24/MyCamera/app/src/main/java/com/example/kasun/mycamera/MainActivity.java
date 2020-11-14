package com.example.kasun.mycamera;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST = 1;
    ImageView imageView;
    File image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void capture(View v){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try{
            //File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File storageDir = getApplicationContext().getFilesDir();
            image = File.createTempFile("JPEG1", ".jpg", storageDir);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image));
        }catch(Exception e){
            e.printStackTrace();
        }

        ComponentName camOk =  cameraIntent.resolveActivity(getPackageManager());// camera support karanawada kiyala check karanawa
        if(camOk != null){
            startActivityForResult(cameraIntent, REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST && resultCode == RESULT_OK){

            imageView = (ImageView) findViewById(R.id.imageView);
            Bundle bundle = data.getExtras();
            Bitmap imageBitmap = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(imageBitmap);

            //call the asynctask
            UploadTask ut = new UploadTask();
            ut.execute();

        }
    }

    class UploadTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params){
            String urlString = "http://idex.tk/FileUpload.php";
            File file = image;

            try{

                FileInputStream fileInputStream = new FileInputStream(file);
                URL url = new URL(urlString);

                //connection build
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                conn.setDoInput(true);//input data dena bawa pawaseemata
                conn.setDoOutput(true);//output data labaganna bawa pawaseemata
                conn.setUseCaches(false);//cache eke save wee athi data yama walakweemata

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                conn.setRequestProperty("uploaded_file", file.getName());

                DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes("--*****\r\n");
                dos.writeBytes("Content-disposition: form-data; name=\"uploaded_file\"; filename=\""+file.getName()+"\"\r\n");
                dos.writeBytes("\r\n");

                //1024*1024 network eka thulin yawiyahaki data packet ekaka max size eka
                int buffersize = Math.min(fileInputStream.available(), 1 * 1024 * 1024);

                byte[] buffer = new byte[buffersize];

                int bytesread = fileInputStream.read(buffer, 0, buffersize);
                while(bytesread>0){
                    dos.write(buffer, 0, buffersize);
                    buffersize = Math.min(fileInputStream.available(), 1 * 1024 * 1024);
                    bytesread = fileInputStream.read(buffer, 0, buffersize);
                }
                dos.writeBytes("\r\n");
                dos.writeBytes("--*****--\r\n");

                int responseCode = conn.getResponseCode();
                String responseMessage = conn.getResponseMessage();
                return responseMessage;

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s){
            TextView tv = (TextView) findViewById(R.id.textView);
        }

    }

}
