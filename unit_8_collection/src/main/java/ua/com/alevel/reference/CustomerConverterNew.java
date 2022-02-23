package ua.com.alevel.reference;

public class CustomerConverterNew {

    private String id;
    private String fullName;
    private String created;

    public CustomerConverterNew(CustomerConverter customer) {
        this.id = customer.getId();
        this.fullName = customer.getFullName() + ": " + customer.getAge();
        this.created = customer.getCreated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "CustomerConverterNew{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
