import org.jsoup.Jsoup

fun main() {

    val url = "https://mybook.ru/author/duglas-adams/avtostopom-po-galaktike-restoran-u-konca-vselennoj/citations/"

    val doc = Jsoup.connect(url).get()
    val articles = doc.select("div.sc-2aegk7-2.bzpNIu")

    if (articles.isEmpty()) {
        println("Цитаты не найдены. Проверьте актуальность селектора.")
        return
    }

    articles.forEachIndexed { index, article ->
        val quoteText = article.select("div.sc-2aegk7-2.bzpNIu").text().trim().replace(Regex("\\s+"), " ")

        println("Цитата ${index + 1}:")
        println(quoteText)
        println("―".repeat(30))

    }

}