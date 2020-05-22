
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
    "elapsedMilliseconds",
    "count",
    "artObjects"
})
public class Collections {

    @JsonProperty("elapsedMilliseconds")
    private Integer elapsedMilliseconds;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("artObjects")
    private List<ArtObject> artObjects = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("elapsedMilliseconds")
    public Integer getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    @JsonProperty("elapsedMilliseconds")
    public void setElapsedMilliseconds(Integer elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("artObjects")
    public List<ArtObject> getArtObjects() {
        return artObjects;
    }

    @JsonProperty("artObjects")
    public void setArtObjects(List<ArtObject> artObjects) {
        this.artObjects = artObjects;
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
