import org.jsoup.Jsoup

const val QUOTE_SELECTOR = "article.sc-14uz67c-0.ccmjFA"

fun main() {

    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    val doc = Jsoup.connect(url).get()
    val articles = doc.select(QUOTE_SELECTOR)

    if (articles.isEmpty()) {
        println("Цитаты не найдены. Проверьте актуальность селектора.")
        return
    }

    articles.forEachIndexed { index, article ->
        val quoteText = article.text().trim().replace(Regex("\\s+"), " ")

        println("Цитата ${index + 1}:")
        println(quoteText)
        println("―".repeat(30))

    }

}