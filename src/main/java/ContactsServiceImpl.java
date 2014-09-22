import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lddaniild on 18.09.14.
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Value("${maxSize}")
    private int maxSize;

    @Autowired
    private ContactsDAOImpl contactsDAOInstance;

    public void setContactsDAOInstance(ContactsDAOImpl c){
        this.contactsDAOInstance = c;
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    public int getMaxSize(){
        return maxSize;
    }

    @Override
    public void addContact(Contact contact) {
        if (contactsDAOInstance.getListOfContacts().size()<=maxSize){
            contactsDAOInstance.setContact(contact);
        }
        else{
            this.deleteContact(contactsDAOInstance.getListOfContacts().get(0));
            contactsDAOInstance.setContact(contact);
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        contactsDAOInstance.removeContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactsDAOInstance.getListOfContacts();
    }

    @Override
    public void clearAll() {
        contactsDAOInstance.getListOfContacts().clear();
    }
}
