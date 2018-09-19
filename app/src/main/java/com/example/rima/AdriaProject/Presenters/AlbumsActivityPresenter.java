package com.example.rima.AdriaProject.Presenters;

import com.example.rima.AdriaProject.Interfaces.AlbumsActivityView;
import com.example.rima.AdriaProject.Models.AlbumsActivityModel;
import com.example.rima.AdriaProject.POJOs.album;

import java.util.ArrayList;

/**
 * Created by rima on 19/09/2018.
 */

public class AlbumsActivityPresenter {

    AlbumsActivityView view;
    AlbumsActivityModel model;

   public AlbumsActivityPresenter(AlbumsActivityView view){
        this.view=view;
        model=new AlbumsActivityModel();
    }

    public void getAlbums(String user_id){

       model.getAllAlbums(user_id,this);
    }

    public void setListOfAlbums(ArrayList<album> albums){
        view.setListOfAlbums(albums);
    }
}
