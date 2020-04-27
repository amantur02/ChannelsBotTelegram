package Parser;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Article {
    private String name;
    private String number;
    private String link;
    private String description;


    public Article() {
    }

    public Article(String name, String number, String link, String description) {
        this.name = name;
        this.number = number;
        this.link = link;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "==========================" + "\n" +
                "Наименование:              " + name + '\n' +
                "Подписчики:                " + number + '\n' +
                "Ссылка:                    " + link + '\n' +
                "Описание:                  " + description + '\n' +
                "===========================";
    }
//    public String toString() {
//        return  "============================" + "\n" +
//                "Страна:                     " + country + '\n' +
//                "За все время:         " + totalCases + '\n' +
//                "Новые случаи:        " + newCases + '\n' +
//                "кол. смертей:          " + totalDeaths + '\n' +
//                "Новые смерти:       " + newDeaths + '\n' +
//                "Выздоровевшие:   " + totalRecovered + '\n' +
//                "Болеющие:              " + activeCases + '\n' +
//                "============================";
//    }
}
