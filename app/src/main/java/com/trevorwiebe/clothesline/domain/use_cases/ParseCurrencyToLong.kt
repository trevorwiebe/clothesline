package com.trevorwiebe.clothesline.domain.use_cases

class ParseCurrencyToLong() {
    operator fun invoke(amount: String): Long {
        val formattedAmount = amount.replace("""[$,.]""".toRegex(), "")
        return formattedAmount.toLong()
    }
}