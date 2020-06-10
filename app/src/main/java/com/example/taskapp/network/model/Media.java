package com.example.taskapp.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Media {
    private final String type;

    private final String subtype;

    private final String caption;

    private final String copyright;

    private final int approvedForSyndication;

    @SerializedName("media-metadata")
    private final List<MediaMetadata> mediaMetadata;

    public Media(String type, String subtype, String caption, String copyright,
                 int approvedForSyndication, List<MediaMetadata> mediaMetadata) {
        this.type = type;
        this.subtype = subtype;
        this.caption = caption;
        this.copyright = copyright;
        this.approvedForSyndication = approvedForSyndication;
        this.mediaMetadata = mediaMetadata;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getCaption() {
        return caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getApprovedForSyndication() {
        return approvedForSyndication;
    }


    public List<MediaMetadata> getMediaMetadata() {
        return mediaMetadata;
    }

    public static class MediaMetadata {
        private final String url;

        private final String format;

        private final int height;

        private final int width;

        public MediaMetadata(String url, String format, int height, int width) {
            this.url = url;
            this.format = format;
            this.height = height;
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public String getFormat() {
            return format;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }
}