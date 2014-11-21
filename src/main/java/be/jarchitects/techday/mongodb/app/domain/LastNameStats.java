package be.jarchitects.techday.mongodb.app.domain;

/**
* Created by tom on 21/11/14.
*/
public class LastNameStats {
    private String id;
    private Integer count;

    public String getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "LastNameStats{" +
                "lastName='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
