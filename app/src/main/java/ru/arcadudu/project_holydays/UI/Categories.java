package ru.arcadudu.project_holydays.UI;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.arcadudu.project_holydays.NetworkService;
import ru.arcadudu.project_holydays.R;
import ru.arcadudu.project_holydays.models.Category;

public class Categories extends AppCompatActivity {

    private static final String TAG = "AA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getCategoryNetwork();

    }



    private List<Category> getCategoryNetwork(){
        NetworkService.getApi().getCategory().enqueue(new Callback<List<Category>>() {


            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.e(TAG, "onResponse: " + response.body());
//                List<Category> categories = response.body();

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());

            }


        });
    }

}