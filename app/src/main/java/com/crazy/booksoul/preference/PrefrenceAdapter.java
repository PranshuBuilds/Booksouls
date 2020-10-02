package com.crazy.booksoul.preference;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.crazy.booksoul.R;

import java.util.ArrayList;

import static com.crazy.booksoul.preference.LanguageActivity.seekBar;
import static com.crazy.booksoul.preference.PreferenceFragment.str;


public class PrefrenceAdapter extends RecyclerView.Adapter<PrefrenceAdapter.ExampleViewHolder> {

    private ArrayList<prefrence> mExampleList;
    FragmentActivity activity;


    public PrefrenceAdapter(ArrayList<prefrence> exampleList, FragmentActivity activity) {
        this.mExampleList = exampleList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PrefrenceAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.prefrence_layout, parent, false);
        PrefrenceAdapter.ExampleViewHolder evh = new PrefrenceAdapter.ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final PrefrenceAdapter.ExampleViewHolder holder, int position) {
        final prefrence currentItem = mExampleList.get(position);

        Glide.with(holder.mImageView)
                .load(currentItem.getImage())
                .into(holder.mImageView);

        holder.mImageView.setVisibility(View.GONE);
        holder.mTextView1.setText(currentItem.getTag());

        StaggeredGridLayoutManager.LayoutParams lp =
                (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();

//        holder.relativeLayout.setBackgroundColor(currentItem.() ? Color.CYAN : Color.WHITE);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.bool = !holder.bool;
                if (holder.bool == true) {
                    holder.relativeLayout.setBackgroundResource(R.drawable.round_borders);
                    str = str+" " + currentItem.getTag();
                    seekBar.setProgress(3);
//                    Toast.makeText(activity, str.split("\\w+").length , Toast.LENGTH_SHORT).show();
                } else {
                    holder.relativeLayout.setBackgroundResource(R.color.grey);
                    str = str.replace(currentItem.getTag(), "");
//                    Toast.makeText(activity, str.split("\\w+").length , Toast.LENGTH_SHORT).show();

                }

            }
        });

        switch (lp.getSpanIndex()) {
            case 0:
                holder.relativeLayout.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                holder.relativeLayout.setBackgroundColor(Color.RED);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public static String removeWord(String string, String word) {


            String tempWord = word + " ";
            string = string.replaceAll(tempWord, "");

            // To cover the edge case
            // if the word is at the
            // end of the string
            tempWord = " " + word;
            string = string.replaceAll(tempWord, "");

        // Return the resultant string
        return string;

    }

    ///View holder
    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public RelativeLayout relativeLayout;
        public TextView mTextView1;
        Boolean bool;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.pref_layout);
            mImageView = itemView.findViewById(R.id.image);
            mTextView1 = itemView.findViewById(R.id.text);
            bool = false;

        }

//        @Override
//        public void onClick(View view) {
//            prefrence object = mExampleList.get(getAdapterPosition());
//            object.isSelected() ? object.setSelected(false) : object.setSelected(true);
//            notifyItemChanged(getAdapterPosition());
//        }
    }
}
