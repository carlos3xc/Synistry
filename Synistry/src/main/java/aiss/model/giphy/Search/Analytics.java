
package aiss.model.giphy.Search;

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
    "onload",
    "onclick",
    "onsent"
})
public class Analytics {

    @JsonProperty("onload")
    private Onload onload;
    @JsonProperty("onclick")
    private Onclick onclick;
    @JsonProperty("onsent")
    private Onsent onsent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("onload")
    public Onload getOnload() {
        return onload;
    }

    @JsonProperty("onload")
    public void setOnload(Onload onload) {
        this.onload = onload;
    }

    @JsonProperty("onclick")
    public Onclick getOnclick() {
        return onclick;
    }

    @JsonProperty("onclick")
    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    @JsonProperty("onsent")
    public Onsent getOnsent() {
        return onsent;
    }

    @JsonProperty("onsent")
    public void setOnsent(Onsent onsent) {
        this.onsent = onsent;
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
