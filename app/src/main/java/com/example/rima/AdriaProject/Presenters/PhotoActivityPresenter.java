package com.example.rima.AdriaProject.Presenters;

import com.example.rima.AdriaProject.Interfaces.PhotosActivityView;
import com.example.rima.AdriaProject.Models.PhotosActivityModel;
import com.example.rima.AdriaProject.POJOs.photo;

import java.util.ArrayList;

/**
 * Created by rima on 19/09/2018.
 */

public class PhotoActivityPresenter {

    PhotosActivityView view;
    PhotosActivityModel model;

    public PhotoActivityPresenter(PhotosActivityView view){
        this.view=view;
        model=new PhotosActivityModel();
    }

    public void getThePhotos(String album_id){

        model.getThePhotos(album_id,this);
    }

    public void setTheListOfPhotos(ArrayList<photo> photos){
        view.setTheListOfPhotos(photos);

    }
}
