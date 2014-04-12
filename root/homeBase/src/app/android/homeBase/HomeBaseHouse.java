package app.android.homeBase;

import java.util.List;

/**
 * Created by kyle on 3/10/14.
 */
public class HomeBaseHouse {
    private String housename;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private float latitude;
    private float longitude;
    private String id;
    private String admin;
    private List<String> members;

    public HomeBaseHouse(String housename, String address, String city, String state, String admin, List<String> members, int zipCode)
    {
        this.housename = housename;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.admin = admin;
        this.members = members;

    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHousename() {

        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {

        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
