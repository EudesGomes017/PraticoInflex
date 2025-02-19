# 📊 Gerenciamento de Funcionários em Java

Este projeto é uma aplicação Java que realiza diversas operações sobre uma lista de funcionários, como:
- Cadastro e listagem de funcionários
- Aplicação de aumento salarial
- Filtragem por data de aniversário
- Agrupamento por função
- Ordenação alfabética
- Cálculo do total dos salários e salários mínimos equivalentes

## 🚀 Tecnologias Utilizadas
- **Java 17+** (ou versão compatível)
- **Java Collections API** (`List`, `Map`)
- **Java Stream API**
- **BigDecimal** (para cálculos financeiros precisos)
- **DateTimeFormatter** (para formatação de datas)

---

## 📂 Estrutura do Projeto
📦 meu-projeto ┣ 📂 src ┃ ┣ 📂 entities ┃ ┃ ┗ 📜 Employee.java ┃ ┗ 📜 Main.java ┣ 📜 README.md ┣ 📜 .gitignore



- **`Employee.java`**: Classe representando um funcionário, contendo atributos como nome, data de nascimento, salário e função.
- **`Main.java`**: Classe principal onde as operações são executadas.

---

## ⚙️ Funcionalidades
### 1️⃣ **Cadastro de Funcionários**
A lista de funcionários é inicializada com dados fictícios:

```java
List<Employee> employees = new ArrayList<>();
employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
employees.add(new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));

2️⃣ Remoção de Funcionário
Remove automaticamente o funcionário "João" da lista:

for (Employee employee : employees) {
    employee.applySalaryIncrease();
}

3️⃣ Aumento Salarial de 10%
Cada funcionário recebe um reajuste de 10% no salário:

for (Employee employee : employees) {
    employee.applySalaryIncrease();
}

4️⃣ Agrupamento por Função
Os funcionários são organizados por cargo:

Map<String, List<Employee>> employeesByFunction = employees.stream()
    .collect(Collectors.groupingBy(Employee::getFunction));

Exemplo de saída:

Função: Operador
- Maria
- Heitor

5️⃣ Filtragem de Aniversariantes (Outubro e Dezembro)
Filtra funcionários nascidos nos meses 10 e 12:

List<Employee> employeesWithBirthdays = employees.stream()
    .filter(employee -> {
        int month = employee.getDateBirth().getMonthValue();
        return month == 10 || month == 12;
    })
    .collect(Collectors.toList());

6️⃣ Ordenação Alfabética
Ordena os funcionários pelo nome:

List<Employee> sortedEmployees = employees.stream()
    .sorted(Comparator.comparing(Employee::getName))
    .collect(Collectors.toList());

7️⃣ Cálculo do Total de Salários
BigDecimal totalSalary = employees.stream()
    .map(Employee::getSalary)
    .reduce(BigDecimal.ZERO, BigDecimal::add);

Saída esperada:
Total dos salários: R$ 50.000,00

8️⃣ Cálculo de Salários Mínimos
Cada funcionário tem seu salário comparado ao mínimo nacional:
BigDecimal salarioMinimo = new BigDecimal("1212.00");

for (Employee employee : employees) {
    BigDecimal salariosMinimos = employee.getSalary().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
    System.out.println("Nome: " + employee.getName() + " | Salários Mínimos: " + salariosMinimos);
}

📌 Como Executar o Projeto
Clone o repositório

git clone https://git@github.com:EudesGomes017/PraticoInflex.git

Acesse o diretório
cd meu-projeto

Compile e execute
javac src/entities/Employee.java src/Main.java
java src/Main

