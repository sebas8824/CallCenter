package employee;

import java.util.concurrent.Semaphore;

public class Employee {
    private String type;
    private Integer vacants;
    private Semaphore call;

    public Employee(String type, Integer vacants) {
        this.type = type;
        this.vacants = vacants;
        this.call = new Semaphore(vacants);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVacants() {
        return vacants;
    }

    public void setVacants(Integer vacants) {
        this.vacants = vacants;
    }

    public Semaphore getCall() {
        return call;
    }

}
