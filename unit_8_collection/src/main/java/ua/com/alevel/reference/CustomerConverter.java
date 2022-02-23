package ua.com.alevel.reference;

public class CustomerConverter {

    private String id;
    private String fullName;
    private Integer age;
    private String created;

    public CustomerConverter() { }

    public CustomerConverter(Customer customer) {
        this.id = customer.getId();
        this.fullName = customer.getFirstName() + " " + customer.getLastName();
        this.age = customer.getAge();
        this.created = customer.getCreated().toString();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "CustomerConverter{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", created='" + created + '\'' +
                '}';
    }
}
