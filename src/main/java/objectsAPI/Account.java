package objectsAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.testng.annotations.TestInstance;

import java.util.List;
//import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
//    @SerializedName("type")
    public String type;
    public int id;
    public String email;
    public String username;
    public int company_id;
    public String first_name;
    public String last_name;
    public String display_name;
    public int root_id;
    public List<Object> roots;
    public String space_quota;
    public String space_quota_formatted;
    public int space_usage;
    public String space_usage_formatted;
    public Boolean can_share;
    public Object company_policy;
}
