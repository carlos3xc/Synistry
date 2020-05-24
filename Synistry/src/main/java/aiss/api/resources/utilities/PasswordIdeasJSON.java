package aiss.api.resources.utilities;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PasswordIdeasJSON {
	private String password;
	private Collection<String> ideasIds;
	
	
	public PasswordIdeasJSON() {
		super();
	}
	
	public PasswordIdeasJSON(String password, Collection<String> ideasIds) {
		super();
		this.password = password;
		this.ideasIds = ideasIds;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty("ideas")
	public Collection<String> getIdeasIds() {
		return ideasIds;
	}
	
	@JsonProperty("ideas")
	public void setIdeasIds(Collection<String> ideasIds) {
		this.ideasIds = ideasIds;
	}	
	
}
