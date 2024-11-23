package jungleEscape.member.controller;

import jungleEscape.common.dto.SuccessResponse;
import jungleEscape.member.dto.ExpRequest;
import jungleEscape.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("v1/members/success")
    public ResponseEntity<SuccessResponse<?>> updateScore(@RequestBody ExpRequest expRequest){
        memberService.updateScore(expRequest.getQuest_exp());
        return ResponseEntity.ok(SuccessResponse.success("경험치가 증가하였습니다."));
    }
}
