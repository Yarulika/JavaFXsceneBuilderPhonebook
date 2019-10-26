package sample;


import javax.persistence.*;

@Entity
@Table(schema = "java_fx", name = "contacts")
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

    public Contact(){
    }

    public Contact(String name, String city, int phone) {
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
//        return String.format("Contact{name='%s', city='%s', phone=%d}", name,city,phone);
        return String.format("name: '%s', city: '%s', phone: %d", name,city,phone);
    }

}
