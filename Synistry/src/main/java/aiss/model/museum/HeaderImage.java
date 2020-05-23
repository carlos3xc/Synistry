
package aiss.model.museum;

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
    "guid",
    "offsetPercentageX",
    "offsetPercentageY",
    "width",
    "height",
    "url"
})
public class HeaderImage {

    @JsonProperty("guid")
    private String guid;
    @JsonProperty("offsetPercentageX")
    private Integer offsetPercentageX;
    @JsonProperty("offsetPercentageY")
    private Integer offsetPercentageY;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("offsetPercentageX")
    public Integer getOffsetPercentageX() {
        return offsetPercentageX;
    }

    @JsonProperty("offsetPercentageX")
    public void setOffsetPercentageX(Integer offsetPercentageX) {
        this.offsetPercentageX = offsetPercentageX;
    }

    @JsonProperty("offsetPercentageY")
    public Integer getOffsetPercentageY() {
        return offsetPercentageY;
    }

    @JsonProperty("offsetPercentageY")
    public void setOffsetPercentageY(Integer offsetPercentageY) {
        this.offsetPercentageY = offsetPercentageY;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
