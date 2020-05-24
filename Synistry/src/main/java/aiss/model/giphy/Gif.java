
package aiss.model.giphy;

import java.util.HashMap;
import java.util.List;
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
    "tags",
    "featured_tags",
    "source_tld",
    "source_post_url",
    "is_sticker",
    "import_datetime",
    "trending_datetime",
    "create_datetime",
    "update_datetime",
    "images"
})
public class Gif {

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
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("featured_tags")
    private List<String> featuredTags = null;
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
    @JsonProperty("create_datetime")
    private String createDatetime;
    @JsonProperty("update_datetime")
    private String updateDatetime;
    @JsonProperty("images")
    private Images images;
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

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("featured_tags")
    public List<String> getFeaturedTags() {
        return featuredTags;
    }

    @JsonProperty("featured_tags")
    public void setFeaturedTags(List<String> featuredTags) {
        this.featuredTags = featuredTags;
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

    @JsonProperty("create_datetime")
    public String getCreateDatetime() {
        return createDatetime;
    }

    @JsonProperty("create_datetime")
    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    @JsonProperty("update_datetime")
    public String getUpdateDatetime() {
        return updateDatetime;
    }

    @JsonProperty("update_datetime")
    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
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
