package by.uniqo.telegrambot.processor;

import org.springframework.stereotype.Service;

@Service
public class NoneProcessor implements Processor {

    @Override
    public String run() {
        return "Unexpected command";
    }
}