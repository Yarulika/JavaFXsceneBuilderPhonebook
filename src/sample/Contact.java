package sample;

public class Contact {

    private String name;
    private String city;
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

    @Override
    public String toString() {
        return String.format("Contact{name='%s', city='%s', phone=%d}", name,city,phone);
    }

}
