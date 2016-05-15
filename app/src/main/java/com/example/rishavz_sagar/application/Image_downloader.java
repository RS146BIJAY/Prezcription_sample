package com.example.rishavz_sagar.application;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class Image_downloader extends Fragment {


    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_image_downloader, container, false);
        context=getActivity();
        final ImageView iv[]=new ImageView[5];
        iv[0]= (ImageView) v.findViewById(R.id.imgResult);
        iv[1]= (ImageView) v.findViewById(R.id.imgResult1);
        iv[2]= (ImageView) v.findViewById(R.id.imgResult2);
        iv[3]= (ImageView) v.findViewById(R.id.imgResult3);
        iv[4]= (ImageView) v.findViewById(R.id.imgResult4);



        int i=0;
        for(i=0;i<5;i++)
        {
            iv[i].setImageResource(R.drawable.initail_image);
            iv[i].setTag(R.drawable.initail_image);
        }

        final ProgressBar progressBar[]=new ProgressBar[5];

        progressBar[0]=(ProgressBar) v.findViewById(R.id.pbImageLoading);
        progressBar[1]=(ProgressBar) v.findViewById(R.id.pbImageLoading1);
        progressBar[2]=(ProgressBar) v.findViewById(R.id.pbImageLoading2);
        progressBar[3]=(ProgressBar) v.findViewById(R.id.pbImageLoading3);
        progressBar[4]=(ProgressBar) v.findViewById(R.id.pbImageLoading4);

        final Image_Loader loader=new Image_Loader(context);

        Button bt[]=new Button[5];
        bt[0]= (Button) v.findViewById(R.id.bt1);
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.DisplayImage("http://wallpapercave.com/wp/lrGr9I9.jpg",iv[0],progressBar[0]);
                progressBar[0].setVisibility(View.VISIBLE);
            }
        });
        bt[1]= (Button) v.findViewById(R.id.bt2);
        bt[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.DisplayImage("http://img3.themebin.com/1920x1080/d_to_c_hd.jpg",iv[1],progressBar[1]);
                progressBar[1].setVisibility(View.VISIBLE);
            }
        });
        bt[2]= (Button) v.findViewById(R.id.bt3);
        bt[2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loader.DisplayImage("https://wallpaperscraft.com/image/stars_sky_shore_84534_1920x1080.jpg",iv[2],progressBar[2]);
                        progressBar[2].setVisibility(View.VISIBLE);
                    }
                }
        );

        bt[3]= (Button) v.findViewById(R.id.bt4);
        bt[3].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loader.DisplayImage("http://img3.themebin.com/1920x1080/spring_rain_wallpaper.jpg",iv[3],progressBar[3]);
                        progressBar[3].setVisibility(View.VISIBLE);
                    }
                }
        );
        bt[4]= (Button) v.findViewById(R.id.bt5);
        bt[4].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loader.DisplayImage("https://interfacelift.com/wallpaper/7yz4ma1/01819_birdonabranch_1920x1080.jpg",iv[4],progressBar[4]);
                        progressBar[4].setVisibility(View.VISIBLE);
                    }
                }
        );
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context=getActivity();
    }
}
