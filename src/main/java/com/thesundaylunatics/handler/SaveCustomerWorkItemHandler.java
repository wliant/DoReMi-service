package com.thesundaylunatics.handler;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thesundaylunatics.model.Customer;
import com.thesundaylunatics.service.CustomerService;

@Component("SaveCustomerTask")
public class SaveCustomerWorkItemHandler implements WorkItemHandler {
	
	@Autowired
	private CustomerService customerService;
	
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
    	System.out.println();
        System.out.println("Work item being executed " + workItem);
        
        Customer customer = (Customer) workItem.getParameter("param1");
        customerService.save(customer);
        manager.completeWorkItem(workItem.getId(), null);
        System.out.println();
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }
}
