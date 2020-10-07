package ru.arcadudu.project_holydays;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.arcadudu.project_holydays.UI.Subcategories;
import ru.arcadudu.project_holydays.models.Category;
import ru.arcadudu.project_holydays.models.response.GetCategoryResponse;

public interface UmoriliApi {
    @GET("/categories/all")
    Call<List<Category>> getCategory();

    @GET("/categories/sub/all")
    Call<List<Subcategories>> getSubcategory();
}
