package my.course.project.fraud.repository;

import my.course.project.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FraudCheckHistoryRepository  extends JpaRepository<FraudCheckHistory, Integer> {
}
