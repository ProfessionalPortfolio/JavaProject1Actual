package com.example.javaproject1actual;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {

    public class GreetResponse {
        private String message;

        public String getMessage() {
            return message;
        }
    }


    @GET("api/greet")
    Call<GreetResponse> greet(@Query("name") String name);

    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadVideo(
            @Part MultipartBody.Part video
    );


}
