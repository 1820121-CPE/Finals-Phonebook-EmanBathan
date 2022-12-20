/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ephonebook;

/**
 *
 * @author Eman Bathan
 */
public class Contact  {
   
    private String Name;
    private String PhoneNo;
    private String EmailAddress;
   
    public Contact()
    {
        Name = "";
        PhoneNo = "";
        EmailAddress = "";
    }

    public String getName() {
        return Name;
    }


    public void setName(String Name) {
        this.Name = Name;
    }


    public String getPhoneNo() {
        return PhoneNo;
    }


    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }


    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }
   
}
