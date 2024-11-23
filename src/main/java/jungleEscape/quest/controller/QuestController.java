package jungleEscape.quest.controller;

import jungleEscape.common.dto.MemberAndQuestData;
import jungleEscape.common.dto.SuccessResponse;
import jungleEscape.common.facade.MemberQuestFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestController {
    private final Long MEMBER_ID = 1L;
    private final MemberQuestFacade memberQuestFacade;
    public QuestController(MemberQuestFacade memberQuestFacade) {
        this.memberQuestFacade = memberQuestFacade;
    }

    @GetMapping("/api/v1/quests/home")
    ResponseEntity<SuccessResponse<MemberAndQuestData>> getMain(){
        MemberAndQuestData memberAndQuestData = memberQuestFacade.getNewQuestAndMember(MEMBER_ID);
        return ResponseEntity.ok(SuccessResponse.success("데이터를 성공적으로 수신하였습니다.", memberAndQuestData));
    }
}
