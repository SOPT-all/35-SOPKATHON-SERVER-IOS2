package jungleEscape.common.dto;

public class MaxExpPerLevelMapper {

    public static Integer getMaxExp(Integer level) {
        return level == 1 ? 100 : 150;
    }

}
