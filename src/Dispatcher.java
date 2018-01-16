import employee.Employee;

public class Dispatcher extends Thread {

    public void dispatchCall(Employee employee) {
        if((employee.getCall().availablePermits() < employee.getVacants()) && employee.getType().equals("operator")) {
            run(employee.getType());
            System.out.println("All operators are busy at the moment - playing MUSIC ..., passing call to a Supervisor");
        } else if ((employee.getCall().availablePermits() < employee.getVacants()) && employee.getType().equals("supervisor")){
            run(employee.getType());
            System.out.println("All operators are busy at the moment - playing MUSIC ..., passing call to a Director");
        } else if((employee.getCall().availablePermits() < employee.getVacants()) && employee.getType().equals("director")) {
            run(employee.getType());
            System.out.println("All operators are busy at the moment - playing MUSIC ...");
        }
    }

    public void run(String role) {
        System.out.println("All "+ role +" are busy at the moment - playing MUSIC ...");
    }

}