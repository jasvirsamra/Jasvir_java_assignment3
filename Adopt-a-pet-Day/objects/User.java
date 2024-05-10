package objects;

public class User {
  private String name;
  private String email;
  private int phone;
  private String appointmentDay;


  public User(String name, String email, int phone) {
      this.name = name;
      this.email = email;
      this.phone = phone;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public int getPhone() {
      return phone;
  }

  public void setPhone(int phone) {
      this.phone = phone;
  }

  public String getAppointmentDay() {
      return appointmentDay;
  }

  public void setAppointmentDay(String Day) {
      this.appointmentDay = Day;
  }

}
