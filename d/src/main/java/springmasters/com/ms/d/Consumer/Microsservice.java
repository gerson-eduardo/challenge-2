package springmasters.com.ms.d.Consumer;
import java.util.Objects;

public class Microsservice {
    private String name;

    public Microsservice() {
    }

    public Microsservice(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Microsservice name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Microsservice)) {
            return false;
        }
        Microsservice microsservice = (Microsservice) o;
        return Objects.equals(name, microsservice.name);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }
    
}
