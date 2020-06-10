package com.example.taskapp.network.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    private final String uri;

    private final String url;

    private final long id;

    private final long assetId;

    private final String source;

    private final String publishedDate;

    private final String updated;

    private final String section;

    private final String subsection;

    private final String nytdsection;

    private final String adxKeywords;

    private final Object column;

    private final String byline;

    private final String type;

    private final String title;

    @SerializedName("abstract")
    private final String anAbstract;

    private final List<String> desFacet;

    private final List<Object> orgFacet;

    private final List<Object> perFacet;

    private final List<Object> geoFacet;

    private final List<Media> media;

    private final int etaId;

    public Results(String uri, String url, long id, long assetId, String source,
                   String publishedDate, String updated, String section, String subsection,
                   String nytdsection, String adxKeywords, Object column, String byline, String type,
                   String title, String anAbstract, List<String> desFacet, List<Object> orgFacet,
                   List<Object> perFacet, List<Object> geoFacet, List<Media> media, int etaId) {
        this.uri = uri;
        this.url = url;
        this.id = id;
        this.assetId = assetId;
        this.source = source;
        this.publishedDate = publishedDate;
        this.updated = updated;
        this.section = section;
        this.subsection = subsection;
        this.nytdsection = nytdsection;
        this.adxKeywords = adxKeywords;
        this.column = column;
        this.byline = byline;
        this.type = type;
        this.title = title;
        this.anAbstract = anAbstract;
        this.desFacet = desFacet;
        this.orgFacet = orgFacet;
        this.perFacet = perFacet;
        this.geoFacet = geoFacet;
        this.media = media;
        this.etaId = etaId;
    }

    public String getUri() {
        return uri;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

    public long getAssetId() {
        return assetId;
    }

    public String getSource() {
        return source;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getUpdated() {
        return updated;
    }

    public String getSection() {
        return section;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getNytdsection() {
        return nytdsection;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstract() {
        return anAbstract;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public List<Object> getOrgFacet() {
        return orgFacet;
    }

    public List<Object> getPerFacet() {
        return perFacet;
    }

    public List<Object> getGeoFacet() {
        return geoFacet;
    }

    public List<Media> getMedia() {
        return media;
    }

    public int getEtaId() {
        return etaId;
    }

}