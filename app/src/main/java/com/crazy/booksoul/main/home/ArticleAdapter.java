package com.crazy.booksoul.main.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.crazy.booksoul.PlayerActivity;
import com.crazy.booksoul.R;
import com.crazy.booksoul.ShowActivity;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.crazy.booksoul.main.home.article.ARTICLE;
import static com.crazy.booksoul.main.home.article.CATEGORY;
import static com.crazy.booksoul.main.home.article.CURATED;
import static com.crazy.booksoul.main.home.article.INTERESTING_ARTICLE;
import static com.crazy.booksoul.main.home.article.PODCAST;
import static com.crazy.booksoul.main.home.article.PUBLISHER;
import static com.crazy.booksoul.main.home.article.QUICKS;
import static com.crazy.booksoul.main.home.article.UPDATED;

public class ArticleAdapter extends RecyclerView.Adapter {

    // an array of selected items (Integer indices)

    private ArrayList<article> mExampleList;
    FragmentActivity activity;
    //declare interface
    private OnItemClicked onClick;

    //make interface for click pop
    public interface OnItemClicked {
        void onItemClick(int position);
    }

    public ArticleAdapter(ArrayList<article> exampleList, OnItemClicked OnClick, FragmentActivity activity) {
        this.mExampleList = exampleList;
        this.activity = activity;
        this.onClick = OnClick;
    }

    @Override
    public int getItemViewType(int position) {
        switch (mExampleList.get(position).getViewtype()) {
            case 0:
                return ARTICLE;
            case 1:
                return INTERESTING_ARTICLE;
            case 2:
                return PODCAST;
            case 3:
                return QUICKS;
            case 4:
                return PUBLISHER;
            case 5:
                return CURATED;
            case 6:
                return UPDATED;
            case 7:
                return CATEGORY;
            default:
                return -1;

        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
                return new ArticleLayout(v);
            case 1:
                View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.interesting_article_layout, parent, false);
                return new InterestingArticleLayout(vi);
            case 2:
                View vp = LayoutInflater.from(parent.getContext()).inflate(R.layout.podcast_layout, parent, false);
                return new Podcastlayout(vp);
            case 3:
                View vq = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_layout, parent, false);
                return new QuickLayout(vq);
            case 4:
                View vpp = LayoutInflater.from(parent.getContext()).inflate(R.layout.publisher_layout, parent, false);
                return new PublisherLayout(vpp);
            case 5:
                View vcu = LayoutInflater.from(parent.getContext()).inflate(R.layout.listen_curated, parent, false);
                return new CuratedLayout(vcu);
            case 6:
                View vup = LayoutInflater.from(parent.getContext()).inflate(R.layout.listen_updated, parent, false);
                return new UpdatedLayout(vup);
            case 7:
                View vct = LayoutInflater.from(parent.getContext()).inflate(R.layout.listen_catagories, parent, false);
                return new CategoryLayout(vct);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch (mExampleList.get(position).getViewtype()) {
            case ARTICLE:
                final article currentItem = mExampleList.get(position);
                final ArticleLayout articleholder = (ArticleLayout) holder;
                Glide.with(articleholder.mImageView)
                        .load(currentItem.getImageUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(articleholder.mImageView);
                articleholder.mTextView1.setText(currentItem.getTitle());
                articleholder.topic.setText(currentItem.getTopic());
                if (currentItem.getProgressBar() != 0)
                    articleholder.progressBar.setProgress(currentItem.getProgressBar());
                else
                    articleholder.progressBar.setVisibility(View.INVISIBLE);
                articleholder.time.setText(currentItem.getDiscription() + " min read");
                articleholder.fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        articleholder.bool = !articleholder.bool;
                        //creating a popup menu
                        PopupMenu popup = new PopupMenu(activity, articleholder.fav);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:
                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();

                                        onClick.onItemClick(position);

//                                        Bundle bundle = new Bundle();
//                                        bundle.putarticleArrayList("arrayOfName", selected);
//                                        bundle.putStringArray("arrayOfImageUrls", new String[]{url1, url2});
//                                        Intent intent = new Intent(activity, WishlistFragment.class);
//                                        intent.putExtras(bundle);

                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                        sharingIntent.setType("text/plain");
                                        String shareBody = "Hey checkout this awesome article from BOOKSOULs original " + currentItem.getTopic();
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, currentItem.getTitle());
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, currentItem.getTitle() + "\n\n" + shareBody);
                                        activity.startActivity(Intent.createChooser(sharingIntent, currentItem.getTitle()));
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                        String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        Log.e("time", currentDateandTime);


                    }
                });
                articleholder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final int time = currentItem.getDiscription();
                        Intent i = new Intent(activity, ShowActivity.class);
                        i.putExtra("time", time);
                        i.putExtra("pos", position);
                        i.putExtra("url", currentItem.getImageUrl());
                        i.putExtra("topic", currentItem.getTopic());
                        i.putExtra("title", currentItem.getTitle());
                        i.putExtra("time", currentItem.getDiscription());

                        i.putExtra("type", mExampleList.get(position).getViewtype());
                        activity.startActivity(i);
                    }

                });


                break;
            case INTERESTING_ARTICLE:

                final article currentItem1 = mExampleList.get(position);
                final InterestingArticleLayout intarticleholder = (InterestingArticleLayout) holder;
                Glide.with(intarticleholder.mImageView)
                        .load(currentItem1.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(intarticleholder.mImageView);
                //seting palette color with glide
                Glide.with(activity).asBitmap()
                        .load(currentItem1.getInterstingUrl())
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                                // Extract color
                                Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(@Nullable Palette p) {

                                        int mutedLight3 = p.getMutedColor(activity.getResources().getColor(android.R.color.darker_gray));
                                        int mutedLight4 = p.getLightVibrantColor(activity.getResources().getColor(android.R.color.darker_gray));
                                        int mutedLight5 = p.getVibrantColor(activity.getResources().getColor(android.R.color.darker_gray));
                                        int mutedLight6 = p.getDarkVibrantColor(activity.getResources().getColor(android.R.color.darker_gray));

                                        intarticleholder.relativeLayout.setBackgroundColor(mutedLight3);

                                    }
                                });
                            }
                        });

