package com.example.javaproject1actual;


import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageCapture;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;

import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.Dictionary;
import java.util.Hashtable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;

import androidx.camera.video.VideoRecordEvent;


import com.google.common.util.concurrent.ListenableFuture;



import android.widget.Button;

import android.util.Log;


import java.io.*;
import java.net.*;

import androidx.activity.result.ActivityResultCallback;

import androidx.camera.core.AspectRatio;

import androidx.camera.video.PendingRecording.*;



import android.os.Environment;


import java.io.File;
import java.io.IOException;





import androidx.activity.EdgeToEdge;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import androidx.camera.video.Recorder.Builder;

import androidx.camera.video.Recorder.*;




import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import androidx.camera.video.PendingRecording;






import androidx.camera.video.VideoOutput.*;




import okhttp3.MultipartBody;

import okhttp3.RequestBody.Companion.*;


import okhttp3.Call;
import okhttp3.Callback;







import java.util.concurrent.Executor;



import androidx.camera.video.Recorder.*;
import androidx.camera.video.PendingRecording.*;

import java.io.*;
import java.util.ArrayList;



import java.net.*;





public class VideoUploader extends AppCompatActivity {


    PreviewView previewView;

    Button capture, bRecording;
    private VideoCapture<Recorder> videoCapture;

    Recording recording = null;

    Dictionary<String, String> dict;

    Dictionary<String, Integer> numberLocater;

    String currentfile;

    private final OkHttpClient client = new OkHttpClient();




    ExecutorService service;


    int cameraFacing = CameraSelector.LENS_FACING_BACK;

    private static final String TAG = "MyActivity";




