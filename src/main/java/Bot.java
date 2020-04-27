import Parser.Article;
import Parser.ParserTest;
import Parser.ParserTest2;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import java.util.logging.Level;

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
        }else if (text.equals("/news")) {
            sendMsg(msg, "Вывожу статистику:");
            for (int i = 0; i < 10; i++)
                sendMsgReply10Channel(msg, ParserTest2.getAllChannel().toString());
        }else {
            sendMsgReply10Channel(msg, "У меня не получатеся");
        }
//        String message = update.getMessage().getText();
//        sendMsg(update.getMessage().getChatId().toString(), message);
//        if (message.equals("/help")){
//            sendMsg(message,"Чем могу помочь");
//        }else {
//            sendMsg(message," Все работает");
//        }
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