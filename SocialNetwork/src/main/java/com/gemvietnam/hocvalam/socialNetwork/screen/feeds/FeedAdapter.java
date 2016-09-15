package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Feed;
import com.gemvietnam.utils.DateTimeUtils;
import com.gemvietnam.utils.image.ImageUtils;
import com.gemvietnam.view.BaseViewHolder;
import com.gemvietnam.view.ExpandableTextView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;

/**
 * Feeds adapter for feeds list
 * Created by neo on 7/20/2016.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private Context mContext;
    private List<Feed> mFeeds;

    public FeedAdapter(Context context, List<Feed> feeds) {
        mContext = context;
        mFeeds = feeds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_feed, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feed feed = getItem(position);

        // Set author
        holder.mNameTv.setText(feed.getName());

        // Load avatar
        ImageUtils.loadImage(mContext, feed.getAvatar(), holder.mAvatar);

        // Set published Date
        holder.mDateTv.setText(DateTimeUtils.formatDate(mContext, feed.getDate()));

        // Set content
        holder.mContentTv.setText(feed.getContent());

        // Set post images
        bindImages(holder, feed);

        // Set Like count
        holder.mLikeCountTv.setText(String.valueOf(feed.getLikeCount()));

        // Set Comment count
        holder.mCommentCountTv.setText(String.valueOf(feed.getCommentCount()));

        // Set Share count
        holder.mShareCountTv.setText(String.valueOf(feed.getShareCount()));

        // Set activities summary
        holder.mActivitySummaryTv.setText(String.format(mContext.getString(R.string.activity_summary_format),
                feed.getActivityCount()));
    }

    /**
     * Bind post images
     */
    private void bindImages(ViewHolder holder, Feed feed) {
        List<String> images = feed.getImages();
        if (images == null || images.size() == 0) {
            holder.mPostImageContainer.setVisibility(View.GONE);
        } else {
            holder.mPostImageContainer.setVisibility(View.VISIBLE);
            int size = images.size();

            switch (size) {
                case 1:
                    ImageUtils.loadImage(mContext, images.get(0), holder.mPostImage1);
                    holder.mPostImage1.setVisibility(View.VISIBLE);
                    holder.mPostImage2.setVisibility(View.GONE);
                    holder.mPostImage3.setVisibility(View.GONE);
                    holder.mMoreImageTv.setVisibility(View.GONE);
                    break;
                case 2:
                    ImageUtils.loadImage(mContext, images.get(0), holder.mPostImage1);
                    ImageUtils.loadImage(mContext, images.get(1), holder.mPostImage2);
                    holder.mPostImage1.setVisibility(View.VISIBLE);
                    holder.mPostImage2.setVisibility(View.VISIBLE);
                    holder.mPostImage3.setVisibility(View.GONE);
                    holder.mMoreImageTv.setVisibility(View.GONE);
                    break;
                case 3:
                    ImageUtils.loadImage(mContext, images.get(0), holder.mPostImage1);
                    ImageUtils.loadImage(mContext, images.get(1), holder.mPostImage2);
                    ImageUtils.loadImage(mContext, images.get(2), holder.mPostImage3);
                    holder.mPostImage1.setVisibility(View.VISIBLE);
                    holder.mPostImage2.setVisibility(View.VISIBLE);
                    holder.mPostImage3.setVisibility(View.VISIBLE);
                    holder.mMoreImageTv.setVisibility(View.GONE);
                    break;
                default:
                    ImageUtils.loadImage(mContext, images.get(0), holder.mPostImage1);
                    ImageUtils.loadImage(mContext, images.get(1), holder.mPostImage2);
                    ImageUtils.loadImage(mContext, images.get(2), holder.mPostImage3);
                    holder.mMoreImageTv.setText(String.format(mContext.getString(R.string.more_image_format), size -3));
                    holder.mPostImage1.setVisibility(View.VISIBLE);
                    holder.mPostImage2.setVisibility(View.VISIBLE);
                    holder.mPostImage3.setVisibility(View.VISIBLE);
                    holder.mMoreImageTv.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mFeeds.size();
    }

    public Feed getItem(int position) {
        return mFeeds.get(position);
    }

    public class ViewHolder extends BaseViewHolder {
        @Bind(R.id.item_feed_name_tv)
        TextView mNameTv;
        @Bind(R.id.item_feed_date_tv)
        TextView mDateTv;
        @Bind(R.id.item_feed_content_tv)
        ExpandableTextView mContentTv;
        @Bind(R.id.post_image_1)
        ImageView mPostImage1;
        @Bind(R.id.post_image_2)
        ImageView mPostImage2;
        @Bind(R.id.post_image_3)
        ImageView mPostImage3;
        @Bind(R.id.post_more_image_tv)
        TextView mMoreImageTv;
        @Bind(R.id.post_like_count_tv)
        TextView mLikeCountTv;
        @Bind(R.id.post_comment_count_tv)
        TextView mCommentCountTv;
        @Bind(R.id.post_share_count_tv)
        TextView mShareCountTv;
        @Bind(R.id.post_activity_summary_tv)
        TextView mActivitySummaryTv;
        @Bind(R.id.post_images_container_ll)
        View mPostImageContainer;
        @Bind(R.id.item_feed_avatar_iv)
        public ImageView mAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
