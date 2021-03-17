import java.io.BufferedReader
import java.util.*
import kotlin.properties.Delegates


fun main() {
//    val employeeOne = DepartmentChanges("Albert")
//    employeeOne.dept = "R&D"
//    employeeOne.dept = "Sales"

//    val employeeTwo = EmployeeManager("Albert", "Sales", "Sales")
//    println(employeeTwo.salary)
//    println(employeeTwo.empNum)
//    println(120_000_000*12)

    val employeeThree = EmployeeManager("Charles", "R&D", "Sales")
    print("${employeeThree.name}은 ${employeeThree.department}에서 " +
            "일하는 ${employeeThree.empType}직원이며 \n 한달 월급은 ${employeeThree.salary}입니다\n" +
            "사번은${employeeThree.empNum}입니다.")


}

enum class DeptName(var deptCode: Int, var deptName: String) {
    ADMINISTRATIVE(1000, "administrative"),
    CUSTOMER_SUPPORT(1010, "customerService"),
    SALES(1020, "sales"),
    RESEARCH_DEVELOPMENT(1030, "R&D")
}

class DepartmentChanges(val name: String) {
    var dept: String by Delegates.observable(
        "Old Dept:", { _, oldDept, newDept ->
            println("$name 의 이전부서:$oldDept, 현재부서$newDept")
        }
    )
}

class CreateUUID{
    companion object{
        fun createUUID()=UUID.randomUUID().toString()
    }
}


class EmployeeManager(name: String, department: String, empType: String) {
    var name = ""
    var department = ""
    var empNum = ""
    var empType = ""
    var salary = 0

    init {
        this.name = name
        this.department = department
        this.empType = empType
        this.empNum = CreateUUID.createUUID()
        this.salary = employeeSalary()

    }

    fun employeeSalary(): Int {
        var hoursWorked: Int = 80
        var salesBasePay: Int = 45_000_000
        var PTBasePay: Int = 25_000
        val salary = when (empType) {
            "FullTime" -> 120_000_000/12
            "PartTime" -> PTBasePay * hoursWorked
            "Sales" -> (salesBasePay * 105) / 1200
            else -> 0
        }
        return salary
    }
}




