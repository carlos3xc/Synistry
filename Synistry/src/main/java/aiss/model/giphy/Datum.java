
package aiss.model.giphy;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "url",
    "slug",
    "bitly_gif_url",
    "bitly_url",
    "embed_url",
    "username",
    "source",
    "title",
    "rating",
    "content_url",
    "source_tld",
    "source_post_url",
    "is_sticker",
    "import_datetime",
    "trending_datetime",
    "images",
    "analytics_response_payload",
    "analytics"
})
public class Datum {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("bitly_gif_url")
    private String bitlyGifUrl;
    @JsonProperty("bitly_url")
    private String bitlyUrl;
    @JsonProperty("embed_url")
    private String embedUrl;
    @JsonProperty("username")
    private String username;
    @JsonProperty("source")
    private String source;
    @JsonProperty("title")
    private String title;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("content_url")
    private String contentUrl;
    @JsonProperty("source_tld")
    private String sourceTld;
    @JsonProperty("source_post_url")
    private String sourcePostUrl;
    @JsonProperty("is_sticker")
    private Integer isSticker;
    @JsonProperty("import_datetime")
    private String importDatetime;
    @JsonProperty("trending_datetime")
    private String trendingDatetime;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("analytics_response_payload")
    private String analyticsResponsePayload;
    @JsonProperty("analytics")
    private Analytics analytics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("bitly_gif_url")
    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    @JsonProperty("bitly_gif_url")
    public void setBitlyGifUrl(String bitlyGifUrl) {
        this.bitlyGifUrl = bitlyGifUrl;
    }

    @JsonProperty("bitly_url")
    public String getBitlyUrl() {
        return bitlyUrl;
    }

    @JsonProperty("bitly_url")
    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    @JsonProperty("embed_url")
    public String getEmbedUrl() {
        return embedUrl;
    }

    @JsonProperty("embed_url")
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("content_url")
    public String getContentUrl() {
        return contentUrl;
    }

    @JsonProperty("content_url")
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @JsonProperty("source_tld")
    public String getSourceTld() {
        return sourceTld;
    }

    @JsonProperty("source_tld")
    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    @JsonProperty("source_post_url")
    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    @JsonProperty("source_post_url")
    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    @JsonProperty("is_sticker")
    public Integer getIsSticker() {
        return isSticker;
    }

    @JsonProperty("is_sticker")
    public void setIsSticker(Integer isSticker) {
        this.isSticker = isSticker;
    }

    @JsonProperty("import_datetime")
    public String getImportDatetime() {
        return importDatetime;
    }

    @JsonProperty("import_datetime")
    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    @JsonProperty("trending_datetime")
    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    @JsonProperty("trending_datetime")
    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("analytics_response_payload")
    public String getAnalyticsResponsePayload() {
        return analyticsResponsePayload;
    }

    @JsonProperty("analytics_response_payload")
    public void setAnalyticsResponsePayload(String analyticsResponsePayload) {
        this.analyticsResponsePayload = analyticsResponsePayload;
    }

    @JsonProperty("analytics")
    public Analytics getAnalytics() {
        return analytics;
    }

    @JsonProperty("analytics")
    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
