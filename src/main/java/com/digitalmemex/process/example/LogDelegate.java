package com.digitalmemex.process.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LogDelegate implements JavaDelegate {

    private Logger logger = Logger.getLogger(getClass().getName());

    public void execute(DelegateExecution execution) throws Exception {
        logger.info(">>> >>> >>> CHECK THIS EXAMPLE <<< <<< <<<");
    }

}