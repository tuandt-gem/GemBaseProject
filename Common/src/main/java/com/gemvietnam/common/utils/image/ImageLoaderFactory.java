package com.gemvietnam.common.utils.image;

import javax.microedition.khronos.opengles.GL;

/**
 * Image Loader Factory
 * Created by neo on 7/18/2016.
 */
public class ImageLoaderFactory {
    public static final Type DEFAULT = Type.GLIDE;

    public static ImageLoader getInstance() {
        return getInstance(DEFAULT);
    }

    public static ImageLoader getInstance(Type type) {
        switch (type) {
            case GLIDE:
                return new ImageLoaderGlide();
            default:
                return new ImageLoaderGlide();
        }
    }

    public enum Type {
        GLIDE
    }
}
