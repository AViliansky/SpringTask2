import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 03.10.2014.
 */

public class ControllerDao {
    @Autowired
    private ContactsDAOImpl contactsDAO;

    public ContactsDAOImpl getContactsDAO() {
        return contactsDAO;
    }

    public void setContactsDAO(ContactsDAOImpl contactsDAO) {
        this.contactsDAO = contactsDAO;
    }
    public boolean findVasia (String nameParameter){
        for (int i=0; i<contactsDAO.getListOfContacts().size(); i++){
            if (contactsDAO.getListOfContacts().get(i).getFirstName().equals(nameParameter)){
                return true;

            }
            else {
                return false;
            }
        }
        return true;
    }
}
