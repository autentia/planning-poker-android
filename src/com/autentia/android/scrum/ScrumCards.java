package com.autentia.android.scrum;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class ScrumCards extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	showDialog(position);
            }
        });
    }
    
    protected Dialog onCreateDialog(int id) {
    	final Dialog dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
    	dialog.setContentView(R.layout.custom_dialog);
    	dialog.setCancelable(true);

    	final ImageView image = (ImageView) dialog.findViewById(R.id.image);
    	image.setImageResource(ImageAdapter.image[id]);
        image.setAdjustViewBounds(true);
        image.setClickable(true);
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                dialog.cancel();
            }
        });

    	return dialog;
    }
}