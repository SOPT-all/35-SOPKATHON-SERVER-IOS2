package jungleEscape.quest.service;

import jungleEscape.quest.SynchronizedCounter;
import jungleEscape.quest.entity.Quest;
import jungleEscape.quest.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestService {
    final static int NUM_OF_QUESTS = 5;
    final private SynchronizedCounter counter = new SynchronizedCounter(NUM_OF_QUESTS*3);

    final private QuestRepository questRepository;
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public Quest getNewQuest(){
        Optional<Quest> quest = questRepository.findById((long) counter.getCounter());
        if(quest.isEmpty()){
            throw new RuntimeException();
        }
        counter.incrementAndSet();
        return quest.get();
    }

}
