package jungleEscape.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jungleEscape.member.entity.Member;
import jungleEscape.quest.entity.Quest;

public record MemberAndQuestData(
        @JsonProperty("member_level") String memberLevel,
        @JsonProperty("member_exp") String memberExp,
        @JsonProperty("member_img_url") String memberImgUrl,
        @JsonProperty("quest_name") String questName,
        @JsonProperty("quest_summary") String questSummary,
        @JsonProperty("quest_level") String questLevel,
        @JsonProperty("quest_exp") int questExp,
        @JsonProperty("quest_description") String questDescription
) {
    public static MemberAndQuestData fromEntity(Member member, Quest quest) {
        String memberLevel = "Lv. " + member.getLevel();
        String memberExp = member.getExp() + "/" + member.getLevel();
        String memberImgUrl = member.getImgUrl();
        String questSummary = quest.getSummary();
        String questName = quest.getName();
        String questLevel = String.valueOf(quest.getLevel());
        int questExp = quest.getExp();
        String questDescription = quest.getDescription();

        return new MemberAndQuestData(
                memberLevel,
                memberExp,
                memberImgUrl,
                questName,
                questSummary,
                questLevel,
                questExp,
                questDescription
        );
    }
}
