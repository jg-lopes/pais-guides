package com.mycompany.myapp.delegates;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class WorldDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        
        System.out.println("=================================================");
        System.out.println("================== World! =======================");
        System.out.println("=================================================");
    }
}