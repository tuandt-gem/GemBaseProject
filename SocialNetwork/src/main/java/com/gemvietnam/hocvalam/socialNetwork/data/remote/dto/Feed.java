package com.gemvietnam.hocvalam.socialNetwork.data.remote.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Feed
 * Created by neo on 7/19/2016.
 */
public class Feed {
    private String mName;
    private String mAvatar;
    private String mContent;
    private long mDate;
    private List<String> mImages;
    private int mLikeCount;
    private int mCommentCount;
    private int mShareCount;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public long getDate() {
        return mDate;
    }

    public void setDate(long date) {
        mDate = date;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void setImages(List<String> images) {
        mImages = images;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(int likeCount) {
        mLikeCount = likeCount;
    }

    public int getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(int commentCount) {
        mCommentCount = commentCount;
    }

    public int getShareCount() {
        return mShareCount;
    }

    public void setShareCount(int shareCount) {
        mShareCount = shareCount;
    }

    public int getActivityCount() {
        return mLikeCount + mShareCount + mCommentCount;
    }

    private static int sCount = 0;
    public static Feed getInstance() {
        sCount++;
        Feed feed = new Feed();
        feed.setName("Lên là lên là lên ú ù");
        feed.setAvatar("http://4.bp.blogspot.com/-TrkY3RlqQJY/T3caSIG28SI/AAAAAAAAcBA/DWkJZ78Mc2w/s400/avatar%2Bshock%2B%252844%2529.jpg");
        feed.setDate(System.currentTimeMillis());
        feed.setContent("The people that call themselves \"responsible adults\" are not the people that I want to look up to. Neither are (most of) those fools from occupy wall street or something else");
        List<String> images = new ArrayList<>();

        long diff = sCount % 4;
        if (diff == 0) {
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
        } else if (diff == 1) {
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
        } else if (diff == 2) {
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
            images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
        } else {

            for (int i = 0; i < 10; i++) {
                images.add("http://www.healthbysuzi.com/wp-content/uploads/2015/08/read-books-480x318.jpg");
            }
        }

        feed.setImages(images);

        feed.setLikeCount(3);
        feed.setCommentCount(6);
        feed.setShareCount(9);

        return feed;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }
}
