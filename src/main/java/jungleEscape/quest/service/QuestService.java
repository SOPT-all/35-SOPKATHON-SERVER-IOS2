package jungleEscape.quest.service;

import jungleEscape.quest.SynchronizedCounter;
import jungleEscape.quest.entity.Quest;
import jungleEscape.quest.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestService {

    final private SynchronizedCounter counter;
    final private QuestRepository questRepository;
    public QuestService(SynchronizedCounter counter, QuestRepository questRepository) {
        this.counter = counter;
        this.questRepository = questRepository;
    }

    public Quest getNewQuest(){
        Optional<Quest> quest = questRepository.findById((long) counter.getCounter());
        if(quest.isEmpty()){
            throw new RuntimeException();
        }
        return quest.get();
    }

}
