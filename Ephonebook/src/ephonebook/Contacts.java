/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ephonebook;


import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
/**
 *
 * @author Eman Bathan
 */
public class Contacts {
    
    private static List<Contact> AllContacts;
    private static String MessageStatus;
    public static final String ContactFileName = "List.txt";

    /**
     * @return the MessageStatus
     */
    public static String getMessageStatus() {
        return MessageStatus;
    }

    /**
     * @param aMessageStatus the MessageStatus to set
     */
    public static void setMessageStatus(String aMessageStatus) {
        MessageStatus = aMessageStatus;
    }

    public Contacts() {
        AllContacts = new ArrayList<Contact>();
    }

    public static boolean updateContact(String name, String PhoneNo, String emailAdd, String NewStringLine) {
        BufferedReader br = null;
        String ReWrite = "";
        boolean success = false;
        try {
            if (new File(ContactFileName).exists()) {
                br = new BufferedReader(new FileReader(ContactFileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        String[] _temp = line.split(",");
                        if (_temp[0].equalsIgnoreCase(name) && _temp[1].equalsIgnoreCase(PhoneNo)
                                && _temp[2].equalsIgnoreCase(emailAdd)) {
                            ReWrite += NewStringLine + "\r\n";
                        } else {
                            ReWrite += line + "\r\n";
                        }
                    }
                }
                br.close();

                if (writeFile(ReWrite)) {
                    success = true;
                } else {
                    success = false;
                }
                //update ArrayList with new Contact List
                readPhoneContacts();

            } else {
                new File(ContactFileName).createNewFile();
                readPhoneContacts();
                success = false;
            }
        } catch (FileNotFoundException ex) {
            MessageStatus = ex.getMessage();
            success = false;
        } catch (IOException ex) {
            MessageStatus = ex.getMessage();
            success = false;
        }
        return success;
    }

    public static List<Contact> searchContact(String searchValue) {
        List<Contact> cnt = new ArrayList<>();
        BufferedReader br = null;

        try {
            if (new File(ContactFileName).exists()) {
                br = new BufferedReader(new FileReader(ContactFileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    if (!"".equals(line)) {
                        String[] _temp = line.split(",");
                        if (_temp[0].equalsIgnoreCase(searchValue) || _temp[1].equalsIgnoreCase(searchValue)
                                || _temp[2].equalsIgnoreCase(searchValue)) {
                            Contact c = new Contact();
                            c.setName(_temp[0]);
                            c.setPhoneNo(_temp[1]);
                            c.setEmailAddress(_temp[2]);
                            cnt.add(c);
                        }
                    }
                }
            } else {
                new File(ContactFileName).createNewFile();
                cnt = searchContact(searchValue);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        return cnt;
    }

    protected static boolean writeFile(String TextToWrite) {
        FileWriter writer = null;
        boolean successfulWrite = false;
        try {
            writer = new FileWriter(ContactFileName);
            writer.write(TextToWrite);
            writer.close();
            successfulWrite = true;
        } catch (IOException ex) {
            successfulWrite = false;
            MessageStatus = ex.getMessage();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                MessageStatus = ex.getMessage();
            }
        }
        return successfulWrite;
    }

    public static void deleteContacts(Contact C) {
        BufferedReader br = null;
        String ReWrite = "";
        try {
            if (new File(ContactFileName).exists()) {
                br = new BufferedReader(new FileReader(ContactFileName));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] _temp = line.split(",");
                    if (_temp[0].equalsIgnoreCase(C.getName()) && _temp[1].equalsIgnoreCase(C.getPhoneNo())
                            && _temp[2].equalsIgnoreCase(C.getEmailAddress())) {
                        //ignore line to delete this contact
                    } else {
                        ReWrite += line + "\r\n";
                    }
                }
                br.close();

                if (writeFile(ReWrite)) {
                    JOptionPane.showMessageDialog(null, "Successfully delete contact " + C.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete contact " + C.getName());
                }

                Contacts.readPhoneContacts();

            } else {
                new File(ContactFileName).createNewFile();
                readPhoneContacts();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void readPhoneContacts() {
        BufferedReader br = null;
        try {
            if (new File(ContactFileName).exists()) {

                if (AllContacts == null) {
                    AllContacts = new ArrayList<>();
                } else {
                    AllContacts.clear();
                }
                br = new BufferedReader(new FileReader(ContactFileName));
                StringBuilder sb = new StringBuilder();
                String line = "";
                Contact ContactClass = null;
                while ((line = br.readLine()) != null) {
                    if (!line.equalsIgnoreCase("")) {
                        ContactClass = new Contact();
                        String[] _temp = line.split(",");
                        String _tempValue = _temp[0];
                        if (_tempValue.equalsIgnoreCase("NULL")) {
                            _tempValue = "";
                        }
                        ContactClass.setName(_tempValue);

                        _tempValue = _temp[1];
                        if (_tempValue.equalsIgnoreCase("NULL")) {
                            _tempValue = "";
                        }
                        ContactClass.setPhoneNo(_tempValue);

                        _tempValue = _temp[2];
                        if (_tempValue.equalsIgnoreCase("NULL")) {
                            _tempValue = "";
                        }
                        ContactClass.setEmailAddress(_tempValue);
                        AllContacts.add(ContactClass);
                    }
                }
            } else {
                new File(ContactFileName).createNewFile();
                readPhoneContacts();
            }

        } catch (NullPointerException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static boolean appendTextContact(String appendValue) {
        boolean success = false;
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ContactFileName, true)));
            out.println(appendValue);
            out.close();
            success = true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return success;
    }

    public static List<Contact> getAllContacts() {
        return AllContacts;
    }

    public static void setAllContacts(List<Contact> aAllContacts) {
        AllContacts = aAllContacts;
    }

}
