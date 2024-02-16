package com.slash3.travelapp.data;

import com.slash3.travelapp.Models.Activity;
import jakarta.persistence.Entity;

import java.util.ArrayList;

public class ActivityData {

    public static ArrayList<Activity> findByColumnAndValue(String column, String value, Iterable<Activity> allActivities) {

        ArrayList<Activity> results = new ArrayList<>();

        if (value.equalsIgnoreCase("all")){
            return (ArrayList<Activity>) allActivities;
        }

        if (column.equals("all")){
            results = findByValue(value, allActivities);
            return results;
        }
        for (Activity activity : allActivities) {

            String aValue = getFieldValue(activity, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(activity);
            }
        }

        return results;
    }

    public static String getFieldValue(Activity activity, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = activity.getName();
        } else if (fieldName.equals("trips")){
            theValue = activity.getSelectedByTrips().toString();
        } else {
            theValue = activity.getLocation().toString();
        }

        return theValue;
    }


    public static ArrayList<Activity> findByValue(String value, Iterable<Activity> allActivities) {


        ArrayList<Activity> results = new ArrayList<>();

        for (Activity activity : allActivities) {

            if (activity.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(activity);
            } else if (activity.getLocation().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(activity);
            } else if (activity.getSelectedByTrips().toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(activity);
            }

        }

        return results;
    }


}