    private final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean result) {
            if (result) {
                startCamera(cameraFacing);
            }
        }
    });




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_uploader);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        capture = findViewById(R.id.camera_button);
        bRecording = findViewById(R.id.button5);
        previewView = findViewById(R.id.preview_view);

        dict = new Hashtable<>();
        dict.put("Turn on lights", "LightOn");
        dict.put("Turn off lights", "LightOff");
        dict.put("Turn on fan", "FanOn");
        dict.put("Turn off fan", "FanOff");
        dict.put("Increase fan speed", "FanUp");
        dict.put("decrease fan speed", "FanDown");
        dict.put("Set Thermostat to specified temperature", "SetThermo");
        dict.put("number 0", "Num0");
        dict.put("Number 1", "Num1");
        dict.put("Number 2", "Num2");
        dict.put("Number 3", "Num3");
        dict.put("Number 4", "Num4");
        dict.put("Number 5", "Num5");
        dict.put("Number 6", "Num6");
        dict.put("Number 7", "Num7");
        dict.put("Number 8", "Num8");
        dict.put("Number 9", "Num9");

        numberLocater = new Hashtable<>();
        numberLocater.put("Turn on lights", 0);
        numberLocater.put("Turn off lights", 1);
        numberLocater.put("Turn on fan", 2);
        numberLocater.put("Turn off fan", 3);
        numberLocater.put("Increase fan speed", 4);
        numberLocater.put("decrease fan speed", 5);
        numberLocater.put("Set Thermostat to specified temperature", 6);
        numberLocater.put("number 0", 7);
        numberLocater.put("Number 1", 8);
        numberLocater.put("Number 2", 9);
        numberLocater.put("Number 3", 10);
        numberLocater.put("Number 4", 11);
        numberLocater.put("Number 5", 12);
        numberLocater.put("Number 6", 13);
        numberLocater.put("Number 7", 14);
        numberLocater.put("Number 8", 15);
        numberLocater.put("Number 9", 16);

        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        capture.setOnClickListener(view -> {
            if (ActivityCompat.checkSelfPermission(VideoUploader.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                activityResultLauncher.launch(Manifest.permission.CAMERA);
            } else if (ActivityCompat.checkSelfPermission(VideoUploader.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                activityResultLauncher.launch(Manifest.permission.RECORD_AUDIO);
            } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P && ActivityCompat.checkSelfPermission(VideoUploader.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                activityResultLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            } else {
                try {
                    captureVideo();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        bRecording.setOnClickListener(view -> {




            String root = Environment.getExternalStorageDirectory().toString();
            File file = new File(root + "/Movies/"+currentfile);

            String BASE_URL = "http://10.0.2.2:5000/upload";

            RequestBody videoBody = RequestBody.create(file, MediaType.parse("video/*"));
            MultipartBody.Part vFile = MultipartBody.Part.createFormData("video", file.getName(), videoBody);

            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("video", file.getName(), videoBody)
                    .build();



            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    
                    String an = "Request failed: " + e.getMessage();
                    Log.d(TAG, an);


                    //Toast.makeText(VideoUploader.this, an, Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {

                        Log.d(TAG, "Unexpected code: " + response);

                        return;
                    }
                    // Process the response body
                    String responseBody = response.body().string();
                    System.out.println("Response: " + responseBody);
                    file.delete();
                }
            });







            Bundle extras1= getIntent().getExtras();
            String valu1 = "";
            if (extras1!= null) {
                valu1 = extras1.getString("Gesture");

            }
            ArrayList<Integer> attempt1 = extras1.getIntegerArrayList("Attempts");
            attempt1.set(numberLocater.get(valu1),attempt1.get(numberLocater.get(valu1))+1); Intent intent = new Intent(this,MainActivity.class);
            intent.putIntegerArrayListExtra("Attempts",attempt1);
            startActivity(intent);

        });


        if (ContextCompat.checkSelfPermission(VideoUploader.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            activityResultLauncher.launch(Manifest.permission.CAMERA);
        } else {
            startCamera(cameraFacing);

        }




        service = Executors.newSingleThreadExecutor();
    }



    public void captureVideo() throws InterruptedException, IOException {
        if (videoCapture != null) {

            Recording recording1 = recording;
            if (recording1 != null){
                recording1.stop();
                recording = null;
                return;

            }

            Bundle extras = getIntent().getExtras();

            String value = "";
            if (extras != null) {
                value = extras.getString("Gesture");

            }
            ArrayList<Integer> attempts = extras.getIntegerArrayList("Attempts");



            String name = dict.get(value)+"_PRACTICE_"+ attempts.get(numberLocater.get(value)) + "_Booth.mp4";
            currentfile=name;

            String root = Environment.getExternalStorageDirectory().toString();
            File file = new File(root + "/Movies/"+name);
            file.delete();
            if(file.exists()){
                file.getCanonicalFile().delete();
                if(file.exists()){
                    getApplicationContext().deleteFile(file.getName());
                }
            }


            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, name);
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4");

            MediaStoreOutputOptions mediaStoreOutputOptions = new MediaStoreOutputOptions.Builder(getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
                    .setContentValues(contentValues).setDurationLimitMillis(5000)
                    .build();

            Recorder recording2 = videoCapture.getOutput();
            PendingRecording recording6 =recording2.prepareRecording(this,mediaStoreOutputOptions);

            recording=recording6.start(ContextCompat.getMainExecutor(this), videoRecordEvent -> {
                if (videoRecordEvent instanceof VideoRecordEvent.Start) {
                    capture.setEnabled(true);
                } else if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                    if (!((VideoRecordEvent.Finalize) videoRecordEvent).hasError()) {
                        String msg = "Video capture Ended Early: " + ((VideoRecordEvent.Finalize) videoRecordEvent).getOutputResults().getOutputUri();
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    } else if(((VideoRecordEvent.Finalize) videoRecordEvent).getError()== VideoRecordEvent.Finalize.ERROR_DURATION_LIMIT_REACHED){
                        recording.close();
                        recording = null;
                        String msg = "5 sec Video Recorded: " + ((VideoRecordEvent.Finalize) videoRecordEvent).getError();
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    } else{
                        recording.close();
                        recording = null;
                        String msg = "Saved: " + ((VideoRecordEvent.Finalize) videoRecordEvent).getError();
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

                    }

                }
            });





            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
               if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                   return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }






            recording.stop();

        }

    }

    Executor getExecutor() {
        return ContextCompat.getMainExecutor(this);
    }

    public void startCamera(int cameraFacing) {

        ListenableFuture<ProcessCameraProvider> processCameraProvider = ProcessCameraProvider.getInstance(VideoUploader.this);
        processCameraProvider.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = processCameraProvider.get();
                Preview preview = new Preview.Builder().build();
                preview.setSurfaceProvider(previewView.getSurfaceProvider());

                Recorder recorder = new Builder()
                        .setQualitySelector(QualitySelector.from(Quality.HIGHEST))
                        .build();
                videoCapture = VideoCapture.withOutput(recorder);

                cameraProvider.unbindAll();

                CameraSelector cameraSelector = new CameraSelector.Builder()
                        .requireLensFacing(cameraFacing).build();

                Camera camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview, videoCapture);


            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(VideoUploader.this));
    }








}






