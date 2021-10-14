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
    public String password;

    public Account() {
    }

    public Account(String type, int id, String email, String username, int company_id, String first_name, String last_name, String display_name, int root_id, List<Object> roots, String space_quota, String space_quota_formatted, int space_usage, String space_usage_formatted, Boolean can_share, Object company_policy, String password) {
        this.type = type;
        this.id = id;
        this.email = email;
        this.username = username;
        this.company_id = company_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.display_name = display_name;
        this.root_id = root_id;
        this.roots = roots;
        this.space_quota = space_quota;
        this.space_quota_formatted = space_quota_formatted;
        this.space_usage = space_usage;
        this.space_usage_formatted = space_usage_formatted;
        this.can_share = can_share;
        this.company_policy = company_policy;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", company_id=" + company_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", display_name='" + display_name + '\'' +
                ", root_id=" + root_id +
                ", roots=" + roots +
                ", space_quota='" + space_quota + '\'' +
                ", space_quota_formatted='" + space_quota_formatted + '\'' +
                ", space_usage=" + space_usage +
                ", space_usage_formatted='" + space_usage_formatted + '\'' +
                ", can_share=" + can_share +
                ", company_policy=" + company_policy +
                ", password='" + password + '\'' +
                '}';
    }
}
