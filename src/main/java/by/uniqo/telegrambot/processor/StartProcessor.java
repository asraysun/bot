package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class StartProcessor implements Processor {

    @Override
    public String run() {
        return "Nothing you can start now, sorry...";
    }
}