package com.example.eventbot.botconfig;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Iablonski
 */

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyTelegramBotConfig {
    @Value("${telegrambot.webHookPath}")
    String webHookPath;
    @Value("${telegrambot.userName}")
    String userName;
    @Value("${telegrambot.botToken}")
    String botToken;
}
