
package aiss.model.museum;

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
    "links",
    "id",
    "objectNumber",
    "title",
    "hasImage",
    "principalOrFirstMaker",
    "longTitle",
    "showImage",
    "permitDownload",
    "webImage",
    "headerImage",
    "productionPlaces"
})
public class ArtObject {

    @JsonProperty("links")
    private Links links;
    @JsonProperty("id")
    private String id;
    @JsonProperty("objectNumber")
    private String objectNumber;
    @JsonProperty("title")
    private String title;
    @JsonProperty("hasImage")
    private Boolean hasImage;
    @JsonProperty("principalOrFirstMaker")
    private String principalOrFirstMaker;
    @JsonProperty("longTitle")
    private String longTitle;
    @JsonProperty("showImage")
    private Boolean showImage;
    @JsonProperty("permitDownload")
    private Boolean permitDownload;
    @JsonProperty("webImage")
    private WebImage webImage;
    @JsonProperty("headerImage")
    private HeaderImage headerImage;
    @JsonProperty("productionPlaces")
    private List<String> productionPlaces = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("objectNumber")
    public String getObjectNumber() {
        return objectNumber;
    }

    @JsonProperty("objectNumber")
    public void setObjectNumber(String objectNumber) {
        this.objectNumber = objectNumber;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("hasImage")
    public Boolean getHasImage() {
        return hasImage;
    }

    @JsonProperty("hasImage")
    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    @JsonProperty("principalOrFirstMaker")
    public String getPrincipalOrFirstMaker() {
        return principalOrFirstMaker;
    }

    @JsonProperty("principalOrFirstMaker")
    public void setPrincipalOrFirstMaker(String principalOrFirstMaker) {
        this.principalOrFirstMaker = principalOrFirstMaker;
    }

    @JsonProperty("longTitle")
    public String getLongTitle() {
        return longTitle;
    }

    @JsonProperty("longTitle")
    public void setLongTitle(String longTitle) {
        this.longTitle = longTitle;
    }

    @JsonProperty("showImage")
    public Boolean getShowImage() {
        return showImage;
    }

    @JsonProperty("showImage")
    public void setShowImage(Boolean showImage) {
        this.showImage = showImage;
    }

    @JsonProperty("permitDownload")
    public Boolean getPermitDownload() {
        return permitDownload;
    }

    @JsonProperty("permitDownload")
    public void setPermitDownload(Boolean permitDownload) {
        this.permitDownload = permitDownload;
    }

    @JsonProperty("webImage")
    public WebImage getWebImage() {
        return webImage;
    }

    @JsonProperty("webImage")
    public void setWebImage(WebImage webImage) {
        this.webImage = webImage;
    }

    @JsonProperty("headerImage")
    public HeaderImage getHeaderImage() {
        return headerImage;
    }

    @JsonProperty("headerImage")
    public void setHeaderImage(HeaderImage headerImage) {
        this.headerImage = headerImage;
    }

    @JsonProperty("productionPlaces")
    public List<String> getProductionPlaces() {
        return productionPlaces;
    }

    @JsonProperty("productionPlaces")
    public void setProductionPlaces(List<String> productionPlaces) {
        this.productionPlaces = productionPlaces;
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
