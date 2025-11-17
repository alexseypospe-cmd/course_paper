public class EmployeeBook {
    private final Employee[] employees = new Employee[10]; // Массив на 10 сотрудников

    // 1. Получить список всех сотрудников
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // 2. Подсчитать среднее значение зарплат
    public double calculateAverageSalary() {
        int count = 0;
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
                total += employee.getSalary();
            }
        }
        return count > 0 ? total / count : 0;
    }

    // 3. Вывести значения налогов
    public void printTaxes(String taxType) {
        for (Employee employee : employees) {
            if (employee != null) {
                double tax = 0;
                switch (taxType) {
                    case "PROGRESSIVE":
                        if (employee.getSalary() <= 150) {
                            tax = employee.getSalary() * 0.13;
                        } else if (employee.getSalary() <= 350) {
                            tax = employee.getSalary() * 0.17;
                        } else {
                            tax = employee.getSalary() * 0.21;
                        }
                        break;
                    default:
                        System.out.println("Неизвестный тип налога: " + taxType);
                        return;
                }
                System.out.println("Сотрудник " + employee.getFullName() +
                        ", зарплата: " + employee.getSalary() +
                        ", налог: " + tax);
            }
        }
    }

    // 4. Индексировать зарплаты по отделу
    public void indexSalariesByDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            if (employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    // 5. Найти первого сотрудника отдела с зарплатой больше указанной
    public void findFirstEmployeeByDepartmentAndSalary(int department, double minSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getDepartment() == department &&
                    employee.getSalary() > minSalary) {
                System.out.println("Позиция в списке: " + (i + 1));
                employee.printShortInfo();
                break;
            }
        }
    }

    // 6. Найти первых N сотрудников с зарплатой меньше указанной
    public void printEmployeesWithSalaryLessThan(double wage, int employeeNumber) {
        int counter = 0;
        int index = 0;

        while (index < employees.length && counter < employeeNumber) {
            Employee employee = employees[index];
            if (employee != null && employee.getSalary() < wage) {
                employee.printShortInfo();
                counter++;
            }
            index++;
        }
    }

    // 7. Проверить наличие сотрудника (по зарплате)
    public boolean containsEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp != null && emp.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    // 8. Добавить нового сотрудника
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    // 9. Получить сотрудника по ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}


