package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.adapter.RecyclerBaseAdapter;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;
import com.gemvietnam.hocvalam.socialNetwork.util.DateTimeUtils;
import com.gemvietnam.hocvalam.socialNetwork.widget.ExpandableTextView;
import com.gemvietnam.utils.image.ImageUtils;
import com.gemvietnam.widget.BaseViewHolder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;

/**
 * Feeds adapter for feeds list
 * Created by neo on 7/20/2016.
 */
class FeedAdapter extends RecyclerBaseAdapter<Feed, FeedAdapter.ViewHolder> {
  private OnItemAction mOnItemAction;

  FeedAdapter(Context context, List<Feed> feeds) {
    super(context, feeds);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(inflateView(parent, R.layout.item_feed));
  }

  public FeedAdapter setOnItemAction(OnItemAction onItemAction) {
    mOnItemAction = onItemAction;
    return this;
  }


  class ViewHolder extends BaseViewHolder<Feed> {
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
    ImageView mAvatar;
    @Bind(R.id.feed_activities_ll)
    LinearLayout mFeedActivitiesLl;

    ViewHolder(View itemView) {
      super(itemView);
    }

    @Override
    public void bindView(final Feed feed, final int position) {
      // Set author
      mNameTv.setText(feed.getName());

      // Load avatar
      ImageUtils.loadImage(mContext, feed.getAvatar(), mAvatar);

      // Set published Date
      mDateTv.setText(DateTimeUtils.formatDate(mContext, feed.getDate()));

      // Set content
      mContentTv.setText(feed.getContent());

      // Set post images
      bindImages(feed);

      // Set Like count
      mLikeCountTv.setText(String.valueOf(feed.getLikeCount()));

      // Set Comment count
      mCommentCountTv.setText(String.valueOf(feed.getCommentCount()));

      // Set Share count
      mShareCountTv.setText(String.valueOf(feed.getShareCount()));

      // Set activities summary
      mActivitySummaryTv.setText(
          String.format(mContext.getString(R.string.activity_summary_format),
              feed.getActivityCount()));

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (mOnItemAction != null) {
            mOnItemAction.onItemClicked(feed);
          }
        }
      });

      // Activities clicked
      mFeedActivitiesLl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (mOnItemAction != null) {
            mOnItemAction.onActivitiesLayoutClicked(feed);
          }
        }
      });
    }

    /**
     * Bind post images
     */
    private void bindImages(Feed feed) {
      List<String> images = feed.getImages();
      if (images == null || images.size() == 0) {
        mPostImageContainer.setVisibility(View.GONE);
      } else {
        mPostImageContainer.setVisibility(View.VISIBLE);
        int size = images.size();

        switch (size) {
          case 1:
            ImageUtils.loadImage(mContext, images.get(0), mPostImage1);
            mPostImage1.setVisibility(View.VISIBLE);
            mPostImage2.setVisibility(View.GONE);
            mPostImage3.setVisibility(View.GONE);
            mMoreImageTv.setVisibility(View.GONE);
            break;
          case 2:
            ImageUtils.loadImage(mContext, images.get(0), mPostImage1);
            ImageUtils.loadImage(mContext, images.get(1), mPostImage2);
            mPostImage1.setVisibility(View.VISIBLE);
            mPostImage2.setVisibility(View.VISIBLE);
            mPostImage3.setVisibility(View.GONE);
            mMoreImageTv.setVisibility(View.GONE);
            break;
          case 3:
            ImageUtils.loadImage(mContext, images.get(0), mPostImage1);
            ImageUtils.loadImage(mContext, images.get(1), mPostImage2);
            ImageUtils.loadImage(mContext, images.get(2), mPostImage3);
            mPostImage1.setVisibility(View.VISIBLE);
            mPostImage2.setVisibility(View.VISIBLE);
            mPostImage3.setVisibility(View.VISIBLE);
            mMoreImageTv.setVisibility(View.GONE);
            break;
          default:
            ImageUtils.loadImage(mContext, images.get(0), mPostImage1);
            ImageUtils.loadImage(mContext, images.get(1), mPostImage2);
            ImageUtils.loadImage(mContext, images.get(2), mPostImage3);
            mMoreImageTv.setText(
                String.format(mContext.getString(R.string.more_image_format),
                    size - 3));
            mPostImage1.setVisibility(View.VISIBLE);
            mPostImage2.setVisibility(View.VISIBLE);
            mPostImage3.setVisibility(View.VISIBLE);
            mMoreImageTv.setVisibility(View.VISIBLE);
            break;
        }
      }
    }
  }

  /**
   * Actions in item
   */
  public interface OnItemAction {
    void onItemClicked(Feed feed);

    void onActivitiesLayoutClicked(Feed feed);
  }
}
