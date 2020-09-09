package by.uniqo.telegrambot.enums;


public enum BotCommand {
    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    NONE("/none"),
    MAGIC_BALL("/magicBall"),
    UNIVERSAL_SPEECH_CODE("/speech");

    String command;
    public String getCommand() {
        return command;
    }

    BotCommand(String command) {
        this.command = command;
    }

}