////                color random
//
                if (currentItem1.getProgress() != 0)
                    intarticleholder.circularProgressBar.setProgress(currentItem1.getProgress());
                else
                    intarticleholder.circularProgressBar.setVisibility(View.INVISIBLE);
                intarticleholder.topic.setText(currentItem1.getInterestingTopic());
                intarticleholder.discrption.setText(currentItem1.getIntretingDiscription());
                intarticleholder.fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //creating a popup menu
                        PopupMenu popup = new PopupMenu(activity, intarticleholder.fav);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:
                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();

                                        onClick.onItemClick(position);
//                Toast.makeText(activity, Integer.toString(nonDuplicateString.split("\\w+").length) , Toast.LENGTH_SHORT).show();

//                                        Bundle bundle = new Bundle();
//                                        bundle.putarticleArrayList("arrayOfName", selected);
//                                        bundle.putStringArray("arrayOfImageUrls", new String[]{url1, url2});
//                                        Intent intent = new Intent(activity, WishlistFragment.class);
//                                        intent.putExtras(bundle);

                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                        sharingIntent.setType("text/plain");
                                        String shareBody = "Hey checkout this awesome article from BOOKSOULs original " + currentItem1.getTopic();
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, currentItem1.getTitle());
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, currentItem1.getTitle() + "\n\n" + shareBody);
                                        activity.startActivity(Intent.createChooser(sharingIntent, currentItem1.getTitle()));
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                        String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        Log.e("time", currentDateandTime);


                    }
                });
                intarticleholder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(activity, ShowActivity.class);
                        i.putExtra("pos", position);
                        i.putExtra("url", currentItem1.getInterstingUrl());
                        i.putExtra("topic", "Inspire Me");
                        i.putExtra("title", currentItem1.getInterestingTopic());
                        i.putExtra("time", 0);

                        i.putExtra("type", mExampleList.get(position).getViewtype());
                        activity.startActivity(i);
                    }
                });
                break;
            case PODCAST:
                final article currentItem2 = mExampleList.get(position);
                final Podcastlayout podholder = (Podcastlayout) holder;
                Glide.with(podholder.mImageView)
                        .load(currentItem2.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(podholder.mImageView);

                if (currentItem2.getProgress() != 0)
                    podholder.circularProgressBar.setProgress(currentItem2.getProgress());
                else
                    podholder.circularProgressBar.setVisibility(View.INVISIBLE);
                podholder.topic.setText(currentItem2.getInterestingTopic());
                podholder.discrption.setText(currentItem2.getIntretingDiscription());
                podholder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(activity, PlayerActivity.class);
                        i.putExtra("pos", position);
                        i.putExtra("url", currentItem2.getInterstingUrl());
                        i.putExtra("topic", currentItem2.getInterestingTopic());
                        i.putExtra("disc", currentItem2.getIntretingDiscription());
                        i.putExtra("time", currentItem2.getProgress());
                        i.putExtra("type", mExampleList.get(position).getViewtype());
                        activity.startActivity(i);
                    }
                });
                podholder.fav_podcast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //creating a popup menu
                        PopupMenu popup = new PopupMenu(activity, podholder.fav_podcast);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:
                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();

                                        onClick.onItemClick(position);
                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                                        sharingIntent.setType("text/plain");
                                        String shareBody = "Hey checkout this awesome article from BOOKSOULs original " + currentItem2.getTopic();
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, currentItem2.getTitle());
                                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, currentItem2.getTitle() + "\n\n" + shareBody);
                                        activity.startActivity(Intent.createChooser(sharingIntent, currentItem2.getTitle()));
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                        String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                        Log.e("time", currentDateandTime);


                    }
                });
                break;
            case QUICKS:
                final article currentItem3 = mExampleList.get(position);
                final QuickLayout quickholder = (QuickLayout) holder;
                Glide.with(quickholder.mImageView)
                        .load(currentItem3.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(quickholder.mImageView);

                quickholder.topic.setText(currentItem3.getInterestingTopic());
                quickholder.discrption.setText(currentItem3.getIntretingDiscription());
                quickholder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(activity, ShowActivity.class);
                        i.putExtra("pos", position);
                        i.putExtra("url", currentItem3.getInterstingUrl());
                        i.putExtra("topic", "Quick");
                        i.putExtra("title", currentItem3.getInterestingTopic());
                        i.putExtra("time", 0);

                        i.putExtra("type", mExampleList.get(position).getViewtype());
                        activity.startActivity(i);
                    }
                });
                quickholder.pop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popup = new PopupMenu(activity, quickholder.pop);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:

                                        onClick.onItemClick(position);

                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                    }
                });
                quickholder.circularProgressBar.setProgress(currentItem3.getProgress());

                break;
            case PUBLISHER:

                final article currentItem5 = mExampleList.get(position);
                final PublisherLayout publisherholder = (PublisherLayout) holder;
                Glide.with(publisherholder.mImageView)
                        .load(currentItem5.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(publisherholder.mImageView);

                publisherholder.topic.setText(currentItem5.getInterestingTopic());
                publisherholder.discrption.setText(currentItem5.getIntretingDiscription());
                if (currentItem5.getProgress() != 0)
                    publisherholder.circularProgressBar.setProgress(currentItem5.getProgress());
                else
                    publisherholder.circularProgressBar.setVisibility(View.INVISIBLE);


//
                publisherholder.fav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popup = new PopupMenu(activity, publisherholder.fav);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:

                                        onClick.onItemClick(position);

                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                    }
                });
                publisherholder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(activity, ShowActivity.class);
                        i.putExtra("pos", position);
                        i.putExtra("url", "n");
                        i.putExtra("topic", "Publisher");
                        i.putExtra("title", currentItem5.getInterestingTopic());
                        i.putExtra("time", 0);

                        i.putExtra("type", mExampleList.get(position).getViewtype());
                        activity.startActivity(i);
                    }
                });
                break;
            case CURATED:
                article currentItem6 = mExampleList.get(position);
                final CuratedLayout curatedholder = (CuratedLayout) holder;
                Glide.with(curatedholder.mImageView)
                        .load(currentItem6.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(curatedholder.mImageView);

                curatedholder.topic.setText(currentItem6.getInterestingTopic());
                curatedholder.discrption.setText(currentItem6.getIntretingDiscription());

                curatedholder.pop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popup = new PopupMenu(activity, curatedholder.pop);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:

                                        onClick.onItemClick(position);

                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                    }
                });
