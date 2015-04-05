package spoon.domain;

public class Owner {

    private Long id;
    private String username;
    private String password;
    private RoleType role;

    public Owner(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = RoleType.OWNER;
    }

    public RoleType getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
