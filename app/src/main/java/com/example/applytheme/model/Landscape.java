package com.example.applytheme.model;

import com.example.applytheme.R;

import java.util.ArrayList;

/**
 * Created by jose on 23/02/16.
 */
public class Landscape {

    private int imageID;
    private String title;
    private String description;

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Landscape> getData() {
        ArrayList<Landscape> dataList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Landscape landscape = new Landscape();
            landscape.setTitle("Landscape " + i);
            landscape.setImageID(R.drawable.thumb_01);

            dataList.add(landscape);
        }

        return dataList;
    }
}