//                curatedholder.circularProgressBar.setProgress(currentItem3.getProgress());

                break;
            case UPDATED:
                article currentItem7 = mExampleList.get(position);
                final UpdatedLayout updateholder = (UpdatedLayout) holder;
                Glide.with(updateholder.mImageView)
                        .load(currentItem7.getInterstingUrl())
                        .apply(new RequestOptions()
                                .placeholder(R.drawable.replacer)
                        )
                        .into(updateholder.mImageView);

                updateholder.topic.setText(currentItem7.getInterestingTopic());
                updateholder.discrption.setText(currentItem7.getIntretingDiscription());

                updateholder.pop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PopupMenu popup = new PopupMenu(activity, updateholder.pop);
                        //inflating menu from xml resource
                        popup.inflate(R.menu.article_menu);
                        //adding click listener
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.save_article:

                                        onClick.onItemClick(position);

                                        Toast.makeText(activity, String.format("save%d", position), Toast.LENGTH_SHORT).show();
                                        return true;
                                    case R.id.share_article:
                                        //handle menu2 click
                                        Toast.makeText(activity, "share", Toast.LENGTH_SHORT).show();

                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        //displaying the popup
                        popup.show();
                    }
                });
//                curatedholder.circularProgressBar.setProgress(currentItem3.getProgress());

                break;
            case CATEGORY:
                article currentItem8 = mExampleList.get(position);
                final CategoryLayout categoryholder = (CategoryLayout) holder;

                categoryholder.text.setText(currentItem8.getString());

                break;
            default:
                return;

        }
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    ///View holder Article
    public static class ArticleLayout extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mImageView;
        public RelativeLayout relativeLayout;
        public TextView mTextView1, topic, time, fav;
        public CircularProgressBar progressBar;
        Boolean bool = false;


        public ArticleLayout(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relativeAA);

            fav = itemView.findViewById(R.id.fav_article);
            mImageView = itemView.findViewById(R.id.article_image);
            mTextView1 = itemView.findViewById(R.id.article_discription);
            topic = itemView.findViewById(R.id.article_Topic);
            time = itemView.findViewById(R.id.article_readtime);
            progressBar = itemView.findViewById(R.id.progress);

        }

        @Override
        public void onClick(View view) {

        }
