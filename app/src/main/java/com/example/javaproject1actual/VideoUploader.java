package com.example.javaproject1actual;

import static java.sql.Types.NULL;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageCapture;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
//import com.android.example.cameraxapp.databinding.ActivityMainBinding;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.common.util.concurrent.ListenableFuture;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.core.Preview;
import androidx.camera.core.CameraSelector;
import android.util.Log;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

import java.io.*;
import java.net.*;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.VideoRecordEvent;
import androidx.core.content.PermissionChecker;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.camera.video.PendingRecording.*;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Locale;


import android.annotation.TargetApi;
import android.app.Activity;

import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.util.List;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder.Builder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.camera.video.Recorder.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
//import androidx.camera.core.VideoCapture;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.video.PendingRecording;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;



import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.video.PendingRecording;

import androidx.camera.video.VideoOutput.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import android.net.Uri;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.RequestBody.Companion.*;
import retrofit2.Call;
import retrofit2.Callback;
//import retrofit2.Response;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

import com.google.common.util.concurrent.ListenableFuture;
import androidx.camera.video.MediaStoreOutputOptions;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;

import android.Manifest;
import android.content.ContentValues;
import android.os.Build;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.Recorder.*;
import androidx.camera.video.PendingRecording.*;
import androidx.camera.video.QualitySelector;
import androidx.core.content.ContextCompat;
import java.io.*;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;
import android.os.Bundle;

import com.google.common.util.concurrent.ListenableFuture;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.*;





public class VideoUploader extends AppCompatActivity {


    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    PreviewView previewView;

    Button capture, bRecording;
    private ImageCapture imageCapture;
    private VideoCapture<Recorder> videoCapture;

    Recording recording = null;

    Dictionary<String, String> dict;

    Dictionary<String, Integer> numberLocater;

    String currentfile;

    private final OkHttpClient client = new OkHttpClient();




    ExecutorService service;


    int cameraFacing = CameraSelector.LENS_FACING_BACK;



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

            String BASE_URL = "http://http://127.0.0.1:5000/upload";

            RequestBody videoBody = RequestBody.create(file, MediaType.parse("video/*"));
            MultipartBody.Part vFile = MultipartBody.Part.createFormData("video", file.getName(), videoBody);

            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)

                    .addFormDataPart("video", file.getName(),
                            RequestBody.create(
                                    new File(root + "/Movies/"+currentfile),
                                    MediaType.get("video/mp4")))
                    .build();



            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .post(requestBody)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                Toast.makeText(this, response.body().string(), Toast.LENGTH_SHORT).show();

                System.out.println(response.body().string());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
            long timestamp = System.currentTimeMillis();
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
        int aspectRatio = aspectRatio(previewView.getWidth(), previewView.getHeight());
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
    private int aspectRatio(int width, int height) {
        double previewRatio = (double) Math.max(width, height) / Math.min(width, height);
        if (Math.abs(previewRatio - 4.0 / 3.0) <= Math.abs(previewRatio - 16.0 / 9.0)) {
            return AspectRatio.RATIO_4_3;
        }
        return AspectRatio.RATIO_16_9;
    }

    private void uploadVideo(File videoFile) throws IOException {


    }





}






