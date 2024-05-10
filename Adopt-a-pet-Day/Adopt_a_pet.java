import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
   private static Scanner input = new Scanner(System.in);
   private static Ink ink = new Ink();
   private static User user;
   private static Shelter shelter = new Shelter();
   private static Pet pet;

   private static int choice;
   private static boolean isDone = false;

   public static void main(String[] args) {
    createUser(); 
    createPets(); 

    while(!isDone) {
      choice = ink.validateMainMenu();

      if (choice == 1) { 
        ink.printAvailablePets(shelter.getPets());
        int petChoice = input.nextInt();
        if (petChoice != 0) {
          ink.printPetDetails(shelter.getPet(petChoice - 1));
          System.out.println("Adopt this pet? Y/N");
          String answer = input.next();
          if (answer.equalsIgnoreCase("Y")) {
            shelter.adopt(petChoice - 1, user.getName());
          }
        }
      } else if (choice == 2) { 
        ink.printShelterDetails(shelter);
        input.nextLine(); 
      } else if (choice == 3) { // book an appointment menu
        input.nextLine();
        Appointment();
      } else if (choice == 4) { 
        isDone = true;
      } else {
        System.out.println("Oops! Invalid choice.");
      }
    } 
  } 
  public static void createPets() {
    pet = new Pet("spot", "dog", 3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog", 7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat", 1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()

  public static void createUser() {
    String name, email;
    int phone;
    System.out.println("What is your name? ");
    name = input.nextLine();
    System.out.println("What is your email? ");
    email = input.nextLine();
    System.out.println("What is your phone? ");
    phone = input.nextInt();
    user = new User(name, email, phone);
  } // createUser()

  public static void Appointment() {
    System.out.println("Hours of operation:");
    System.out.println("Monday to Friday: 9 AM to 5 PM");
    System.out.println("Saturday: 10 AM to 4 PM");
    System.out.println("Sunday: Closed");
    System.out.println("Please select a day for the appointment (1-7):");
    int dayChoice = input.nextInt();

    if (dayChoice >= 1 && dayChoice <= 7) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        user.setAppointmentDay(days[dayChoice - 1]);
        System.out.println("Appointment booked for " + user.getAppointmentDay());
        
    } else {
        System.out.println("Invalid day selection.");
    }
  } 
} 
