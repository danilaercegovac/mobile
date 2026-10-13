import kotlin.math.sqrt
import kotlin.math.cos
import kotlin.math.roundToInt
data class MobileDevice(val model: String, val releaseYear: Int, val storage: Int)
fun main() {
    // 1
    val firstPart = "Swift makes"
    val secondPart = "sense"

    println(firstPart + " " + secondPart + "!")
    println("$firstPart $secondPart!")

    // 2

    val currentAge = 23
    val ageAfterSevenYears = currentAge + 7
    val averageDaysInYear = 365.2425
    val estimatedDaysPassed = (ageAfterSevenYears * averageDaysInYear).toFloat()
    println(
        "Сейчас мне $currentAge лет. " +
                "Через 7 лет мне будет $ageAfterSevenYears лет. " +
                "К этому моменту с рождения пройдет примерно ${estimatedDaysPassed.toInt()} дней."
    )

    // 3

    val a = 7.25f
    val b = 18.6f

    val sumAsFloatThenDouble = (a + b).toDouble()
    val sumAsDoubleOperands = a.toDouble() + b.toDouble()

    println("Результат 1 (Float → Double): $sumAsFloatThenDouble")
    println("Результат 2 (Double операнды): $sumAsDoubleOperands")

    /*
     * Почему результаты могут отличаться:
     * Float хранит числа с меньшей точностью (примерно 6–7 значащих цифр),
     * а Double — с большей (примерно 15–16 значащих цифр).
     * В первом случае ошибка округления возникает уже на этапе сложения в Float,
     * и затем это неточное значение просто приводится к Double.
     * Во втором случае оба числа сразу представлены в Double, поэтому сложение
     * выполняется с более высокой точностью.
     */

    // 4

    val AB = 9.0
    val BC = 12.0
    val gipo = sqrt(AB*AB + BC*BC)
    val S = AB*BC/2
    val P = AB+BC+gipo
    print("Гипотенуза: $gipo\nПлощадь: $S\nПериметр: $P\n")

    // 5

    val totalItems = 10
    val boxesCount = 5
    val result = totalItems / boxesCount
    val remainder = totalItems % boxesCount

    println("При распределении $totalItems элементов по $boxesCount коробкам в каждую попадет $result, останется $remainder.")
    println("$totalItems / $boxesCount = $result $remainder/$boxesCount")

    // 6

    val startDay = 31
    val startMonth = 7
    val startYear = 2003

    val currentDay = 17
    val currentMonth = 9
    val currentYear = 2026

    val daysInMonth = 30
    val daysInYear = 360
    val hoursInDay = 24
    val minutesInHour = 60
    val secondsInMinute = 60

    val startTotalDays = startYear * daysInYear + startMonth * daysInMonth + startDay
    val currentTotalDays = currentYear * daysInYear + currentMonth * daysInMonth + currentDay

    val diffDays = currentTotalDays - startTotalDays

    val years = diffDays / daysInYear
    val remainingAfterYears = diffDays % daysInYear

    val months = remainingAfterYears / daysInMonth
    val remainingAfterMonths = remainingAfterYears % daysInMonth

    val totalSeconds = diffDays * hoursInDay * minutesInHour * secondsInMinute

    println(
        "С указанной даты прошло: $years лет, $months месяцев, $remainingAfterMonths дней и $totalSeconds секунд."
    )

    // 7

    val month = 9

    if (month < 1 || month > 12) {
        println("Ошибка: номер месяца должен находиться в диапазоне от 1 до 12.")
    } else if (month >= 1 && month <= 3) {
        println("I квартал")
    } else if (month >= 4 && month <= 6) {
        println("II квартал")
    } else if (month >= 7 && month <= 9) {
        println("III квартал")
    } else {
        println("IV квартал")
    }

    // 8

    val x = 2.0
    val cosValue = cos(x)

    val roundedArith = (cosValue * 10000.0).roundToInt() / 10000.0
    println("Округление арифметикой: $roundedArith")

    val formatted = String.format("%.4f", cosValue)
    println("Форматированный вывод: $formatted")

    // 9

    val device = MobileDevice(model = "Pixel 8", releaseYear = 2023, storage = 128)

    println("Модель: ${device.model}")
    println("Год выпуска: ${device.releaseYear}")
    println("Память: ${device.storage} ГБ")

    println("${device.model}, ${device.releaseYear} год, ${device.storage} ГБ")

    // 10

    fun checkAccess(
        hasStudentID: Boolean,
        hasScheduledClass: Boolean,
        safetyBriefingPassed: Boolean,
        isInstructor: Boolean
    ) {
        val canEnterLab = hasStudentID &&
                (isInstructor || (hasScheduledClass && safetyBriefingPassed))

        println(
            "hasStudentID=$hasStudentID, " +
                    "hasScheduledClass=$hasScheduledClass, " +
                    "safetyBriefingPassed=$safetyBriefingPassed, " +
                    "isInstructor=$isInstructor → " +
                    "Доступ разрешен: $canEnterLab"
        )
    }

    // 1. Обычный студент: всё есть → должен пройти
    checkAccess(true, true, true, false)

    // 2. Обычный студент: нет инструктажа → не должен пройти
    checkAccess(true, true, false, false)

    // 3. Преподаватель: есть ID, остальное не важно → должен пройти
    checkAccess(true, false, false, true)

    // 4. Человек без студенческого ID (даже если преподаватель) → не должен пройти
    checkAccess(false, true, true, true)
}
