package pojos;

public class UserOfReqresIn {
    //private Integer id;
    private String name;
    private String email;

    public UserOfReqresIn() {
    }

    public UserOfReqresIn(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
