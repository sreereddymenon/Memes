package com.tincio.memes.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tincio.memes.R;
import com.tincio.memes.presentation.adapter.AdapterRecycler;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rec_memes)
    RecyclerView myRecycler;
    RecyclerView.LayoutManager mManager;
    AdapterRecycler mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //
        mManager = new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL, false);
        myRecycler.setLayoutManager(mManager);
        String[] array = getResources().getStringArray(R.array.array_elements_recycler);
        mAdapter = new AdapterRecycler(array, this);
        myRecycler.setAdapter(mAdapter);
    }

}
