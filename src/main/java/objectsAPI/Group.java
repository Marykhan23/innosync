package objectsAPI;
import org.apache.commons.lang3.RandomStringUtils;

public class Group {
    public Boolean active;
    public int company_id;
    public String created;
    public int id;
    public String name;
    public String type;
    public Group(int company_id) {
        this.company_id = company_id;
        this.name = RandomStringUtils.randomAlphanumeric(6);
    }

    public Group(Boolean active, int company_id, String created, int id, String name, String type) {
        this.active = active;
        this.company_id = company_id;
        this.created = created;
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "active=" + active +
                ", company_id=" + company_id +
                ", created='" + created + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

