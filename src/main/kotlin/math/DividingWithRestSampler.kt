package math

import java.io.File
import kotlin.random.Random

fun main(args: Array<String>) {
    val pw = File("/tmp/output.csv").printWriter()
    val dividends = listOf(2,3,4)
    val divisors = DividingWithRestSampler.generateDivisors()
    DividingWithRestSampler.generateSamples(dividends, divisors).forEach(pw::write)
    pw.flush()
    pw.close()
}

data class Sample(val simple: String, val extended: String)

object DividingWithRestSampler {

    fun random(from: Int, to: Int): Int =
        Random.nextInt(from, to)


    fun generateSamples(dividends: List<Int>, divisors: List<Int>): List<String> =
        dividends
            .flatMap { f -> divisors.map { Pair(f, it) } }
            .map { p -> generateSample(p) }
            .shuffled()
            .map { "${it.simple}\t${it.extended}\n" }


    private fun generateSample(p: Pair<Int, Int>): Sample {
        val rest = random(0, p.second)
        return Sample(generateSimpleSample(p.first, p.second, rest), generateExtendedSample(p.first, p.second, rest))
    }

    private fun generateSimpleSample(dividend: Int, divisor: Int, rest: Int): String {
        return "${dividend * divisor + rest} : $divisor = "
    }

    private fun generateExtendedSample(dividend: Int, divisor: Int, rest: Int): String {
        return "${dividend * divisor + rest} : $divisor = $dividend (ост: $rest)  [$dividend * $divisor = ${dividend * divisor}]"
    }

    fun generateDivisors(): List<Int> {
        // return listOf(2,3,4,5,6,7,8,9,6,7,8,9)
        return (2 .. 20).map { random(11, 50) }
    }

}