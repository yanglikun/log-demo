package com.github.yanglikun.log4j2;

/**
 * Created by yanglikun on 2017/8/4.
 */
public class Order {

    private Long id;

    private int state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
