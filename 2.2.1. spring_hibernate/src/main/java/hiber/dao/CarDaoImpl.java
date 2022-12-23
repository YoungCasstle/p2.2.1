package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class CarDaoImpl implements CarDao{
    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory.openSession().createQuery("select c from Car c", Car.class);
        return query.getResultList();
    }

    @Override
    public List<User> listUsers(Car car) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("select c.user from Car c where c.series=?1 and c.model=?2", User.class);
        query.setParameter(1, car.getSeries());
        query.setParameter(2, car.getModel());
        return query.getResultList();
    }
}
