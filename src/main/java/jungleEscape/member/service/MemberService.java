package jungleEscape.member.service;

import jungleEscape.member.entity.Image;
import jungleEscape.member.entity.Member;
import jungleEscape.member.repository.ImageRepository;
import jungleEscape.member.repository.MemberRepository;
import jungleEscape.quest.entity.Quest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MemberService {
    final private MemberRepository memberRepository;
    final private ImageRepository imageRepository;
    public MemberService(MemberRepository memberRepository, ImageRepository imageRepository) {
        this.memberRepository = memberRepository;
        this.imageRepository = imageRepository;
    }

    public Member getMemberInfo(Long memberId){
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isEmpty()){
            throw new RuntimeException();
        }
        Integer level = member.get().getLevel();
        Optional<Image> imgUrl = imageRepository.findByLevel(level);
        if(imgUrl.isEmpty()){
            throw new RuntimeException();
        }
        member.get().setImgUrl(imgUrl.get().getImage());
        return member.get();
    }

}