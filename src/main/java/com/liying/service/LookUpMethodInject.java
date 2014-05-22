package com.liying.service;


public abstract class LookUpMethodInject {

    public Object process(int i) {
        CommandService command = createCommand();
        command.setStatust(i);
        return command.execute();
    }

    public abstract CommandService createCommand();

}
