package alibaba.code.guideline.programing.protocol.collection;

public class OverrideEquals {

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
