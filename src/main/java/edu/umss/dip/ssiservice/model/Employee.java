/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.model;

public class Employee {
    private String firstName;
    private String lastName;
    private Byte[] image;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
