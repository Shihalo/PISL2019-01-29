package by.bsuir.userhibernate;

import by.bsuir.userhibernate.dao.UserdataDaoImpl;
import by.bsuir.userhibernate.entity.User;
import by.bsuir.userhibernate.entity.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {
        List<User> usersList = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("by.bsuir.userhibernate.entity");
            Unmarshaller um = jc.createUnmarshaller();
            Users users = (Users) um.unmarshal(new File("userdata.xsd.xml"));
            usersList = users.getUser();
        } catch (JAXBException e) {
            System.err.println(e.toString());
        }
        System.out.println("Users from XML ");
        UserdataDaoImpl userdataDao = UserdataDaoImpl.getInstance();
        for (User user : usersList) {
            System.out.println(user);
            userdataDao.update(user);
        }

        List<User> foundUser = userdataDao.findAll();
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Marshaller m = context.createMarshaller();
        Users users = new Users();
        users.setUser(foundUser);
        m.marshal(users, new FileOutputStream("users_marsh.xml"));
    }
}