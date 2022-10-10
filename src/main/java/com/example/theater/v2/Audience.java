package com.example.theater.v2;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) { // 이벤트에 당첨된 관람객이라면
            bag.setTicket(ticket); // 티켓을 가방에 넣어준다.
            return 0L;
        } else { // 이벤트에 당첨되지 않은 관람객이라면
            bag.setTicket(ticket); // 티켓을 가방에 넣어준다.
            bag.minusAmount(ticket.getFee()); // 관람객의 가방에서 티켓 금액을 차감한다.
            return ticket.getFee();
        }
    }
}
