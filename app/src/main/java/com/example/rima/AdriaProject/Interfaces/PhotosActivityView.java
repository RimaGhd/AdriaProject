package com.example.rima.AdriaProject.Interfaces;

import com.example.rima.AdriaProject.POJOs.photo;

import java.util.ArrayList;

/**
 * Created by rima on 19/09/2018.
 */

public interface PhotosActivityView {

    public void initialization();

    public void goToFullSizePhotoActivity(int position);

    public boolean isOnline();

    public void setTheListOfPhotos(ArrayList<photo> photos);

    public void fetchData();
}
