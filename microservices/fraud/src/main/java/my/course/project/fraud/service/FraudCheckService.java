package my.course.project.fraud.service;

import java.time.LocalDateTime;
import my.course.project.fraud.model.FraudCheckHistory;
import my.course.project.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
            FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .isFraudster(false)
                .build()
        );
        return false;
    }
}
