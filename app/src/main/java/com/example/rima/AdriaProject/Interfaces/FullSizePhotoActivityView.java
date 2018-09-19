package com.example.rima.AdriaProject.Interfaces;

/**
 * Created by rima on 19/09/2018.
 */

public interface FullSizePhotoActivityView {

    public void initialization();

    public void setThePhoto(String photo);

    public boolean isOnline();

    public void ProgressUpload(int currentProgress);

    public void PauseUpload();

    public void SuccessUpload();

    public void FailureUpload();

    public void startUploading();

    public void getThePhoto();
}
