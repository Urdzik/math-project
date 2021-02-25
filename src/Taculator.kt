import kotlin.math.pow
import java.text.DecimalFormat

object Taculator {

    fun plus(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data + b_data
    }

    fun minus(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data - b_data
    }

    fun multiply(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data * b_data
    }

    fun share(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data / b_data
    }

    fun sqrt(a: Number, b: Number = 2.0): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data.pow(1 / b_data)
    }

    fun degree(a: Number, b: Number = 2.0): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data.pow(b_data)
    }

    fun frac(a: Number): String {
        val a_data: Double = a.toDouble()
        if (a_data < 0) {
            return "-" + frac(-a_data)
        }
        val tolerance = 1.0E-6
        var h1 = 1.0
        var h2 = 0.0
        var k1 = 0.0
        var k2 = 1.0
        var b = a_data
        do {
            val x = Math.floor(b)
            var aux = h1
            h1 = x * h1 + h2
            h2 = aux
            aux = k1
            k1 = x * k1 + k2
            k2 = aux
            b = 1 / (b - x)
        } while (Math.abs(a_data - h1 / k1) > a_data * tolerance)
        return "${h1.toInt()}/${k1.toInt()}"
    }

    fun dec(s: String): Number {
        val a_data = s.split("/")[0].toDouble()
        val b_data = s.split("/")[1].toDouble()
        return a_data / b_data
    }

    fun abs(a: Number): Number {
        return kotlin.math.abs(a.toDouble())
    }

    fun round(a: Number, b: Int): Number {
        val a_data: Double = a.toDouble()
        val b_data: Int = b
        val df: DecimalFormat
        var dfPattern = "#"
        if (b_data == 0) {
            df = DecimalFormat(dfPattern)
        } else {
            dfPattern = "#."
            for (i in 1..b_data) {
                dfPattern += "#"

            }
            df = DecimalFormat(dfPattern)
        }

        return df.format(a_data).replace(',', '.').toDouble()
    }

    fun iPart(a: Number): String {
        val s = a.toString()
        val a_data = s.split(".")[0]
        return a_data
    }

    fun fPart(a: Number): String {
        val s = a.toString()
        val a_data = s.split(".")[1]
        return ".$a_data"
    }

    fun int(a: Number): Number {
        val a_data: Double = a.toDouble()
        return Math.ceil(a_data).toInt()
    }

    fun min(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return Math.min(a_data, b_data)
    }

    fun min(a: List<Number>, b: Number): Number {
        val a_data: List<Double> = a.map { it.toDouble() }
        val b_data: Double = b.toDouble()
        val a_min = a_data.minOrNull()
        // TODO fix error if a_min == null
        return Math.min(a_min!!, b_data)
    }

    fun min(a: List<Number>): Number {
        val a_data: Double? = a.map { it.toDouble() }.minOrNull()
        // TODO fix error if a_data == null
        return a_data!!
    }

    fun max(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return Math.max(a_data, b_data)
    }

    fun max(a: List<Number>, b: Number): Number {
        val a_data: List<Double> = a.map { it.toDouble() }
        val b_data: Double = b.toDouble()
        val a_min = a_data.maxOrNull()
        // TODO fix error if a_min == null
        return Math.max(a_min!!, b_data)
    }

    fun max(a: List<Number>): Number {
        val a_data: Double? = a.map { it.toDouble() }.maxOrNull()
        // TODO fix error if a_data == null
        return a_data!!
    }

    fun lsm(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        if (a_data == 0.0 || b_data == 0.0) {
            return 0
        }
        val absNumber1 = Math.abs(a_data)
        val absNumber2 = Math.abs(b_data)
        val absHigherNumber = Math.max(absNumber1, absNumber2)
        val absLowerNumber = Math.min(absNumber1, absNumber2)
        var lcm = absHigherNumber
        while (lcm % absLowerNumber != 0.0) {
            lcm += absHigherNumber
        }
        return lcm
    }

    fun gcd(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        var gcd = 1.0
        var i = 1.0
        while (i <= a_data && i <= b_data) {
            if (a_data % i == 0.0 && b_data % i == 0.0) {
                gcd = i
            }
            i++
        }
        return gcd
    }

    fun remainder(a: Number, b: Number): Number {
        val a_data: Double = a.toDouble()
        val b_data: Double = b.toDouble()
        return a_data % b_data
    }

    fun conj(s: String): String {
        val listOfAllNumber = mutableListOf<String>()
        val listOfComplexNumber = mutableListOf<String>()
        val listOfSimpleNumber = mutableListOf<String>()

        var simple = 0.0
        var simpleExample = ""
        var simpleResult = ""
        var complex = 0.0
        var complexExample = ""
        var complexResult = ""
        var example = ""
        var numberInStr = ""
        var result = ""

        s.forEachIndexed { index, c ->
            if (index != s.length - 1) {
                if (numberInStr.isNotEmpty() && (c != '-' || c != '+')) {
                    if (c != '-' && c != '+' && c != '*' && c != '/') {
                        numberInStr += c
                    } else {
                        if (numberInStr.isNotEmpty()) {
                            listOfAllNumber.add(numberInStr)
                        }
                        if (c != '*' || c != '/') {
                            numberInStr = c.toString()
                        }
                    }
                } else {
                    numberInStr += c
                }
            } else {
                numberInStr += c
                listOfAllNumber.add(numberInStr)
                numberInStr = ""
            }
        }

        listOfAllNumber.forEach {
            val data = it.find { it == 'i' }
            if (data == null) {
                listOfSimpleNumber.add(it)
            } else {
                listOfComplexNumber.add(it)
            }
        }

        listOfComplexNumber.forEach {
            val data = it.removeSuffix("i")
            complexExample += data
        }

        listOfSimpleNumber.forEach {
            simpleExample += it
        }

        if (complexExample[0] == '+' || complexExample[0] == '/' || complexExample[0] == '*') {
            example = complexExample[0].toString()
            val data = complexExample.removePrefix(complexExample[0].toString())
            complexExample = data
        } else if (complexExample[0] == '-'){
            complexExample = ""
            listOfComplexNumber.forEachIndexed { index, s ->
                var data = s.removeSuffix("i")
                if (index == 0){
                    data = "(" + data + ")"
                }
                complexExample += data
            }

        }

        if (simpleExample[0] == '+' || simpleExample[0] == '/' || simpleExample[0] == '*') {
            val data = simpleExample.removePrefix(simpleExample[0].toString())
            simpleExample = data
        }

        complex = DynamicCalculator.calculate(complexExample)
        simple = DynamicCalculator.calculate(simpleExample)

        complexResult = if (complex > 0) {
            "-$complex"
        } else {
            "$complex"
        }

        simpleResult = "$simple"

        result = if (example == "*" || example == "/") {
            DynamicCalculator.calculate("($simpleResult)$example($complexResult)").toString() + "i"
        } else {
            simpleResult + complexResult + "i"
        }


        return result
    }


}

