package com.example.rima.AdriaProject.Views;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.rima.AdriaProject.Adapters.PhotosAdapter;
import com.example.rima.AdriaProject.Adapters.RecyclerViewClickListener;
import com.example.rima.AdriaProject.Interfaces.PhotosActivityView;
import com.example.rima.AdriaProject.POJOs.photo;
import com.example.rima.AdriaProject.Presenters.PhotoActivityPresenter;
import com.example.rima.AdriaProject.R;

import java.util.ArrayList;

public class PhotosActivity extends AppCompatActivity implements PhotosActivityView {

    RecyclerView PhotosRecyclerView;
    RecyclerViewClickListener listener;
    PhotosAdapter photosAdapter;
    ArrayList<photo> photos;
    String album_id;
    PhotoActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        presenter=new PhotoActivityPresenter(this);
        //intialize the ui
        initialization();
        // getting the list of the photos in an album
        fetchData();
        //implementing a clicklistener for the recyclerview
        listener=new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                //going to the full_size_photo_activity and sending to it the photo id
                goToFullSizePhotoActivity(position);
            }
        };
    }

    @Override
    public void initialization() {

        album_id=getIntent().getStringExtra("id");
        PhotosRecyclerView=findViewById(R.id.photos_recycler_view);
        //setting the layoutmanger for the recyclerview
        PhotosRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }


    //for checking the internet connection
    @Override
    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    // getting the list of the photos in an album
    @Override
    public void fetchData(){
        if(isOnline())
        {presenter.getThePhotos(album_id);}
        else{
            Toast.makeText(PhotosActivity.this, "check out your internet connection ", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void goToFullSizePhotoActivity(int position){

        Intent intent=new Intent(PhotosActivity.this,FullSizePhotoActivity.class);
        intent.putExtra("photo_id",photos.get(position).getId());
        startActivity(intent);

    }

    @Override
    public void setTheListOfPhotos(ArrayList<photo> photos) {
        //after we got the list of the photos we will set the adapter for our recyclerview
        this.photos=photos;
        photosAdapter = new PhotosAdapter(PhotosActivity.this, photos, listener);
        PhotosRecyclerView.setAdapter(photosAdapter);
    }
}
