package meelesh.polyMobileAppBackend.service;

import meelesh.polyMobileAppBackend.dto.request.ExpressionDTO;
import meelesh.polyMobileAppBackend.entity.History;
import meelesh.polyMobileAppBackend.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    private final HistoryRepository historyRepository;

    public CalculatorService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    public void saveHistory(String username, ExpressionDTO expression) {
        History history = new History(username, expression.getExpression());
        historyRepository.save(history);
    }

    public List<History> getHistory(String username) {
        return historyRepository.findByUsername(username);
    }

}
