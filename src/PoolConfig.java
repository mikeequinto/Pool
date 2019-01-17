import java.util.Objects;

public class PoolConfig {

    int size;
    String url;
    String login;
    String password;

    public PoolConfig(int size, String url, String login, String password) {
        this.size = size;
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoolConfig that = (PoolConfig) o;
        return size == that.size &&
                Objects.equals(url, that.url) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(size, url, login, password);
    }
}
