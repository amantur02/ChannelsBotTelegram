import Parser.ParserTest2;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String text = msg.getText();
        if (text.equals("/start")) {
            sendMsg(msg, "Hello, world! This is simple bot!");
        }else if (text.equals("/channels")){
            sendMsg(msg,"Категория каналов для Telegram:" + "\n" +
                    "Новости и СМИ____________ /news" + "\n" +
                    "Блоги_____________________ /blogs" + "\n" +
                    "Технологии________________ /tech" + "\n" +
                    "Юмор________________ /entertainment" + "\n" +
                    "Политика и экономика_____ /economics" + "\n" +
                    "Криптоволюты______________ /crypto" + "\n" +
                    "Наука и образования_______ /education" + "\n" +
                    "Музыка___________________ /music" + "\n" +
                    "Лингвистика_______________ /language" + "\n" +
                    "Бизнесы и стартапы_________ /business" + "\n" +
                    "Психология_________ /psychology" + "\n" +
                    "Маркетинг и реклама___ /marketing" + "\n" +
                    "Карьера____________________ /career" + "\n" +
                    "Фильмы и сериалы_____________ /video" + "\n" +
                    "Литература___________________ /books" + "\n" +
                    "Здоровье и спорт_____________ /fitness" + "\n" +
                    "Путишествия и эмиграция______ /travel" + "\n" +
                    "Искусство и фото_____________ /art" + "\n" +
                    "Мода и красота_______________ /beauty" + "\n" +
                    "Медицина_____________________ /health" + "\n" +
                    "Игры и приложения______ /gaming" + "\n" +
                    "Еда и напитки________________ /food" + "\n" +
                    "Продажи______________________ /sales" + "\n" +
                    "Цитаты_______________________ /quotes" + "\n" +
                    "Рукоделие_____________ /handicraft" + "\n" +
                    "18+__________________________ /adult" + "\n" +
                    "Другое_______________________ /other" + "\n");
        }else if (text.equals("/news") || text.equals("/blogs") || text.equals("/tech")
        || text.equals("/entertainment") || text.equals("/economics") || text.equals("/crypto")
        || text.equals("/education") || text.equals("music") || text.equals("/language")
        || text.equals("/business") || text.equals("/psychology") || text.equals("/marketing")
        || text.equals("/career") || text.equals("/video") || text.equals("/books")
        || text.equals("/fitness") || text.equals("/travel") || text.equals("/art")
        || text.equals("/beauty") || text.equals("/health") || text.equals("/gaming")
        || text.equals("/food") || text.equals("/sales") || text.equals("/quotes")
        || text.equals("/handicraft") || text.equals("/adult") || text.equals("/other")) {
            for (int i = 1; i <= 10; i++)
                sendMsg(msg, ParserTest2.getAllChannel(text).get(i).toString());
            sendMsg(msg, "/ten");
//            if (text.equals("/Еще 10"))
//                for (int i = 11; i <= 20; i++)
//                    sendMsg(msg, ParserTest2.getAllChannel(text).get(i).toString());
        }

    }
    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }


    public void sendMsgReply10Channel(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }



    @Override
    public String getBotUsername() {
        return "Telegram_channel_Bot";
    }

    @Override
    public String getBotToken() {
        return "1133739275:AAESbrWT4_xSyv_UkgYBzefx5PDBEKePYQs";
    }
}