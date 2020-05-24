
package aiss.model.deviantart;

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
    "deviationid",
    "printid",
    "url",
    "title",
    "category",
    "category_path",
    "is_favourited",
    "is_deleted",
    "author",
    "stats",
    "published_time",
    "allows_comments",
    "preview",
    "content",
    "thumbs",
    "is_mature",
    "is_downloadable"
})
public class Deviation {

    @JsonProperty("deviationid")
    private String deviationid;
    @JsonProperty("printid")
    private Object printid;
    @JsonProperty("url")
    private String url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("category")
    private String category;
    @JsonProperty("category_path")
    private String categoryPath;
    @JsonProperty("is_favourited")
    private Boolean isFavourited;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("published_time")
    private String publishedTime;
    @JsonProperty("allows_comments")
    private Boolean allowsComments;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("content")
    private Content content;
    @JsonProperty("thumbs")
    private List<Thumb> thumbs = null;
    @JsonProperty("is_mature")
    private Boolean isMature;
    @JsonProperty("is_downloadable")
    private Boolean isDownloadable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("deviationid")
    public String getDeviationid() {
        return deviationid;
    }

    @JsonProperty("deviationid")
    public void setDeviationid(String deviationid) {
        this.deviationid = deviationid;
    }

    @JsonProperty("printid")
    public Object getPrintid() {
        return printid;
    }

    @JsonProperty("printid")
    public void setPrintid(Object printid) {
        this.printid = printid;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("category_path")
    public String getCategoryPath() {
        return categoryPath;
    }

    @JsonProperty("category_path")
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    @JsonProperty("is_favourited")
    public Boolean getIsFavourited() {
        return isFavourited;
    }

    @JsonProperty("is_favourited")
    public void setIsFavourited(Boolean isFavourited) {
        this.isFavourited = isFavourited;
    }

    @JsonProperty("is_deleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("published_time")
    public String getPublishedTime() {
        return publishedTime;
    }

    @JsonProperty("published_time")
    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    @JsonProperty("allows_comments")
    public Boolean getAllowsComments() {
        return allowsComments;
    }

    @JsonProperty("allows_comments")
    public void setAllowsComments(Boolean allowsComments) {
        this.allowsComments = allowsComments;
    }

    @JsonProperty("preview")
    public Preview getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
    }

    @JsonProperty("thumbs")
    public List<Thumb> getThumbs() {
        return thumbs;
    }

    @JsonProperty("thumbs")
    public void setThumbs(List<Thumb> thumbs) {
        this.thumbs = thumbs;
    }

    @JsonProperty("is_mature")
    public Boolean getIsMature() {
        return isMature;
    }

    @JsonProperty("is_mature")
    public void setIsMature(Boolean isMature) {
        this.isMature = isMature;
    }

    @JsonProperty("is_downloadable")
    public Boolean getIsDownloadable() {
        return isDownloadable;
    }

    @JsonProperty("is_downloadable")
    public void setIsDownloadable(Boolean isDownloadable) {
        this.isDownloadable = isDownloadable;
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
