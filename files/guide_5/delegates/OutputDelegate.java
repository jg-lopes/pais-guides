package com.mycompany.myapp.delegates;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.service.dto.ProcessTravelPlanDTO;

@Component
public class OutputDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ProcessTravelPlanDTO pi = (ProcessTravelPlanDTO) delegateExecution.getVariable("pi");        
        String name = pi.getDomainTravelPlan().getName();
        String airline = pi.getDomainTravelPlan().getAirlineCompanyName();
        
        System.out.println("=================================================");
        System.out.println("=============== HI WORLD!!!======================");
        System.out.println("Your name:" + name);
        System.out.println("Your chosen airline:" + airline);
        System.out.println("=================================================");
    }
}