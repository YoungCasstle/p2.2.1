package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Josh ", "Bush", "Jobu@mail.ru",new Car("Toyota",4)));
      userService.add(new User("Crosh", "Smesharikof", "smesh12@mail.ru",new Car("kia",22)));
      userService.add(new User("Billy", "Herringthone", "gachi228@mail.ru",new Car("LadaGranta",10)));
      userService.add(new User("Asap", "Rocky", "A$ap@mail.ru",new Car("Ferrari",12)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car ="+user.getCar());
         System.out.println(userService.getUserFromCar("Ferrari",12));
      }

      context.close();
   }
}
