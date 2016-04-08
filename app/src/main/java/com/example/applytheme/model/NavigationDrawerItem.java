package com.example.applytheme.model;

import com.example.applytheme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 28/03/16.
 */
public class NavigationDrawerItem {

    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> dataList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            NavigationDrawerItem navItem = new NavigationDrawerItem();
            navItem.setTitle("Drawer Item " + i);
            navItem.setImageId(R.drawable.ic_flight_black);
            dataList.add(navItem);
        }
        return dataList;
    }
}
