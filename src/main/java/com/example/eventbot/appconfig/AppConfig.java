package com.example.eventbot.appconfig;

import com.example.eventbot.botconfig.MyTelegramBotConfig;
import com.example.eventbot.model.MyTelegramBot;
import com.example.eventbot.model.TelegramFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

/**
 * @author Alexander Iablonski
 */

@Configuration
public class AppConfig {
    private final MyTelegramBotConfig myTelegramBotConfig;

    public AppConfig(MyTelegramBotConfig myTelegramBotConfig) {
        this.myTelegramBotConfig = myTelegramBotConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance(){
        return SetWebhook.builder().url(myTelegramBotConfig.getWebHookPath()).build();
    }

    @Bean
    public MyTelegramBot springWebhookBot(SetWebhook setWebhook, TelegramFacade telegramFacade){
        MyTelegramBot telegramBot = new MyTelegramBot(setWebhook, telegramFacade);
        telegramBot.setBotToken(myTelegramBotConfig.getBotToken());
        telegramBot.setBotUsername(myTelegramBotConfig.getUserName());
        telegramBot.setBotPath(myTelegramBotConfig.getWebHookPath());
        return telegramBot;
    }
}
