package com.example.rima.AdriaProject.Presenters;

import android.graphics.Bitmap;

import com.example.rima.AdriaProject.Interfaces.FullSizePhotoActivityView;
import com.example.rima.AdriaProject.Models.FullSizePhotoActivityModel;
import com.google.firebase.storage.StorageReference;

/**
 * Created by rima on 19/09/2018.
 */

public class FullSizePhotoActivityPresenter {


    FullSizePhotoActivityView view;
    FullSizePhotoActivityModel model;

    public FullSizePhotoActivityPresenter(FullSizePhotoActivityView view){
        this.view=view;
        model=new FullSizePhotoActivityModel();
    }

    public void getThePhoto(String photo_id){

        model.getThePhoto(photo_id,this);
    }

    public void setThePhoto(String photo){
        view.setThePhoto(photo);

    }
    public void uploadThePhotoToFirebase(Bitmap bitmap,StorageReference mStorageRef){

        model.uploadThePhotoToFirebase(bitmap,mStorageRef,this);

    }

    public void ProgressUpload(int currentProgress)
    {
        view.ProgressUpload(currentProgress);
    }

    public void PauseUpload(){

        view.PauseUpload();
    }

    public void SuccessUpload(){

        view.SuccessUpload();

    }

    public void FailureUpload(){

        view.FailureUpload();
    }

}
