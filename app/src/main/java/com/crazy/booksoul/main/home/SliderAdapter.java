package com.crazy.booksoul.main.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.crazy.booksoul.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<SliderItem> mSliderItems = new ArrayList<>();

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<SliderItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(final SliderAdapterVH viewHolder, final int position) {

        SliderItem sliderItem = mSliderItems.get(position);


        viewHolder.textViewDescription.setText(sliderItem.getImageDiscrption());
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                .into(viewHolder.imageViewBackground);
        //seting palette color with glide
        Glide.with(context).asBitmap()
                .load(sliderItem.getImageUrl())
                .into(new SimpleTarget<Bitmap>(){
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                        // Extract color
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(@Nullable Palette p) {

                                int mutedLight3 = p.getLightVibrantColor(context.getResources().getColor(android.R.color.darker_gray));
                                int mutedLight4 = p.getLightMutedColor(context.getResources().getColor(android.R.color.darker_gray));
                                int mutedLight5 = p.getVibrantColor(context.getResources().getColor(android.R.color.darker_gray));
                                int mutedLight6 = p.getDarkVibrantColor(context.getResources().getColor(android.R.color.darker_gray));

                                viewHolder.textViewDescription.setTextColor(Color.WHITE);
//                                intarticleholder.relativeLayout.setBackgroundColor(mutedLight3);
//                                activity.findViewById(R.id.relative).setBackgroundColor(mutedLight5);

                            }
                        });
                    }
                });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
                Toast toast = Toast.makeText(context, "This is item in position " + (position+1), Toast.LENGTH_SHORT);
                View view = toast.getView();

//Gets the actual oval background of the Toast then sets the colour filter
                view.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);

//Gets the TextView from the Toast so it can be editted
                TextView text = view.findViewById(android.R.id.message);
                text.setTextColor(Color.YELLOW);

                toast.show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {


        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription,content;

        public SliderAdapterVH(View itemView) {
            super(itemView);

            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}