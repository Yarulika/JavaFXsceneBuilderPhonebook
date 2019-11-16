package architecture.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import architecture.databases.ContactListener;

import javax.persistence.*;

@Entity
@Table(name = "contacts") //OR (schema = "java_fx", name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(ContactListener.class)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @Column
    private int phone;

    public Contact(String name, String city, int phone) {
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("name: '%s', city: '%s', phone: '%d'", name, city, phone);
    }


}
