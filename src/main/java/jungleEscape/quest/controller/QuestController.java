package jungleEscape.quest.controller;

import jungleEscape.common.dto.MemberAndQuestData;
import jungleEscape.common.dto.SuccessResponse;
import jungleEscape.common.facade.MemberQuestFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/api/v1/quests")
public class QuestController {
    private final Long MEMBER_ID = 0L;
    private final MemberQuestFacade memberQuestFacade;
    public QuestController(MemberQuestFacade memberQuestFacade) {
        this.memberQuestFacade = memberQuestFacade;
    }

    @GetMapping("/home")
    ResponseEntity<SuccessResponse<MemberAndQuestData>> getMain(){
        MemberAndQuestData memberAndQuestData = memberQuestFacade.getNewQuestAndMember(MEMBER_ID);
        return ResponseEntity.ok(SuccessResponse.success("데이터를 성공적으로 수신하였습니다.", memberAndQuestData));
    }
}
