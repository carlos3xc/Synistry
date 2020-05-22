
package aiss.model.dribbble;

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
    "hidpi",
    "normal",
    "teaser"
})
public class Images {

    @JsonProperty("hidpi")
    private Object hidpi;
    @JsonProperty("normal")
    private String normal;
    @JsonProperty("teaser")
    private String teaser;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hidpi")
    public Object getHidpi() {
        return hidpi;
    }

    @JsonProperty("hidpi")
    public void setHidpi(Object hidpi) {
        this.hidpi = hidpi;
    }

    @JsonProperty("normal")
    public String getNormal() {
        return normal;
    }

    @JsonProperty("normal")
    public void setNormal(String normal) {
        this.normal = normal;
    }

    @JsonProperty("teaser")
    public String getTeaser() {
        return teaser;
    }

    @JsonProperty("teaser")
    public void setTeaser(String teaser) {
        this.teaser = teaser;
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
