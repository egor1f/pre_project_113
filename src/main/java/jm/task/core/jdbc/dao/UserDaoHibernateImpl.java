package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }



    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            String sqlQuery = "CREATE TABLE IF NOT EXISTS users (\n" +
                    " id BIGINT PRIMARY KEY AUTO_INCREMENT,\n" +
                    " name VARCHAR(255) NOT NULL,\n" +
                    " lastName VARCHAR(255) NOT NULL,\n" +
                    " age TINYINT NOT NULL\n" +
                    " )";

            session.createSQLQuery(sqlQuery).executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            String sqlQuery = "DROP TABLE IF EXISTS users";

            session.createSQLQuery(sqlQuery).executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        User user = new User(name, lastName, age);

        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            User user = session.get(User.class, id);

            session.delete(user);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = null;

        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            users = session.createQuery("from User").getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = Util.getSessionFactory().openSession()) {

            session.beginTransaction();

            session.createQuery("delete from User").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
