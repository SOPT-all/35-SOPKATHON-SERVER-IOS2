package jungleEscape.common.facade;

import jungleEscape.common.dto.MemberAndQuestData;
import jungleEscape.member.entity.Member;
import jungleEscape.member.service.MemberService;
import jungleEscape.quest.SynchronizedCounter;
import jungleEscape.quest.entity.Quest;
import jungleEscape.quest.service.QuestService;
import org.springframework.stereotype.Component;

@Component
public class MemberQuestFacade {
    final static int NUM_OF_QUESTS = 5;

    private final QuestService questService;
    private final MemberService memberService;
    public MemberQuestFacade(QuestService questService, MemberService memberService) {
        this.questService = questService;
        this.memberService = memberService;
    }

    public MemberAndQuestData getNewQuestAndMember(Long memberId){
        Quest quest = questService.getNewQuest();
        Member member = memberService.getMemberInfo(memberId);
        return MemberAndQuestData.fromEntity(member, quest);
    }
}
