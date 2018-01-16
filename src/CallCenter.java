import java.util.concurrent.CyclicBarrier;

import employee.Employee;


public class CallCenter {

    public static void main(String[] args) {

        Employee operator = new Employee("operator", 7);
        Employee supervisor = new Employee("supervisor", 2);
        Employee director = new Employee("director", 1);

        CyclicBarrier standbyMessage = new CyclicBarrier(10, new Dispatcher());
        System.out.println("The call center is ready to answer phone calls");

        System.out.println("Available operators initially=" + operator.getCall().availablePermits());
        System.out.println("Available supervisors initially="+ supervisor.getCall().availablePermits());
        System.out.println("Available directors initially=" + director.getCall().availablePermits());

        new Customer(operator.getCall(), standbyMessage,"Luigi");
        new Customer(operator.getCall(), standbyMessage,"Mario");
        new Customer(operator.getCall(), standbyMessage,"Laura");
        new Customer(operator.getCall(), standbyMessage,"Paola");
        new Customer(operator.getCall(), standbyMessage,"Alfonso");
        new Customer(operator.getCall(), standbyMessage,"Anna");
        new Customer(operator.getCall(), standbyMessage,"Giorgio");
        new Customer(operator.getCall(), standbyMessage,"Francesca");
        new Customer(operator.getCall(), standbyMessage,"Pietro");
        new Customer(operator.getCall(), standbyMessage,"Antonio");
        new Customer(operator.getCall(), standbyMessage,"Marco");
        new Customer(operator.getCall(), standbyMessage,"Giovanna");
        new Customer(operator.getCall(), standbyMessage,"Daniele");
        new Customer(operator.getCall(), standbyMessage,"Giorgio");
    }
}