package com.example.rima.AdriaProject.Interfaces;

import com.example.rima.AdriaProject.POJOs.album;

import java.util.ArrayList;

/**
 * Created by rima on 19/09/2018.
 */

public interface AlbumsActivityView {

    public void initialization();

    public void backToTheLoginActivity();

    public boolean isOnline();

    public void goToPhotoActivity(int position);

    public void checkingLogin();

    public void setListOfAlbums(ArrayList<album> albums);

    public void fetchData();

}
