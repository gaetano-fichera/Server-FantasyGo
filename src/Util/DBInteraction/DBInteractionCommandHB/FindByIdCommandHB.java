package Util.DBInteraction.DBInteractionCommandHB;

import Util.DBInteraction.DBInteractionCommand.FindByIdCommand;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FindByIdCommandHB extends FindByIdCommand{

    @Override
    public List<Object> execute(Object sessionObject) {
        Session session = (Session) sessionObject;
        System.out.println("Sessione " + session);
        if (!session.getTransaction().isActive()) session.getTransaction().begin();
        System.out.println("Transaction" + session.getTransaction());

        ArrayList<Object> results = new ArrayList<>();
        results.add(session.find(getClassPersistance(), getId()));

        return results;
    }
}
