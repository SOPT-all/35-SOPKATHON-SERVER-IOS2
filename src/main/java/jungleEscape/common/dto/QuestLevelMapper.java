package jungleEscape.common.dto;

public class QuestLevelMapper {

    public static String getLevelString(int level) {
        switch (level) {
            case 1:
                return "초급";
            case 2:
                return "중급";
            case 3:
                return "고급";
            default:
                return "Unknown";
        }
    }

}
