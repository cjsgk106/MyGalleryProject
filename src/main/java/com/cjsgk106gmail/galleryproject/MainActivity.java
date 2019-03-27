package com.cjsgk106gmail.galleryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION = 0;
    private ArrayList createLists;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        createLists = loadImageData();
        adapter = new MainAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);

        loadImageData();
    }

    private ArrayList loadImageData() {
      String imageUrls[] = {
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/10405663_10203904385521132_820228118912221627_n.jpg?_nc_cat=104&_nc_ht=scontent-ort2-2.xx&oh=af43a468c804369b668b7af4efae7b47&oe=5D42D30A",
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/11150943_10203904384721112_4892772968144422916_n.jpg?_nc_cat=100&_nc_ht=scontent-ort2-2.xx&oh=8902d1224ce406a6fdb8988742e805e5&oe=5D0F48D1",
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/11193302_10203904383401079_8528438748619662452_n.jpg?_nc_cat=104&_nc_ht=scontent-ort2-2.xx&oh=28de8ad217a1948c6ff285fdf165dce4&oe=5D07F3D9",
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/11182215_10203904382161048_3326254620223015645_n.jpg?_nc_cat=110&_nc_ht=scontent-ort2-2.xx&oh=d1a9cd4ecf680de319f2c7f3067222c7&oe=5D42BB81",
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/11175002_10203904381961043_2007367002788254438_n.jpg?_nc_cat=100&_nc_ht=scontent-ort2-2.xx&oh=f93116b1b3384fd50ac80f73e5f55b3f&oe=5D48445B",
              "https://scontent-ort2-2.xx.fbcdn.net/v/t1.0-9/11188399_10203904381441030_7149906967224126429_n.jpg?_nc_cat=106&_nc_ht=scontent-ort2-2.xx&oh=045cc91f05462cfd7af717982b296965&oe=5D18A47A"
      };

      ArrayList imageUrlList = new ArrayList<>();
      for (int i = 0; i < imageUrls.length; i++) {
          CreateList imageUrl = new CreateList();
          imageUrl.setImage_url(imageUrls[i]);
          imageUrlList.add(imageUrl);
      }

      Log.d("MainActivity", "List count: " + imageUrlList.size());
      return imageUrlList;
    }

}
