package com.slash3.travelapp.data;

import com.slash3.travelapp.models.Activity;
import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class ActivityData {

    private static final Map<Integer, Activity> activities = new HashMap<>();
    public static Collection<Activity> getAll() {
        return activities.values();
    }
    public static Activity getById(int id) {
        return activities.get(id);
    }
    public static void add(Activity activity) {
        activities.put(activity.getId(), activity);
    }
    public static void remove(int id) {
        activities.remove(id);
    }
}
