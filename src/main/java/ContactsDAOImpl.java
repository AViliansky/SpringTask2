import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lddaniild on 18.09.14.
 */
@Repository
public class ContactsDAOImpl implements ContactsDAO {

    @Value("${maxSize}")
    private int maxSize;

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    public int getMaxSize(){
        return maxSize;
    }

    private List<Contact> listOfContacts;

    @Override
    public void setContact(Contact contact) {
        this.listOfContacts.add(contact);
    }

    @Override
    public void removeContact(Contact contact) {
        this.listOfContacts.remove(contact);
    }

    public List<Contact> getListOfContacts(){
        return listOfContacts;
    }

    public void setListOfContacts(List listOfContacts){
        if(listOfContacts.size()<=maxSize) {
            this.listOfContacts = listOfContacts;
        }
        else{
            int difference = listOfContacts.size()-maxSize;
            for(int i=0; i<difference; i++){
                listOfContacts.remove(listOfContacts.get(0));
            }
            this.listOfContacts = listOfContacts;
        }
    }

}
