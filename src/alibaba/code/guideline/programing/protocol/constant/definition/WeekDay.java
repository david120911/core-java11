package alibaba.code.guideline.programing.protocol.constant.definition;

public enum WeekDay {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);


    private Integer number;

    WeekDay(Integer number) {
        this.number = number;
    }
}
