package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class MainApp {

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("Josh ", "Bush", "Jobu@mail.ru",new Car("Toyota",4)));
      userService.add(new User("Crosh", "Smesharikof", "smesh12@mail.ru",new Car("kia",22)));
      userService.add(new User("Billy", "Herringthone", "gachi228@mail.ru",new Car("LadaGranta",10)));
      userService.add(new User("Asap", "Rocky", "A$ap@mail.ru",new Car("Ferrari",12)));

      System.out.println("Все пользователи:\n");
      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      Car car = new Car("BMW", 100);
      System.out.println("Пользователи с машиной:\n" + car + "\n");
      carService.listUsers(car).forEach(System.out::println);

      context.close();
   }
}
