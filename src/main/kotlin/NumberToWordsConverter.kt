import NumberToWordsConverter.convert
import java.text.NumberFormat
import java.util.*


object NumberToWordsConverter {
    val units = arrayOf(
        "ი", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი", "ექვსი", "შვიდი", "რვა", "ცხრა", "ათი", "თერთმეტი",
        "თორმეტი", "ცამეტი", "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი",
        "ასი"
    )
    val tens = arrayOf(
        "", "", "ოცი", "ოცდაათი", "ორმოცი", "ორმოცდაათი", "სამოცი", "სამოცდაათი", "ოთხმოცი", "ოთხმოცდაათი"
    )

    fun convert(n: Int): String {
        if (n < 0) {
            return "Minus " + convert(-n)
        }
        if (n < 20) {
            return units[n]
        }
        if (n < 100) {
            return tens[n / 10] + (if (n % 10 != 0) "და" else "") + units[n % 10]
        }
        if (n in 100..199) {
            return  "ას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 200..299) {
            return  "ორას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 300..399) {
            return  "სამას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 400..499) {
            return  "ოთხას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 500..599) {
            return  "ხუთას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 600..699) {
            return  "ექვსას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        if (n in 700..799) {
            return  "შვიდას" + (if (n % 100 != 0) " " else "") + convert(n % 100)
        }
        if (n in 800..899) {
            return  "რვაას" + (if (n % 100 != 0) "" else "") + convert(n % 100)
        }
        return if (n in 900..999) {
            "ცხრაას" + (if (n % 100 != 0) "" else "") + convert(
                n % 100
            )
        } else return ("out of limit").toString()

    }

}


fun main() {
    val n: Int
    val s = Scanner(System.`in`)
    println("შეიყვანეთ ციფრი რომლის დაკონვერტირებაც გინდათ:")
    n = s.nextInt()
    println(NumberFormat.getInstance().format(n) + "='"+convert(n ) +  "'")
}