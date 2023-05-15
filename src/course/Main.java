package course;

public class Main {

    public static final Employee[] employees = {
            new Employee("Казанцев Илья Алексеевич ", 150000, 1),
            new Employee("Казанцев Алексей Вячеславович ", 15000000, 1),
            new Employee("Казанцева Ирина Владимировна ", 1500000, 1),
            new Employee("Иванов Иван Иванович", 15000, 5),
            new Employee("Кедровская Софья Олеговна", 500000, 3),
            new Employee("Шураев Вадим Иванович", 100000, 4),
            new Employee("Кедровская Анна Александровна", 100000, 2),
            new Employee("Кедровская Ксения Олеговна", 300000, 2),
    };



    public static void main(String[] args) {
        printEmployees();
        System.out.println("------------------------------------");
        System.out.println("Сумма затрат на зарплаты: "+totalSalary());
        System.out.println("------------------------------------");
        System.out.println("Средняя зарплата сотрудников:"+calculateAverageSalary());
        System.out.println("------------------------------------");
        System.out.println("Сотрудник с наибольшей зарплатой:"+toFindEmployeeWithTheBiggestSalary());
        System.out.println("------------------------------------");
        System.out.println("Сотрудник с наименьшей зарплатой:"+toFindEmployeeWithTheLowestSalary());
        System.out.println("------------------------------------");
        printEmployeeFullName();

        //Повышенная сложность

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Повышенная сложность");
        System.out.println("------------------------------------------------------------------------");
        salaryIndexing(50);
        printEmployees();
        System.out.println("------------------------------------");
        System.out.println(toFindEmployeeWithTheLowestSalaryOfDepartment(1));
        System.out.println("------------------------------------");
        System.out.println(toFindEmployeeWithTheBiggestSalaryOfDepartment(6));
        System.out.println("------------------------------------");
        System.out.println(totalSalaryOfDepartment());
        System.out.println("------------------------------------");
        printEmployeesOfDepartment(3);
        System.out.println("------------------------------------");
        printEmployeesOfDepartment(1);
        System.out.println("------------------------------------");
        printEmployeesWithSalaryBiggerThan(300000);
        System.out.println("------------------------------------");
        printEmployeesWithSalaryLessThan(300000);

        //Очень сложно


    }

    private static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    private static int totalSalary (){
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }


    private static Employee toFindEmployeeWithTheLowestSalary(){
        Employee result = employees[0];
        for (Employee employee: employees) {
            if (employee.getSalary() < result.getSalary()) {
                result = employee;
            }
        }
        return result;
    }

    private static Employee toFindEmployeeWithTheBiggestSalary(){
        Employee result = employees[0];
        for (Employee employee: employees) {
            if (employee.getSalary() > result.getSalary()) {
                result = employee;
            }
        }
        return result;
    }

    private static float calculateAverageSalary(){
        return totalSalary() / (float) employees.length;
    }

    private static void printEmployeeFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }





    //Повышенная сложность




    private static void salaryIndexing(int percent) {
        for (Employee employee : employees) {
            employee.setSalary((int)(employee.getSalary()*(percent/100f+1)));

        }
    }


    private static Employee toFindEmployeeWithTheLowestSalaryOfDepartment(int department){
        int theLowestSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee: employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (employee.getSalary() < theLowestSalary) {
                theLowestSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    private static Employee toFindEmployeeWithTheBiggestSalaryOfDepartment(int department){
        int theBiggestSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee: employees) {
            if (employee.getDepartment()!=department) {
                continue;
            }
            if (employee.getSalary() > theBiggestSalary) {
                theBiggestSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }


    private static int totalSalaryOfDepartment (){
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == 2) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }


    private static float calculateAverageSalaryOfDepartment (int department) {
        int countOfEmployees = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                countOfEmployees++;
            }
        }
        return sum / (float) countOfEmployees;
    }

    private static void salaryIndexingOfDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary()*percent/100f+1));
            }
        }
    }

    private static void printEmployeesOfDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getInformationOfEmployee());
            }
        }
    }


    private static void printEmployeesWithSalaryLessThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.getInformationOfEmployee());
            }
        }
    }

    private static void printEmployeesWithSalaryBiggerThan(int salary) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getInformationOfEmployee());
            }
        }
    }

}
