package objectsAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {
    public String type;
    public int id;
    public int parent_id;
    public String name;
    public String slug;
    public String description;
    public String email;
    public String hostname;
    public Object policy;
    public String created;
    public int email_server_id;
    public int bandwidth_throttle;
    public String throttle_exception_start;
    public String throttle_exception_end;
    public List<Integer> throttle_exception_dow;
    public String throttle_exception_days;
    public int throttle_exception_throttle;
    public Boolean active;
    public int  plan_id;
    public String trial_until;
    public String subscription_uuid;
    public String share_disclaimer;
    public int default_encryption;
    public Boolean email_templates;
    public Boolean privacy_mode;

    public Organization() {
    }

    @Override
    public String toString() {
        return "Organization{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", hostname='" + hostname + '\'' +
                ", policy=" + policy +
                ", created='" + created + '\'' +
                ", email_server_id=" + email_server_id +
                ", bandwidth_throttle=" + bandwidth_throttle +
                ", throttle_exception_start='" + throttle_exception_start + '\'' +
                ", throttle_exception_end='" + throttle_exception_end + '\'' +
                ", throttle_exception_dow=" + throttle_exception_dow +
                ", throttle_exception_days='" + throttle_exception_days + '\'' +
                ", throttle_exception_throttle=" + throttle_exception_throttle +
                ", active=" + active +
                ", plan_id=" + plan_id +
                ", trial_until='" + trial_until + '\'' +
                ", subscription_uuid='" + subscription_uuid + '\'' +
                ", share_disclaimer='" + share_disclaimer + '\'' +
                ", default_encryption=" + default_encryption +
                ", email_templates=" + email_templates +
                ", privacy_mode=" + privacy_mode +
                '}';
    }
}
