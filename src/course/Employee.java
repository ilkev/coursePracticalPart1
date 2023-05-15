package course;

public class Employee {
    private final String fullName;
    private Integer salary;
    private Integer department;
    private final Integer id;

    private static Integer counter = 1;

    public Employee(String fullName, Integer salary, Integer department) {
        this.id = counter++;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }




    public String getFullName() {
        return fullName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public Integer getId() {
        return id;
    }

    public static Integer getCounter() {
        return counter;
    }





    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }


    public String getInformationOfEmployee() {
        return "{" +
                "Полное имя:'" + fullName + '\'' +
                ", Зарплата:" + salary +
                ", id:" + id +
                '}';
    }


    @Override
    public String toString() {
        return "{" +
                "Полное имя:'" + fullName + '\'' +
                ", Зарплата:" + salary +
                ", Отдел " + department +
                ", id:" + id +
                '}';
    }
}