//
    }

    ///View holder INsPIRE ME
    public static class InterestingArticleLayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, fav;
        public RelativeLayout relativeLayout;
        CircularProgressBar circularProgressBar;
        Boolean bool = false;


        public InterestingArticleLayout(View itemView) {
            super(itemView);
            fav = itemView.findViewById(R.id.fav_intr);
            relativeLayout = itemView.findViewById(R.id.relative);
            mImageView = itemView.findViewById(R.id.Iarticle_image);
            topic = itemView.findViewById(R.id.Iarticle_Topic);
            discrption = itemView.findViewById(R.id.Iarticle_discription);
            circularProgressBar = itemView.findViewById(R.id.intprogress);

        }
//
    }

    ///View holder Podcast
    public static class Podcastlayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, fav_podcast;
        public RelativeLayout relativeLayout;
        CircularProgressBar circularProgressBar;

        Boolean bool = false;


        public Podcastlayout(View itemView) {
            super(itemView);
            fav_podcast = itemView.findViewById(R.id.fav_pod);
            mImageView = itemView.findViewById(R.id.podcast_image);
            topic = itemView.findViewById(R.id.podcast_title);
            discrption = itemView.findViewById(R.id.podcast_discription);
            circularProgressBar = itemView.findViewById(R.id.progresspod);
            relativeLayout = itemView.findViewById(R.id.relativePod);

        }
//
    }

    ///View holder Quicks
    public static class QuickLayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, pop;
        CircularProgressBar circularProgressBar;
        RelativeLayout relativeLayout;
        Boolean bool = false;


        public QuickLayout(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.bookimage);
            topic = itemView.findViewById(R.id.qbookname);
            pop = itemView.findViewById(R.id.fav_book);
            relativeLayout = itemView.findViewById(R.id.relativeQ);
            discrption = itemView.findViewById(R.id.qwriter);
            circularProgressBar = itemView.findViewById(R.id.qprogress);


        }
//
    }

    ///View holder Publisher
    public static class PublisherLayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, fav;
        public RelativeLayout relativeLayout;
        CircularProgressBar circularProgressBar;
        Boolean bool = false;


        public PublisherLayout(View itemView) {
            super(itemView);
            fav = itemView.findViewById(R.id.fav_pub);
            relativeLayout = itemView.findViewById(R.id.pubrelative);
            mImageView = itemView.findViewById(R.id.pub_image);
            topic = itemView.findViewById(R.id.pub_Topic);
            discrption = itemView.findViewById(R.id.pub_discription);
            circularProgressBar = itemView.findViewById(R.id.pub_progress);

        }
//
    }

    ///View holder Listen tab curated view
    public static class CuratedLayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, pop;
        CircularProgressBar circularProgressBar;


        Boolean bool = false;


        public CuratedLayout(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.curatedImage);
            topic = itemView.findViewById(R.id.curatedTitle);
            pop = itemView.findViewById(R.id.fav_curated);

            discrption = itemView.findViewById(R.id.curatedDisc);
//            circularProgressBar = itemView.findViewById(R.id.qprogress);


        }
//
    }

    ///View holder Listen tab Updated view
    public static class UpdatedLayout extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView topic, discrption, pop;
        CircularProgressBar circularProgressBar;


        Boolean bool = false;


        public UpdatedLayout(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.updatedImage);
            topic = itemView.findViewById(R.id.updatedTitle);
            pop = itemView.findViewById(R.id.fav_updated);

            discrption = itemView.findViewById(R.id.updatedDisc);
//            circularProgressBar = itemView.findViewById(R.id.qprogress);


        }
//
    }

    ///View holder Listen tab Catogories view
    public static class CategoryLayout extends RecyclerView.ViewHolder {
        public TextView text;

        Boolean bool = false;


        public CategoryLayout(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.catagorytext);
//            circularProgressBar = itemView.findViewById(R.id.qprogress);


        }
//
    }

    //    interface
    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

}
