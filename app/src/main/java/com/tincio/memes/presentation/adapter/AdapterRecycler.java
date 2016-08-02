package com.tincio.memes.presentation.adapter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tincio.memes.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by tincio on 22/07/2016.
 */
public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderItem> {

    String[] arrayString;

    Context context ;

    public AdapterRecycler(String[] arrayString, Context context){
        this.arrayString = arrayString;
        this.context = context;
    }
    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
      //  context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        ViewHolderItem viewHolder = new ViewHolderItem(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        loadImage(holder.imageView);
//        holder.txtItemRecycler.setText(arrayString[position]);
    }

    @Override
    public int getItemCount() {
        return arrayString.length;
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {
        @Bind(R.id.image_meme)
        ImageView imageView;

        TextView txtItemRecycler;
        public ViewHolderItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //txtItemRecycler = (TextView)itemView.findViewById(R.id.txt_item_recycler);
        }
    }

    private void loadImage(ImageView imageView) {
        // Index 1 is the progress bar. Show it while we're loading the image.
        //animator.setDisplayedChild(1);

        Picasso.with(context).load("https://graph.facebook.com/100001681658946/picture?type=large").fit().centerInside().into(imageView, new Callback.EmptyCallback() {
            @Override public void onSuccess() {
                Log.i("ingreso","ingreso");
                // Index 0 is the image view.
            //    animator.setDisplayedChild(0);
            }
        });
    }
}
