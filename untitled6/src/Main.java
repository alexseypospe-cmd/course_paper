public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        // Создаём 11 сотрудников (11‑й не добавится — массив на 10)
        Employee e1 = new Employee("Иванов И. И", 1, 120.0);
        Employee e2 = new Employee("Петров П. П.", 1, 180.0);
        Employee e3 = new Employee("Сидоров С. С.", 2, 250.0);
        Employee e4 = new Employee("Козлов К. К.", 2, 320.0);
        Employee e5 = new Employee("Морозова M. M.", 3, 400.0);
        Employee e6 = new Employee("Фёдоров Ф. Ф.", 3, 110.0);
        Employee e7 = new Employee("Волкова В. В.", 1, 140.0);
        Employee e8 = new Employee("Новиков Н. Н.", 2, 290.0);
        Employee e9 = new Employee("Зайцева З. З.", 3, 370.0);
        Employee e10 = new Employee("Орлов О. О.", 1, 160.0);
        Employee e11 = new Employee("Смирнова С. С.", 2, 220.0); // 11‑й — не поместится

        Employee[] allEmployees = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11};

        System.out.println("=== Добавление сотрудников ===");
        for (int i = 0; i < allEmployees.length; i++) {
            boolean added = book.addEmployee(allEmployees[i]);
            System.out.println("Сотрудник " + allEmployees[i].getFullName() +
                    " (ID=" + allEmployees[i].getId() + ") добавлен: " + added);
        }
        System.out.println("\n=== Список всех сотрудников ===");
        book.printAllEmployees();

        System.out.println("\n=== Средняя зарплата ===");
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        System.out.println("\nИндексация зарплат отдела 1 на 10%:");
        book.indexSalariesByDepartment(1, 10);
        book.printAllEmployees();

        System.out.println("Зарплата выше 250");
        book.findFirstEmployeeByDepartmentAndSalary(2, 250);

        System.out.println("2-е с зарплатой меньше 200");
        book.printEmployeesWithSalaryLessThan(200, 2);

    }
}