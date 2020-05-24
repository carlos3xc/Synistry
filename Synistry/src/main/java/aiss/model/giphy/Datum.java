
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
    "name",
    "name_encoded",
    "subcategories",
    "gif"
})
public class Datum {

    @JsonProperty("name")
    private String name;
    @JsonProperty("name_encoded")
    private String nameEncoded;
    @JsonProperty("subcategories")
    private List<Subcategory> subcategories = null;
    @JsonProperty("gif")
    private Gif gif;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("name_encoded")
    public String getNameEncoded() {
        return nameEncoded;
    }

    @JsonProperty("name_encoded")
    public void setNameEncoded(String nameEncoded) {
        this.nameEncoded = nameEncoded;
    }

    @JsonProperty("subcategories")
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    @JsonProperty("subcategories")
    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    @JsonProperty("gif")
    public Gif getGif() {
        return gif;
    }

    @JsonProperty("gif")
    public void setGif(Gif gif) {
        this.gif = gif;
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
