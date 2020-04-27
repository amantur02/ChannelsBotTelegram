package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParserTest{

//    private static Document getPage() throws IOException {
//        String url = "https://tlgrm.ru/channels/news";
//        Document page = Jsoup.parse(new URL(url),15000);
//        return page;
//    }
    public static List<Article> getAll() throws IOException {
        List<Article> articlList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> numberList = new ArrayList<>();
        List<String> linkList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();

        String url = "https://tlgrm.ru/channels/news";
        Document getPage = Jsoup.parse(new URL(url),3000);

        Element tableChannel = getPage.select("div[class=channel-cards-container]").first();//Беру общий доступ каналов 1 потока
        Elements h3Name = tableChannel.select("div[class=channel-card__info]");//Беру таблицу где хранятся нужные мне вещи


        Elements name = h3Name.select("h3[class=channel-card__title]");
        Elements number = h3Name.select("span[class=channel-card__subscribers]");
        Elements link = h3Name.select("a[class=channel-card__username]");
        Elements description = tableChannel.select("div[class=channel-card__description]");//Беру где хранится описание



        name.forEach(table -> {
            Element nameElement = table;
            String name0 = nameElement.text();
            nameList.add(name0);
        });
        number.forEach(table -> {
            Element numberElement = table;
            String number0 = numberElement.text();
            numberList.add(number0);
        });
        link.forEach(table -> {
            Element linkElement = table;
            String link0 = linkElement.attr("href");
            linkList.add(link0);
        });
        description.forEach(table -> {
            Element descriptionElement = table;
            String description0 = descriptionElement.text();
            descriptionList.add(description0);
        });

        for (int i = 1; i < nameList.size(); i++) {
            articlList.add(new Article(nameList.get(i),     numberList.get(i),      linkList.get(i),    descriptionList.get(i)));
        }

        return articlList;
    }
}