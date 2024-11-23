package jungleEscape.common.facade;

import jungleEscape.common.dto.MemberAndQuestData;
import jungleEscape.member.entity.Member;
import jungleEscape.member.service.MemberService;
import jungleEscape.quest.entity.Quest;
import jungleEscape.quest.service.QuestService;
import org.springframework.stereotype.Component;

@Component
public class MemberQuestFacade {
    private final QuestService questService;
    private final MemberService memberService;
    public MemberQuestFacade(QuestService questService, MemberService memberService, MemberService memberService1) {
        this.questService = questService;
        this.memberService = memberService1;
    }

    public MemberAndQuestData getNewQuestAndMember(Long memberId){
        Quest quest = questService.getNewQuest();
        Member member = memberService.getMemberInfo(memberId);
        return MemberAndQuestData.fromEntity(member, quest);
    }
}
