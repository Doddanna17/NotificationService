package com.doddanna.NotificationSystem;

import com.doddanna.NotificationSystem.enums.NotificationOperationType;
import com.doddanna.NotificationSystem.enums.NotificationRequestStatus;
import com.doddanna.NotificationSystem.models.NotificationRequest;
import com.doddanna.NotificationSystem.repository.NotificationRequestRepository;
import com.doddanna.NotificationSystem.service.NotificationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class NotificationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSystemApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(@Autowired NotificationRequestRepository notificationRequestRepository, @Autowired NotificationGroupService notificationGroupService){
		return args -> {
			List<NotificationRequest> all = notificationRequestRepository.findAll();
			System.out.println("all : "+all.size());
			List<NotificationRequest> notificationRequests = setUpSomeData();
			notificationRequests.stream().forEach(x->{
				notificationGroupService.processNotification(x);
			});
		};
	}

	private List<NotificationRequest> setUpSomeData(){
		List<NotificationRequest> notificationRequests=new ArrayList<>();
		notificationRequests.add(NotificationRequest
				.builder()
						.emails(Arrays.asList("user1@users.com","user2@users.com"))
						.notificationOperationTypes(Arrays.asList(NotificationOperationType.BITCOIN_PRICE_CHANGES))
						.status(NotificationRequestStatus.DELIVERED)
				.build());
		notificationRequests.add(NotificationRequest
				.builder()
				.emails(Arrays.asList("user4@users.com","user234@users.com"))
				.notificationOperationTypes(Arrays.asList(NotificationOperationType.TRADING_VOLUME))
				.status(NotificationRequestStatus.FAILED)
				.build());
		notificationRequests.add(NotificationRequest
				.builder()
				.emails(Arrays.asList("user1dkf@users.com","slkdjuser2@users.com"))
				.notificationOperationTypes(Arrays.asList(NotificationOperationType.TRADING_VOLUME))
				.status(NotificationRequestStatus.DELIVERED)
				.build());
		return notificationRequests;
	}


}
