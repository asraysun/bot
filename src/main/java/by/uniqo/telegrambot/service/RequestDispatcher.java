package by.uniqo.telegrambot.service;


import by.uniqo.telegrambot.enums.BotCommand;
import by.uniqo.telegrambot.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class RequestDispatcher {
    @Autowired
    MessageService messageService;
    @Autowired
    HelpProcessor helpProcessor;
    @Autowired
    SettingsProcessor settingsProcessor;
    @Autowired
    StartProcessor startProcessor;
    @Autowired
    NoneProcessor noneProcessor;
    @Autowired
    MagicBallProcessor magicBallProcessor;
    @Autowired
    UniversalSpeechCodeProcessor universalSpeechCodeProcessor;

    public void dispatch(Update update) {
        switch (getCommand(update)) {
            case HELP:
                messageService.sendMessage(update.getMessage(), helpProcessor.run());
                break;
            case START:
                messageService.sendMessage(update.getMessage(), startProcessor.run());
                break;
            case SETTING:
                messageService.sendMessage(update.getMessage(), settingsProcessor.run());
                break;
            case NONE:
                messageService.sendMessage(update.getMessage(), noneProcessor.run());
                break;
            case MAGIC_BALL:
                messageService.sendMessage(update.getMessage(),  magicBallProcessor.run());
                break;
            case UNIVERSAL_SPEECH_CODE:
                messageService.sendMessage(update.getMessage(), universalSpeechCodeProcessor.run());
                break;
        }
    }

    private BotCommand getCommand(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                String msgText = message.getText();
                if (msgText.startsWith(BotCommand.HELP.getCommand())) {
                    return BotCommand.HELP;
                } else if (msgText.startsWith(BotCommand.START.getCommand())) {
                    return BotCommand.START;
                } else if (msgText.startsWith(BotCommand.SETTING.getCommand())) {
                    return BotCommand.SETTING;
                }else if (msgText.startsWith(BotCommand.MAGIC_BALL.getCommand())) {
                    return BotCommand.MAGIC_BALL;
                }else if (msgText.startsWith(BotCommand.UNIVERSAL_SPEECH_CODE.getCommand())) {
                    return BotCommand.UNIVERSAL_SPEECH_CODE;
                }
            }
        }
        return BotCommand.NONE;
    }
}
