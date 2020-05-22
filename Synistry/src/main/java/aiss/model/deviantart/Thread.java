
package aiss.model.deviantart;

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
    "body",
    "commentid",
    "parentid",
    "posted",
    "replies",
    "hidden",
    "user"
})
public class Thread {

    @JsonProperty("body")
    private String body;
    @JsonProperty("commentid")
    private String commentid;
    @JsonProperty("parentid")
    private String parentid;
    @JsonProperty("posted")
    private String posted;
    @JsonProperty("replies")
    private Integer replies;
    @JsonProperty("hidden")
    private String hidden;
    @JsonProperty("user")
    private User user;
    @Override
	public String toString() {
		return "Thread [body=" + body + ", user=" + user + "]";
	}

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("commentid")
    public String getCommentid() {
        return commentid;
    }

    @JsonProperty("commentid")
    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    @JsonProperty("parentid")
    public String getParentid() {
        return parentid;
    }

    @JsonProperty("parentid")
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    @JsonProperty("posted")
    public String getPosted() {
        return posted;
    }

    @JsonProperty("posted")
    public void setPosted(String posted) {
        this.posted = posted;
    }

    @JsonProperty("replies")
    public Integer getReplies() {
        return replies;
    }

    @JsonProperty("replies")
    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    @JsonProperty("hidden")
    public String getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
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
