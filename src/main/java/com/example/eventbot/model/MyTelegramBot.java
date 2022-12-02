package com.example.eventbot.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

/**
 * @author Alexander Iablonski
 */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyTelegramBot extends SpringWebhookBot {
    // Webhook address on Heroku
    String botPath;
    String botUsername;
    String botToken;
    // Message handling
    TelegramFacade telegramFacade;

    public MyTelegramBot(SetWebhook setWebhook, TelegramFacade telegramFacade) {
        super(setWebhook);
        this.telegramFacade = telegramFacade;
    }

    public MyTelegramBot(DefaultBotOptions options, SetWebhook setWebhook, TelegramFacade telegramFacade) {
        super(options, setWebhook);
        this.telegramFacade = telegramFacade;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return telegramFacade.handleUpdate(update);
    }
}
