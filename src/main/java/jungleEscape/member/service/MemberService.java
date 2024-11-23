package jungleEscape.member.service;


import jungleEscape.member.entity.Member;
import jungleEscape.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void updateScore(Integer quest_exp) {

        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        int addedExp = member.getExp() + quest_exp;
        int memberLevel = member.getLevel();

        while (true) {
            int maxExp = getMaxExpForLevel(memberLevel);

            if (addedExp >= maxExp) {
                addedExp -= maxExp;
                memberLevel++;
            } else {
                break;
            }
        }

        member.setExp(addedExp);
        member.setLevel(memberLevel);

        memberRepository.save(member);
    }

    private int getMaxExpForLevel(int level) {
        if (level == 1) {
            return 100;
        } else if (level == 2) {
            return 150;
        } else return 0;
    }
}
