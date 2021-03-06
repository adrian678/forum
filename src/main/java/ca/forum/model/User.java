package ca.forum.model;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails { //TODO rename to MyUser, and have it extend the Spring User class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long uid;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @JoinTable
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;                   //TODO see if you can use Strings instead of a Role class
    @JoinTable
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topic> subscribedTopics;                   //TODO see if you can use Strings instead of a Role class
    @JoinTable
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> favoritedPosts;

    private boolean isActive;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;
    @NonNull
    private String email;

    private String name;
    @NonNull
    private Date acc_creation_date;

    public User() {
    }

    public User(String username){
        this.username = username;
        this.password = "test";
        this.acc_creation_date = new Date(System.currentTimeMillis());
        this.roles = new ArrayList<Role>();
        roles.add(new Role("ROLE_USER"));
        this.isActive = true;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.acc_creation_date = new Date(System.currentTimeMillis());
        this.subscribedTopics = new ArrayList<>();
    }

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<Role>();
        roles.add(new Role("ROLE_USER"));
        this.isActive = true;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
        this.acc_creation_date = new Date(System.currentTimeMillis());
        this.subscribedTopics = new ArrayList<>();
    }

    public User(String username, String password, List<Role> roles, boolean isActive, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, String email, String name, Date acc_creation_date) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isActive = isActive;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.email = email;
        this.name = name;
        this.acc_creation_date = acc_creation_date;
    }

    //    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uid"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "rid"))

    //getters and setters
    public long getId() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public List<Post> getFavoritedPosts() {
        return favoritedPosts;
    }

    public void setFavoritedPosts(List<Post> favoritedPosts) {
        this.favoritedPosts = favoritedPosts;
    }

    public List<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(List<Topic> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
