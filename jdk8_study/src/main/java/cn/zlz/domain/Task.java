package cn.zlz.domain;

/**
 * ${DESCRIPTION}
 * Created by zhanglizhi on 2016/8/4.
 */
public class Task {

    public enum Status {
        OPEAN, CLOSED;
    }

    private Status status;
    private Integer points;

    public Task(Status status, Integer points) {
        this.status = status;
        this.points = points;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
