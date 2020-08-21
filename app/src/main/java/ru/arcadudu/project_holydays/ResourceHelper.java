package ru.arcadudu.project_holydays;

import java.util.Arrays;

public class ResourceHelper {
    public static int getIcon(String categoryName) {
        switch (categoryName) {
            case "Food":
                return R.drawable.icon_food;
            case "Entertainment":
                return R.drawable.icon_entertainment;
            case "Beauty":
                return R.drawable.icon_beauty;
            case "Health":
                return R.drawable.icon_health;
            case "Automobile":
                return R.drawable.icon_auto;
            case "Sports":
                return R.drawable.icon_sports;
            case "Souvenir":
                return R.drawable.icon_souvenir;
            case "Education":
                return R.drawable.icon_education;
            default:
                return R.drawable.icon_menu;
        }

    }
}
