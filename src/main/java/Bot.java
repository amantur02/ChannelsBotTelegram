import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }


    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try{
            sendMessage(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
        String name = "Hello";
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message !=null && message.hasText()){
            if (message.equals(name)){
                sendMsg(message,"Привет");
            }
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