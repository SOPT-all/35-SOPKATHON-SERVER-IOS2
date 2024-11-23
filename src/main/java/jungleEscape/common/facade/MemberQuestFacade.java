package jungleEscape.common.facade;

import jungleEscape.quest.entity.Quest;
import jungleEscape.quest.service.QuestService;
import org.springframework.stereotype.Component;

@Component
public class MemberQuestFacade {
    private final QuestService questService;
    public MemberQuestFacade(QuestService questService) {
        this.questService = questService;
    }

    void getNewQuestAndMember(){
        Quest quest = questService.getNewQuest();
//        Member member =
    }
}
